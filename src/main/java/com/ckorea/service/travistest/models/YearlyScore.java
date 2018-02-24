package com.ckorea.service.travistest.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class YearlyScore {

	public String year;
	
	public int score;
	
}
