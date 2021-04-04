package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.dao.NoticeDao;
import com.ssafy.happyhouse.model.dao.NoticeDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class NoticeServiceImpl implements NoticeService{

    private static NoticeService noticeService;

    private NoticeServiceImpl() {

    }

    public static NoticeService getNoticeService() {
        if (noticeService == null)
            noticeService = new NoticeServiceImpl();
        return noticeService;
    }


    @Override
    public void addNotice(NoticeDto noticeDto) throws SQLException {
        NoticeDaoImpl.getNoticeDao().addNotice(noticeDto);
    }

    @Override
    public List<NoticeDto> getNotice() throws SQLException {
        return NoticeDaoImpl.getNoticeDao().getNotice();
    }
}
