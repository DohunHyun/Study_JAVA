package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDTO;
import model.BookService;

@WebServlet("/book")
public class BookServlet extends HttpServlet { // controller
	private BookService service = new BookService(); // servlet -> service 일시키기 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		String path = "";
		
		if(cmd == null || cmd.equals("list")) {
			List<BookDTO> bookList = service.getBooks();
			req.setAttribute("bookList", bookList);
			path = "book_list.jsp";
			
		} else if(cmd.equals("addForm")) {
			path = "book_add.jsp";
		} else if(cmd.equals("loginForm")) {
			path = "login_form.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String cmd = req.getParameter("cmd");
		String path = "";
		
		if(cmd.equals("add")) {
			String isbn = req.getParameter("isbn");
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String priceStr = req.getParameter("price");
			String publisher = req.getParameter("publisher");
			
			BookDTO book = 
					new BookDTO(isbn, title, author, publisher, Integer.parseInt(priceStr));
			
			System.out.println(book);
			
			if(service.add(book)) {
				req.setAttribute("addResult", "success");
//				path = "book_add_success.jsp";
			} else {
				req.setAttribute("addResult", "fail");
//				path = "book_add_fail.jsp";
			}
			path = "book_add_result.jsp";
			
		} else if(cmd.equals("login")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			if(service.login(id,pw) == null) { // login 실패 
				req.setAttribute("loginResult", "fail");
			} else { // login 성공 
				// 세션 기록해서 로그인 상태 유지하도록 하자 
				req.getSession().setAttribute("loginInfo", id);
				req.setAttribute("loginResult", "success");
			}
			path = "login_result.jsp";
			
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
		
	}

}
