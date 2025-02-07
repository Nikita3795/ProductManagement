package com.pro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private SessionFactory sf;

	public String insertProduct(Product pro) {

		Session ss = sf.openSession();

		Transaction tr = ss.beginTransaction();

		ss.save(pro);

		tr.commit();
		ss.close();

		return "Products saved";

	}

	public String insertMultipleProduct(List<Product> pros) {

		Session ss = sf.openSession();

		Transaction tr = ss.beginTransaction();

		for (Product pro : pros) {

			ss.save(pro);
		}

		tr.commit();
		ss.close();

		return "All Products saved";

	}

	public List<Product> getAllProducts() {

		Session ss = sf.openSession();

		Criteria cr = ss.createCriteria(Product.class);

		return cr.list();
	}

	public List<Product> productByCategory2(String cat) {

		Session ss = sf.openSession();

		List<Product> products = ss.createCriteria(Product.class)
				.add(Restrictions.ilike("category", "%" + cat + "%"))
				.list();

		return products;
	}
	
	public List<Product> allProductsAscPrice(){
		
		Session ss = sf.openSession();
		
		List<Product> pros = ss.createCriteria(Product.class)
				.addOrder(Order.asc("price"))
				.list();
		
		return pros ;
	}

	public List<Product> allProductsDscPrice() {
	Session ss = sf.openSession();
		
		List<Product> pros = ss.createCriteria(Product.class)
				.addOrder(Order.desc("price"))
				.list();
		
		return pros ;
	}

}
