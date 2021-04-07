package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	static Connection con;
    static PreparedStatement pstmt;
    static ResultSet rs;

    public int insert(BoardDto boardDto) {
        int result = 0;
        try {
        	String sql = "INSERT INTO BOARD_TB(BTITLE, BWRITER, BCONTENT) VALUES(?,?,?)";
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, boardDto.getBtitle());
            pstmt.setString(2, boardDto.getBwriter());
            pstmt.setString(3, boardDto.getBcontent());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, pstmt);
        }
        return result;
    }

    public BoardDto selectOne(int bnum) {
        BoardDto result = null;
        try {
            String sql = "SELECT BNUM, BTITLE, BCONTENT, BWRITER, BREGDATE FROM BOARD_TB "
                    +" WHERE BNUM=?";
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, bnum);

            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = new BoardDto();
                result.setBnum(rs.getInt(1));
                result.setBtitle(rs.getString(2));
                result.setBcontent(rs.getString(3));
                result.setBwriter(rs.getString(4));
                result.setBregdate(rs.getTimestamp(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pstmt, con);
        }
        return result;
    }

    public List<BoardDto> selectList(int startRow, int count){
        ArrayList<BoardDto> result = new ArrayList<>();
        try {
            String sql = "SELECT BNUM, BTITLE, BWRITER, BREGDATE FROM BOARD_TB "
                    +" ORDER BY BNUM DESC LIMIT ?,?";
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, count);

            rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardDto b = new BoardDto();
                b.setBnum(rs.getInt(1));
                b.setBtitle(rs.getString(2));
                b.setBwriter(rs.getString(3));
                b.setBregdate(rs.getTimestamp(4));

                result.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pstmt, con);
        }
        return result;
    }

    public int selectTotalCount() {
    	int result = 0;
		try {
			String sql = "SELECT COUNT(*) FROM BOARD_TB";
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
        return result;
    }
}
