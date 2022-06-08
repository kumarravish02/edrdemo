package com.tmobile.edrdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.tmobile.edrdemo.domain.ColumnNames;
import com.tmobile.edrdemo.exception.PRTSException;


public interface ColumnNamesDAOManager {
	List<ColumnNames> retrieveByTableName(String tableName) throws SQLException, PRTSException;
}
