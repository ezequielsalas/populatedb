package com.testdb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
public class DataRepositoryImpl implements DataRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertData(List<Object[]> parameters){
		jdbcTemplate.batchUpdate("INSERT INTO `testDB`.`data` (`key`, `description`) VALUES (?,?)", parameters);
	}
}
