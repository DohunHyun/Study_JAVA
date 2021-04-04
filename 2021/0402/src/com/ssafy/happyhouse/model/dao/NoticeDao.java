package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.NoticeDto;

import java.sql.SQLException;
import java.util.List;

public interface NoticeDao {
    void addNotice(NoticeDto noticeDto) throws SQLException;

    List<NoticeDto> getNotice() throws SQLException;
}
