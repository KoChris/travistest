package com.ckorea.service.travistest.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

	public String name;
	
	public Integer overallScore;
	
	public Integer improvedScore;
	
	public List<Category> categories;
	
}
