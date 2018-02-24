package com.ckorea.service.travistest.mockdata;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckorea.service.travistest.models.Company;

@RestController
@RequestMapping("/mock/{companyName}")
public class MockedRestController {

	@CrossOrigin(origins = "*")
	@GetMapping
	public Company getCompanyData(
			@PathVariable("companyName") String companyName) {
		
		if("RBC".equals(companyName)) {
			return Company.builder()
				.name("RBC")
				.overallScore(100)
				.improvedScore(110)
				.build();
		} else {
			return Company.builder()
				.name("Random other company")
				.overallScore(10)
				.improvedScore(9)
				.build();
		}
	}
	
}
