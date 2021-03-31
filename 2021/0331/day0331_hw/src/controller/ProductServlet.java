package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDTO;
import model.ProductService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private ProductService service = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		String path = "";
		
		if(cmd.equals("list")) {
			List<ProductDTO> productList = service.getProducts();
			req.setAttribute("productList", productList);
			path = "product_list.jsp";
			
		} else if(cmd.equals("addForm")) {
			path = "product_add.jsp";
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
			String serialnum = req.getParameter("serialnum");
			String title = req.getParameter("title");
			String priceStr = req.getParameter("price");
			String description = req.getParameter("description");
			
			ProductDTO product = new ProductDTO(serialnum, title, Integer.parseInt(priceStr), description);
			
			System.out.println(product);
			
			if(service.add(product)) {
				req.setAttribute("addResult", "success");
				
			} else {
				req.setAttribute("addResult", "fail");
			}
			path = "product_add_result.jsp";
			
		} else if(cmd.equals("login")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			if(service.login(id, pw)) {
				req.getSession().setAttribute("loginInfo", id);
				req.setAttribute("loginResult", "success");
			} else {
				req.setAttribute("loginResult", "fail");
			}
			path = "login_result.jsp";
			
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
		
	}

}
