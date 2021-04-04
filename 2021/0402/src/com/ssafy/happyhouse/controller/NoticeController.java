package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.HouseDealServiceImpl;
import com.ssafy.happyhouse.model.service.NoticeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/notice")
public class NoticeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println(1);
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        String root = request.getContextPath();

        if ("mvwrite".equals(act)) {
            response.sendRedirect(root + "/add_notice.jsp");
        } else if ("write".equals(act)) {
            addNotice(request, response);
        }
        else if("getNotice".equals(act)){
            List<NoticeDto> noticeList = null;
            try {
                noticeList = NoticeServiceImpl.getNoticeService().getNotice();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String path = "notice.jsp";
            request.setAttribute("noticeList", noticeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        }
    }

    private void getNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<NoticeDto> noticeList = NoticeServiceImpl.getNoticeService().getNotice();

        request.setAttribute("noticeList", noticeList);
        String path = "/noticebook/notice.jsp";
        request.getRequestDispatcher(path).forward(request, response);

    }

    private void addNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getContextPath();
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setSubject(request.getParameter("subject"));
        noticeDto.setContent(request.getParameter("content"));
        noticeDto.setArticlePwd(request.getParameter("noticePwd"));
        System.out.println(noticeDto.getSubject());
        try {
            NoticeServiceImpl.getNoticeService().addNotice(noticeDto);
            path = "/index.jsp";
        } catch (Exception exception) {
            exception.printStackTrace();
            request.setAttribute("msg", "글작성 중 문제가 발생했습니다");
            path = "/error/error500.jsp";

        }
        request.getRequestDispatcher(path).forward(request, response);

    }

}
