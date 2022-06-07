package com.tmobile.edrdemo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.edrdemo.dao.ProductDAOManager;
import com.tmobile.edrdemo.domain.Product;
import com.tmobile.edrdemo.exception.PRTSException;

@Service
public class ProductService {

	@Autowired
	private ProductDAOManager productDAO;
	
	public List<Product> findAll()	{
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = productDAO.retrieveAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PRTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
}
