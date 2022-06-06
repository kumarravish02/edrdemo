package com.tmobile.edrdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmobile.edrdemo.domain.ColumnNames;


@Repository
public interface ColumnNamesDAO extends JpaRepository<ColumnNames, String> {
	@Query(nativeQuery = true, value =
	           "SELECT column_name from all_tab_columns where table_name = :tableName")
	    List<ColumnNames> findByTableName(@Param("tableName") String tableName);

}
