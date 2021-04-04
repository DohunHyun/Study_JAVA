package com.ssafy.happyhouse.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.UserServiceImpl;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String root = request.getContextPath();
    	String act = request.getParameter("act");
    	
    	if(act.equals("login")) {
    		login(request, response);
    	} else if(act.equals("mvjoin")) {
    		System.out.println("move to join");
    		response.sendRedirect(root+"/joinin.jsp");
    	} else if(act.equals("join")) {
    		System.out.println("join start");
    		join(request, response);
    	} else if(act.equals("mvlogin")){
			response.sendRedirect(root+"/login.jsp");
		} else if(act.equals("logout")) {
			logout(request, response);
		} else if(act.equals("mvprofile")) {
			response.sendRedirect(root+"/profile.jsp");
		} else if(act.equals("profilecheck")) {
			checkProfile(request, response);
		} else if(act.equals("profilemodify")) {
			modifyProfile(request, response);
		} else if(act.equals("mvmodify")) {
			System.out.println("check");
			response.sendRedirect(root+"/profilemodify.jsp");
		}
    }

    private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = request.getContextPath();
    	UserDto userDto = new UserDto();
    	System.out.println("request id : ");
    	System.out.println((String)request.getParameter("joinid"));
    	userDto.setUserId(request.getParameter("joinid"));
    	userDto.setUserPwd(request.getParameter("joinpwd"));
    	userDto.setUserName(request.getParameter("joinname"));
    	userDto.setUserPhone(request.getParameter("joinphone"));
    	userDto.setUserAddress(request.getParameter("joinaddress"));
    	userDto.setPreferArea(request.getParameter("joinpreferarea"));
    	System.out.println(userDto.getUserId());
    	System.out.println("가입 시작! ");
    	try {
    		UserServiceImpl.getUserService().registerUser(userDto);
    		path = "/index.jsp";
    		response.sendRedirect(request.getContextPath() + path);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("msg", "회원가입 중 문제가 발생했습니다.");
    		path = "/error/error500.jsp";
    		request.getRequestDispatcher(path).forward(request, response);
    	}
	}

	private void modifyProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = request.getContextPath();
    	UserDto userDto = new UserDto();
    	userDto.setUserId(request.getParameter("modifyid"));
    	userDto.setUserPwd(request.getParameter("modifypwd"));
    	userDto.setUserName(request.getParameter("modifyname"));
    	userDto.setUserPhone(request.getParameter("modifyphone"));
    	userDto.setUserAddress(request.getParameter("modifyaddress"));
    	userDto.setPreferArea(request.getParameter("modifypreferarea"));
    	System.out.println("수정시작! ");
    	try {
    		UserServiceImpl.getUserService().modifyUser(userDto);
    		path = "/index.jsp";
    		response.sendRedirect(request.getContextPath() + path);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("msg", "프로필 수정 중 문제가 발생했습니다.");
    		path = "/error/error500.jsp";
    		request.getRequestDispatcher(path).forward(request, response);
    	}
    	
	}

	private void checkProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String root = request.getContextPath();
    	HttpSession	session = request.getSession();
    	
    	System.out.println("====checkprofile====");
    	String profileid = request.getParameter("profileid");
    	String profilePwd = request.getParameter("profilepwd");
    	System.out.println("checkid : " + profileid);
    	
    	UserDto userDto = (UserDto) session.getAttribute("userinfo");
//    	System.out.println(userDto.getUserId());
    	if(userDto.getUserId().equals(profileid) && userDto.getUserPwd().equals(profilePwd)) {
    		System.out.println("일치 성공 ");
    		response.sendRedirect(root+"/profilecheck.jsp");
    	} else {
    		response.sendRedirect(root+"/profile.jsp");
    	}
    			
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	
    	response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		UserDto userDto = UserServiceImpl.getUserService().login(userId, userPwd);
		
		String path = "/index.jsp";
		
		if(userDto != null) { // 로그인 성공! 
			// session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userDto);
			
			// cookie 설정
			String idsv = request.getParameter("idsave");
			if("saveok".equals(idsv)) { // 아이디 저장 O
				Cookie cookie = new Cookie("save_id", userId);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
				
				response.addCookie(cookie);
			} else { // 아이디 저장 X
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
		} else { // 로그인 실패! 
			request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			path = "/error/error500.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	doGet(request, response);
    }
}
