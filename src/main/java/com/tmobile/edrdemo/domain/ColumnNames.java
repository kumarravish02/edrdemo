package com.tmobile.edrdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="all_tab_columns")
public class ColumnNames {

	@Id
	@Column(name="column_name")
	private String columnName;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	@Override
	public String toString() {
		return "ColumnNames [columnName=" + columnName + "]";
	}
}
