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

import com.tmobile.edrdemo.domain.ColumnNames;
import com.tmobile.edrdemo.exception.PRTSException;

@Repository
public class ColumnNamesDAOImpl implements ColumnNamesDAOManager {

	private NamedParameterJdbcTemplate namedParameterjdbcTemplate;

	@Autowired
    public void setDataSource(@Qualifier("onedatajdbcDS") DataSource dataSource) {
		this.namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
	
	@Override
	public List<ColumnNames> retrieveByTableName(String tableName) throws SQLException, PRTSException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		ArrayList<ColumnNames> columnNameList = new ArrayList<ColumnNames>();
		try {
			String query= "SELECT column_name from all_tab_columns where table_name = :tableName";
			parameters.put("tableName", tableName);

			columnNameList = (ArrayList<ColumnNames>) namedParameterjdbcTemplate
					.query(query, parameters,
							new ColumnNameRowMapper());
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		} catch (DataAccessException dae) {
			throw new PRTSException(dae);
		} catch (Exception e) {
			throw new PRTSException(e);
		}
		
		return columnNameList;
	}
	
	private static final class ColumnNameRowMapper implements RowMapper<ColumnNames> {
		public ColumnNames mapRow(ResultSet rs, int rowNum) throws SQLException {
			ColumnNames columnNames = new ColumnNames();
			columnNames.setColumnName(rs.getString("COLUMN_NAME"));
			return columnNames;
		}
	}

}
