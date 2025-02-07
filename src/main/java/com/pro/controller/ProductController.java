package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Product;
import com.pro.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService ps;

	@PostMapping("/insertpro")
	public String insertProduct(@RequestBody Product pro) {

		return ps.insertProduct(pro);
	}

	@PostMapping("/insertmultipro")
	public String insertMultipleProduct(@RequestBody List<Product> pros) {

		return ps.insertMultipleProduct(pros);
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return ps.getAllProducts();

	}

	@GetMapping("/bycat/{cat}")
	public List<Product> productByCategory(@PathVariable String cat) {

		return ps.productByCategory(cat);
	}

	@GetMapping("/bycatt/{cat}")
	public List<Product> productByCategory2(@PathVariable String cat) {

		return ps.productByCategory2(cat);

	}

	@GetMapping("/asc")
	public List<Product> allProductsAscPrice() {

		return ps.allProductsAscPrice();
	}

	@GetMapping("/dsc")
	public List<Product> allProductsDscPrice() {

		return ps.allProductsDscPrice();
	}
}
