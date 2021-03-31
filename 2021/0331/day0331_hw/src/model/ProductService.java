package model;

import java.util.List;

public class ProductService {
	public ProductDao dao = new ProductDao();
	
	public List<ProductDTO> getProducts() {
		return dao.selectAll();
	}
	
	public boolean add(ProductDTO product) {
		if(product.getSerialnum() == null || product.getPrice() < 0) {
			return false;
		}
		if(dao.insert(product) == 1) {
			return true;
		}
		return false;
	}
	
	public boolean login(String id, String pw) {
		if(dao.selectUser(id, pw)) {
			System.out.println("service login suc");
			return true;
		}
		return false;
	}
	

}
