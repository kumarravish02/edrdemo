package com.tmobile.edrdemo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.edrdemo.dao.ColumnNamesDAOManager;
import com.tmobile.edrdemo.domain.ColumnNames;
import com.tmobile.edrdemo.exception.PRTSException;


@Service
public class ColumnNamesService {

	@Autowired
	private ColumnNamesDAOManager columnNamesDAO;
	
	public List<ColumnNames> findByTableName(String tableName)	{
		List<ColumnNames> columnList = new ArrayList<ColumnNames>();
		try {
			columnList = columnNamesDAO.retrieveByTableName(tableName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PRTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnList;
	}
}
