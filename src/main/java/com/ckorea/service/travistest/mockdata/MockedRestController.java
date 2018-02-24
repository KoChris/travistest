package com.ckorea.service.travistest.mockdata;

import java.util.Arrays;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckorea.service.travistest.models.Category;
import com.ckorea.service.travistest.models.Company;
import com.ckorea.service.travistest.models.YearlyScore;

@RestController
@RequestMapping("/mock/{companyName}")
public class MockedRestController {

	@CrossOrigin(origins = "*")
	@GetMapping
	public Company getCompanyData(
			@PathVariable("companyName") String companyName) {
		
		if("RBC".equalsIgnoreCase(companyName)) {
			return Company.builder()
				.name("RBC")
				.overallScore(100)
				.improvedScore(110)
				.categories(Arrays.asList(
					makeSuggestion("Benefits", 60, 74),
					makeSuggestion("Community Engagement", 70, 72)
				))
				.build();
		} else {
			return Company.builder()
				.name("Random other company")
				.overallScore(10)
				.improvedScore(9)
				.categories(Arrays.asList(
						makeSuggestion("Training", 45, 61),
						makeSuggestion("Community Involvement", 82, 85)
						))
				.build();
		}
	}
	
	private Category makeSuggestion(
			String name,
			int score,
			int iScore
			) {
		
		return Category.builder()
			.name(name)
			.actualScore(score)
			.improvedScore(iScore)
			.yearOverYear(Arrays.asList(
				YearlyScore.builder()
					.year("2012")
					.score(65)
					.build(),
				YearlyScore.builder()
					.year("2013")
					.score(67)
					.build(),
				YearlyScore.builder()
					.year("2014")
					.score(72)
					.build(),
				YearlyScore.builder()
					.year("2015")
					.score(75)
					.build()))
			.suggestions(Arrays.asList(
					"You can do this",
					"Or do this!"
					))
			.build();
		
	}
	
}
