package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao{

    private static NoticeDao noticeDao;

    private NoticeDaoImpl() {

    }

    public static NoticeDao getNoticeDao() {
        if (noticeDao == null)
            noticeDao = new NoticeDaoImpl();
        return noticeDao;
    }


    @Override
    public void addNotice(NoticeDto noticeDto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnect();
            String sql = "insert into noticebook(subject, content, articlePwd, regtime) \n";
            sql += "values (?, ?, ?, now())";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, noticeDto.getSubject());
            pstmt.setString(2, noticeDto.getContent());
            pstmt.setString(3, noticeDto.getArticlePwd());
            pstmt.executeUpdate();
        } finally {
            DBUtil.close(pstmt,conn);
        }
    }

    @Override
    public List<NoticeDto> getNotice() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnect();
            String sql = "SELECT articleno, subject, content, articlePwd, regtime" +
                    " FROM noticebook";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<NoticeDto> noticeList = new ArrayList<>();
            while (rs.next()) {
                NoticeDto notice = new NoticeDto();
                notice.setArticleno(rs.getInt(1));
                notice.setSubject(rs.getString(2));
                notice.setContent(rs.getString(3));
                notice.setArticlePwd(rs.getString(4));
                notice.setRegtime(rs.getString(5));

                noticeList.add(notice);
                System.out.println(notice);
            }
            return noticeList;
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }
}
