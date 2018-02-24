package com.ckorea.service.travistest.mockdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

	public enum Name {
		BENEFITS("Benefits"), 
		COMMUNITY("Community Engagement"), 
		COMMUNICATIONS("Communcations"), 
		TRAINING("Training");
		
		private final String name;
		
		private Name(String s) {
			this.name = s;
		}
		
		public boolean equalsName(String otherName) {
			return this.name().equals(otherName);
		}
		
		public String toString() {
			return this.name;
		}
	}

	@CrossOrigin(origins = "*")
	@GetMapping
	public Company getCompanyData(
			@PathVariable("companyName") String companyName) {
		
		if("RBC".equalsIgnoreCase(companyName)) {
			return Company.builder()
				.name("RBC")
				.overallScore(76)
				.improvedScore(82)
				.categories(Arrays.asList(
					makeSuggestion(Name.BENEFITS, 60, 74),
					makeSuggestion(Name.COMMUNITY, 70, 72),
					makeSuggestion(Name.COMMUNICATIONS, 60, 61),
					makeSuggestion(Name.TRAINING, 88, 92)
				))
				.build();
		} else {
			return Company.builder()
				.name("Random other company")
				.overallScore(60)
				.improvedScore(79)
				.categories(Arrays.asList(
						makeSuggestion(Name.TRAINING, 45, 61),
						makeSuggestion(Name.COMMUNITY, 82, 85)
						))
				.build();
		}
	}
	
	private Category makeSuggestion(
			Name name,
			int score,
			int iScore
			) {
		
		Random r = new Random();
		int initialScore = r.nextInt(40) + 30;
		
		return Category.builder()
			.name(name.name())
			.actualScore(score)
			.improvedScore(iScore)
			.yearOverYear(Arrays.asList(
				YearlyScore.builder()
					.year("2012")
					.score(initialScore += r.nextInt(5)*3)
					.build(),
				YearlyScore.builder()
					.year("2013")
					.score(initialScore += r.nextInt(5)*5)
					.build(),
				YearlyScore.builder()
					.year("2014")
					.score(initialScore += r.nextInt(5)*2)
					.build(),
				YearlyScore.builder()
					.year("2015")
					.score(initialScore += r.nextInt(5)*3)
					.build()))
			.suggestions(this.getSuggestionList(name))
			.build();
		
	}
	
	List<String> getSuggestionList(Name name) {
		List<String> result = new ArrayList<String>();
		
		switch(name) {
		case BENEFITS:
			result.add("Parental leave and bereavement should be made available to all families");
			result.add("Your benefits package can include more coverage for services relating to transition, including gender affirmation surgery.");
			result.add("Your benefits package can be improved with inclusive language");
			break;
		case COMMUNICATIONS:
			result.add("Enhance existing public relations material with gender-neutral language.");
			result.add("Put your commitment to diversity in writing.");
			break;
		case COMMUNITY:
			result.add("Host and engage in community events which support diverse populations.");
			result.add("Provide funding to ERG (Employee Resource Groups) and encourage groups to reach out to employees.");
			break;
		case TRAINING:
			result.add("Target training to new employees as they enter and engage with your computer.");
			result.add("Regular training should be available to managers and senior executives as they engage with a diverse employee set.");
			break;
		default:
			result.add("Develop a culture of inclusion.");
			break;
		
		}
		
		return result;
	}
	
	
	
}
