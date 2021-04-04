package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.dao.HouseDealDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseDealServiceImpl implements HouseDealService {
    private static HouseDealService houseDealService;

    private HouseDealServiceImpl() {

    }

    public static HouseDealService getHouseDealService() {
        if (houseDealService == null)
            houseDealService = new HouseDealServiceImpl();
        return houseDealService;
    }

    @Override
    public List<HouseDealDto> listHouse(String key, String word) {
        return null;
    }

    @Override
    public List<HouseDealDto> getHouse() throws SQLException {
        return HouseDealDaoImpl.getHouseDealDao().getHouse();
    }

    @Override
    public List<HouseDealDto> searchDong(String dongName) throws SQLException {
        return HouseDealDaoImpl.getHouseDealDao().searchDong(dongName);
    }

    @Override
    public List<HouseDealDto> searchApt(String aptName) throws SQLException {
        return HouseDealDaoImpl.getHouseDealDao().searchApt(aptName);
    }
}
