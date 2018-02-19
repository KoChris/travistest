package com.ckorea.service.travistest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class TestRestController {

	@RequestMapping("/hack")
	public String somemethod(){
		return "JKALsjD";
	}
	
	
	
}
