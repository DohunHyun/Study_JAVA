package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.NoticeDto;

import java.sql.SQLException;
import java.util.List;

public interface NoticeService {

    void addNotice(NoticeDto noticeDto) throws SQLException;

    List<NoticeDto> getNotice() throws SQLException;
}
