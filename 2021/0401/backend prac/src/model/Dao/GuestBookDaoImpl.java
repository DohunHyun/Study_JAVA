package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Dto.GuestBookDto;
import util.DBUtil;

public class GuestBookDaoImpl implements GuestBookDao {
	
	// for singleton
	private GuestBookDaoImpl() {}
	private static GuestBookDaoImpl guestBookDaoImpl;
	public static GuestBookDaoImpl getGuestBookDaoImpl() {
		if(guestBookDaoImpl == null) {
			guestBookDaoImpl = new GuestBookDaoImpl();
		}
		return guestBookDaoImpl;
	}
	// for singleton


	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnect();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into guestbook (userid, subject, content, regtim)\n");
			insertMember.append("values (?,?,?,now())");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, guestBookDto.getUserId());
			pstmt.setString(2, guestBookDto.getSubject());
			pstmt.setString(3, guestBookDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws SQLException {
		
		
		return null;
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws SQLException {
		return null;
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws SQLException {
		
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		
	}

}
