package model;

import java.util.List;

// DAO 굴리는 역할. dao는 sql 전담, 단순업무
// service는 어떤 조건을 따지고 판단을 하는 역할. 

public class BookService {
	public BookDao dao = new BookDao();
	
	public List<BookDTO> getBooks() {
		return dao.selectAll();
	}

	public boolean add(BookDTO book) {
		if(book.getIsbn() == null || book.getPrice() < 0) {
			return false;
		} 
		if(dao.insert(book) == 1) {
			return true;
		}
		return false;
	}

	public String login(String id, String pw) {
		if(dao.selectUserCount(id, pw) == 0) {
			return null;
		}
		return id;
	}
}
