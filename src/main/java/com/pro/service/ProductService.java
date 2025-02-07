package com.pro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.ProductDao;
import com.pro.entity.Product;

@Service
public class ProductService {
	

	@Autowired
	private ProductDao pd;

	public String insertProduct(Product pro) {

		return pd.insertProduct(pro);
	}

	public String insertMultipleProduct(List<Product> pros) {

		return pd.insertMultipleProduct(pros);
	}

	public List<Product> getAllProducts() {
		return pd.getAllProducts();
	}

	public List<Product> productByCategory(String cat) {

		List<Product> pros = new ArrayList<Product>();

		for (Product pro : pd.getAllProducts()) {

			if(pro != null && pro.getCategory().toLowerCase().contains(cat.toLowerCase())) {
				
				pros.add(pro);
			}
		}
		return pros;

	}
	
	public List<Product> productByCategory2(String cat) {
	
		return pd.productByCategory2(cat); 
	}

	public List<Product> allProductsAscPrice() {
	
		return pd.allProductsAscPrice();
	}

	public List<Product> allProductsDscPrice() {
		// TODO Auto-generated method stub
		return pd.allProductsDscPrice() ;
	}

}
