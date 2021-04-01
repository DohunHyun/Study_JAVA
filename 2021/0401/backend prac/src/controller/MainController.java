package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dto.GuestBookDto;
import model.Dto.MemberDto;
import model.service.GuestBookServiceImpl;
import model.service.MemberServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		if(act.equals("mvregister")) {
			response.sendRedirect(root + "/user/join.jsp");
		} else if(act.equals("mvwrite")) {
			response.sendRedirect(root+"/guestbook/write.jsp");
		} else if(act.equals("write")) {
			registerArticle(request, response);
		} else if(act.equals("login")) {
			login(request, response);
		} else if(act.equals("logout")) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		MemberDto memberDto = MemberServiceImpl.getMemberServiceImpl().login(userId, userPwd);
		
		String path = "/index.jsp";
		if(memberDto != null) {
			// session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
			
			// cookie 설정 
			String idsv = request.getParameter("idsave");
			if(idsv.equals("saveok")) { // 아이디 저장 
				Cookie cookie = new Cookie("save_id", userId);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60*24*365*40);
				
				response.addCookie(cookie);
			} else { // 아이디 저장 안함 
				Cookie cookies[] = request.getCookies();
				if(cookies != null) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("save_id")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
							break;
						}
					}
				}
			}
		} else {
			request.setAttribute("ms", "가입하지 않은 아이디이거나 잘못된 비밀번호 입니다");
			path = "error/error500.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	private void registerArticle(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto != null) {
			GuestBookDto guestBookDto = new GuestBookDto();
			guestBookDto.setUserId(memberDto.getUserId());
			guestBookDto.setSubject(request.getParameter("subject"));
			guestBookDto.setContent(request.getParameter("content"));
			
			try {
				GuestBookServiceImpl.getGuestBookServiceImpl().registerArticle(guestBookDto);
				path = "/guestbook/writesuccess.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 작성 중에 문제가 발생했습니다.");
				path = "/error/error500.jsp";
			}
		} else {
			request.setAttribute("msg", "로그인 후 사용 가능합니다");
			path = "/user/login.jsp";
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
