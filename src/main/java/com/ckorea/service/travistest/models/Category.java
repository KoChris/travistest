package com.ckorea.service.travistest.models;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

	public String Name;
	
	public Integer actualScore;
	
	public Integer improvedScore; 
	
	public Map<Integer, Integer> yearOverYear;
	
	public List<String> suggestions;
	
}
