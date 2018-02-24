package com.ckorea.service.travistest.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {

	public String question;
	
	public String answer;
}
