package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HouseDealDaoImpl implements HouseDealDao {
    private static HouseDealDao houseDealDao;

    private HouseDealDaoImpl() {
    }

    public static HouseDealDao getHouseDealDao() {
        if (houseDealDao == null)
            houseDealDao = new HouseDealDaoImpl();
        return houseDealDao;
    }

    @Override
    public List<HouseDealDto> listHouse(String key, String word) {
        return null;
    }

    @Override
    public List<HouseDealDto> getHouse() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnect();
            String sql = "SELECT no, dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay" +
                    ", area, floor, jibun, type, rentMoney FROM housedeal";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            List<HouseDealDto> houseList = new ArrayList<>();
            while (rs.next()) {
                HouseDealDto house = new HouseDealDto();
                house.setNo(rs.getInt(1));
                house.setDong(rs.getString(2));
                house.setAptName(rs.getString(3));
                house.setCode(rs.getString(4));
                house.setDealAmount(rs.getString(5));
                house.setBuildYear(rs.getString(6));
                house.setDealYear(rs.getString(7));
                house.setDealMonth(rs.getString(8));
                house.setDealDay(rs.getString(9));
                house.setArea(rs.getString(10));
                house.setFloor(rs.getString(11));
                house.setJibun(rs.getString(12));
                house.setType(rs.getString(13));
                house.setRentMoney(rs.getString(14));

                houseList.add(house);
            }
            return houseList;
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }

    @Override
    public List<HouseDealDto> searchDong(String dongName) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnect();
            String sql = "SELECT no, dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay" +
                    ", area, floor, jibun, type, rentMoney FROM housedeal WHERE dong = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dongName);
            rs = pstmt.executeQuery();
            List<HouseDealDto> houseList = new ArrayList<>();
            while (rs.next()) {
                HouseDealDto house = new HouseDealDto();
                house.setNo(rs.getInt(1));
                house.setDong(rs.getString(2));
                house.setAptName(rs.getString(3));
                house.setCode(rs.getString(4));
                house.setDealAmount(rs.getString(5));
                house.setBuildYear(rs.getString(6));
                house.setDealYear(rs.getString(7));
                house.setDealMonth(rs.getString(8));
                house.setDealDay(rs.getString(9));
                house.setArea(rs.getString(10));
                house.setFloor(rs.getString(11));
                house.setJibun(rs.getString(12));
                house.setType(rs.getString(13));
                house.setRentMoney(rs.getString(14));

                houseList.add(house);
            }
            return houseList;
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }

    @Override
    public List<HouseDealDto> searchApt(String aptName) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnect();
            String sql = "SELECT no, dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay" +
                    ", area, floor, jibun, type, rentMoney FROM housedeal WHERE AptName LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+aptName+"%");

            rs = pstmt.executeQuery();
            List<HouseDealDto> houseList = new ArrayList<>();
            while (rs.next()) {
                HouseDealDto house = new HouseDealDto();
                house.setNo(rs.getInt(1));
                house.setDong(rs.getString(2));
                house.setAptName(rs.getString(3));
                house.setCode(rs.getString(4));
                house.setDealAmount(rs.getString(5));
                house.setBuildYear(rs.getString(6));
                house.setDealYear(rs.getString(7));
                house.setDealMonth(rs.getString(8));
                house.setDealDay(rs.getString(9));
                house.setArea(rs.getString(10));
                house.setFloor(rs.getString(11));
                house.setJibun(rs.getString(12));
                house.setType(rs.getString(13));
                house.setRentMoney(rs.getString(14));

                houseList.add(house);
                System.out.println(house);
                System.out.println("1");
            }
            return houseList;
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }
}
