package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDto;
import model.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String act = req.getParameter("act");
		
		if(act == null || act.equals("list")) { // 게시판 목록보기 요청 
			String pageStr = req.getParameter("page");
			int page = 1; // 기본 
			if(pageStr != null) { // 페이지 요청이 있으면 
				page = Integer.parseInt(pageStr);
			}
			req.setAttribute("pageInfo", service.makePage(page));
			req.getRequestDispatcher("board_list.jsp").forward(req, resp);
		} else if(act.equals("write")) {
			// 로그인 세션 확인해서 할 수도 있음 
			req.getRequestDispatcher("board_write.jsp").forward(req, resp);
		} else if(act.equals("read")) {
			String bnumStr = req.getParameter("bnum");
			try {
				int bnum = Integer.parseInt(bnumStr);
				BoardDto boardDto = service.read(bnum);
				if(boardDto != null) {
					req.setAttribute("boardDto", boardDto);
					req.getRequestDispatcher("board_read.jsp").forward(req, resp);
				} else {
					throw new Exception("글번호 없음");
				}
			} catch(Exception ex) {
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String act = req.getParameter("act");
		
		if("write".equals(act)) {
			BoardDto boardDto = new BoardDto();
			boardDto.setBtitle(req.getParameter("btitle"));
			boardDto.setBwriter(req.getParameter("bwriter"));
			boardDto.setBcontent(req.getParameter("bcontent"));
			if(service.write(boardDto)) {
				// 일반적으로 forward 하면 되는데 새로고침 문제가 있음... 
				req.getRequestDispatcher("write_success.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("write_fail.jsp").forward(req, resp);
				
			}
		}
	}

}
