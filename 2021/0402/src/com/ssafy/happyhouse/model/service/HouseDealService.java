package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.HouseDealDto;

import java.sql.SQLException;
import java.util.List;

public interface HouseDealService {

    List<HouseDealDto> listHouse(String key, String word);

    List<HouseDealDto> getHouse() throws SQLException;

    List<HouseDealDto> searchDong(String dongName) throws SQLException;

    List<HouseDealDto> searchApt(String aptName) throws SQLException;
}
