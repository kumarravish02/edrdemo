package com.tmobile.edrdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.tmobile.edrdemo.domain.Product;
import com.tmobile.edrdemo.exception.PRTSException;

public interface ProductDAOManager {
	List<Product> retrieveAll() throws SQLException, PRTSException;
}
