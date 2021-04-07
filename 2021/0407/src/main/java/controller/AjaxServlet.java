package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.BoardService;
import model.CommentDto;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet{
	private BoardService service = new BoardService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json");
		resp.setCharacterEncoding("utf-8");
		
		String act = req.getParameter("act");
		
		resp.setContentType("text/json;charset=utf-8");
		if("cmtList".equals(act)) { // bnum 게시글에 달린 댓글들 보기 
			String bnumStr = req.getParameter("bnum");
			int bnum = Integer.parseInt(bnumStr);
			
			List<CommentDto> cmtList = service.getCmtList(bnum);
			Gson gs = new Gson();
			resp.getWriter().write(gs.toJson(cmtList));
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json");
		resp.setCharacterEncoding("utf-8");
		
		req.setCharacterEncoding("utf-8");
		
		String act = req.getParameter("act");
		
		if("cmtWrite".equals(act)) {
			String bnumStr = req.getParameter("bnum");
			int bnum = Integer.parseInt(bnumStr);
			String cwriter = req.getParameter("cwriter");
			String ccontent = req.getParameter("ccontent");
			
			CommentDto cmtDto = new CommentDto();
			cmtDto.setBnum(bnum);
			cmtDto.setCwriter(cwriter);
			cmtDto.setCcontent(ccontent);
			
			resp.setContentType("text/text");
			
			if(service.writeComment(cmtDto)) {
				resp.getWriter().write("success");
			} else {
				resp.getWriter().write("fail");
			}
		}
	}

}
