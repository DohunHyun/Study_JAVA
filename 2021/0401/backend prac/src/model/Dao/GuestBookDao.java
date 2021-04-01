package model.Dao;

import java.sql.SQLException;
import java.util.List;

import model.Dto.GuestBookDto;

public interface GuestBookDao {
	
	// 글작성 
	void registerArticle(GuestBookDto guestBookDto) throws SQLException;
	
	// 글목록 
	List<GuestBookDto> listArticle(String key, String word) throws SQLException;
	
	// 글 수정을 위한 글 얻기
	GuestBookDto getArticle(int articleNo) throws SQLException;
	
	// 글수정 
	void modifyArticle(GuestBookDto guestBookDto) throws SQLException;
	
	// 글삭제 
	void deleteArticle(int articleNo) throws SQLException;

}
