package com.ssafy.ws.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.dto.Product;
import com.ssafy.ws.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("list");
		try {
			mav.addObject("productList", productService.selectAll());
		} catch (SQLException e) {
			mav.setViewName("error/500");
			e.printStackTrace();
		}
		return mav;
	}
	
	@GetMapping("/registForm")
	public ModelAndView getRegistationForm(HttpSession session) {
		ModelAndView mav = new ModelAndView("regist");
		if (session.getAttribute("loginUser") == null) {
			mav.setViewName("index");
			mav.addObject("msg", "상품등록은 로그인 후 이용 가능합니다.");
		}
		
		return mav;
	}
	
	@PostMapping("/product")
	public ModelAndView addProduct(Boolean check, Product product) {
		ModelAndView mav = new ModelAndView();
		if (!check) {
			mav.setViewName("regist");
			mav.addObject("msg","중복된 코드를 가진 상품이 존재합니다.");
		} else {
			try {
				productService.insert(product);
				mav.addObject("msg", "상품 등록에 성공하였습니다.");
				mav.setViewName("regist");
			} catch (NoSuchFieldException | SQLException e) {
				e.printStackTrace();
				mav.setViewName("error/500");
			}			
		}
		
		return mav;
	}
	
	@GetMapping("/delete")
	public String delete(String pCode) {
		// 삭제 코드 
		return "delete_result";
	}
	
	@GetMapping("/update")
	public String update(String pCode) {
		// 수정 코드 
		return "update_result";
	}
	
	
	
	@GetMapping("/pcodeCheck")
	@ResponseBody // jsp 찾지않고 다이렉트로 응답함
	public String pcodeCheck(String pCode) throws SQLException { //화면을 만들어주는게 목적이 아님. 지금 보낸 상품코드가 써도 된다 안된다만 알려주면 됨.
		if(productService.select(pCode)!=null) {
			return "no"; // no.jsp 아님 주의!!
		}else {
//		이전 Servlet 작성에는 이렇게 해야함. resp.getWriter().print("yes");
			return "yes"; // yes.jsp 아님 주의!!
		}
		
	}
}

























