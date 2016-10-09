package com.testdb.data;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
	
	private int quantity;

	public DataGenerator(int quantity) {

		this.quantity = quantity;
	}
	
	public List<Object[]> generateData(){
		List<Object[]> data = new ArrayList<Object[]>();
		for(int x = 0; x < quantity; x++){
			   data.add(new Object[] {"key"+x, "description"+x});
		}
		return data;
	}

}
