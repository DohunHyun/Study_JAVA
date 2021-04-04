package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.HouseDealDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface HouseDealDao {

    //주택 검색
    List<HouseDealDto> listHouse(String key, String word);

    List<HouseDealDto> getHouse() throws SQLException;

    List<HouseDealDto> searchDong(String dongName) throws SQLException;

    List<HouseDealDto> searchApt(String aptName) throws SQLException;
}
