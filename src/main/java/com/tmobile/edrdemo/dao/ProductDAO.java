package com.tmobile.edrdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tmobile.edrdemo.domain.Product;
import com.tmobile.edrdemo.exception.PRTSException;

@Repository
public class ProductDAO implements ProductDAOManager {
	private NamedParameterJdbcTemplate namedParameterjdbcTemplate;

	@Autowired
    public void setDataSource(@Qualifier("hssjdbcDS") DataSource dataSource) {
		this.namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
	
	@Override
	public List<Product> retrieveAll() throws SQLException, PRTSException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			String query= "select name,description from [dbo].[product]";
		//	parameters.put("tableName", tableName);

			productList = (ArrayList<Product>) namedParameterjdbcTemplate
					.query(query, parameters,
							new ProductRowMapper());
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		} catch (DataAccessException dae) {
			throw new PRTSException(dae);
		} catch (Exception e) {
			throw new PRTSException(e);
		}
		
		return productList;
	}
	
	private static final class ProductRowMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			return product;
		}
	}
}
