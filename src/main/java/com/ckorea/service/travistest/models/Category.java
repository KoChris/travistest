package com.ckorea.service.travistest.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

	public String name;
	
	public Integer actualScore;
	
	public Integer improvedScore; 
	
	public List<YearlyScore> yearOverYear;
	
	public List<String> suggestions;
	
}
