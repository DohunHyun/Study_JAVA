package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.service.HouseDealService;
import com.ssafy.happyhouse.model.service.HouseDealServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/house")
public class HouseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        String path = "";

        if ("mvdong".equals(act)) {
            List<HouseDealDto> houseList = null;
            Set<String> dongSet = new HashSet<>();
            try {
                houseList = HouseDealServiceImpl.getHouseDealService().getHouse();
                for (HouseDealDto house : houseList) {
                    dongSet.add(house.getDong());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("dongSet", dongSet);
            path = "search_dong.jsp";
        } else if ("mvapt".equals(act)) {
            path = "search_apart.jsp";

        } else if ("searchDong".equals(act)) {
            String dongName = request.getParameter("dong");
            List<HouseDealDto> houseList = null;
            try {
                houseList = searchDong(dongName);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("houseList", houseList);
            request.setAttribute("dongName", dongName);
            path = "result_dong.jsp";
        } else if ("searchApt".equals(act)) {
            String aptName = request.getParameter("apt");
            List<HouseDealDto> houseList = null;
            try {
                houseList = searchApt(aptName);
                System.out.println(houseList);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("houseList", houseList);
            request.setAttribute("aptName", aptName);
            path = "result_apt.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    private List<HouseDealDto> searchApt(String aptName) throws SQLException {
        return HouseDealServiceImpl.getHouseDealService().searchApt(aptName);
    }

    private List<HouseDealDto> searchDong(String dongName) throws SQLException {
        return HouseDealServiceImpl.getHouseDealService().searchDong(dongName);
    }


}
