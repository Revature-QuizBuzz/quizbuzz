package quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import quiz.models.Scores;
import quiz.models.Tags;
import quiz.models.User;
import quiz.services.QuizManager;
import quiz.services.ScoresManager;
import quiz.services.TagsManager;
import quiz.services.UserManager;

@SpringBootTest
class QuizbuzzApplicationTests {
	
	@Autowired
	private TagsManager manager;

	@Autowired
	private UserManager userManager;
	
	// Sample test to add user score test
	@Autowired
	private ScoresManager scoreManager;  // Note: change manager to scoreManager
	@Autowired
	private QuizManager quizManager;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createTags(Tags tag) {
		ResponseEntity<Tags> newTag = manager.createTags(tag);
		assertNotEquals(newTag, null);
	}

	@Test
	void login() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("1234");
		User found = userManager.findLogin(user);
		assertNotEquals(found, null);
	}
	
	
	// Sample test to add user score test
	@Test
	public void addUserScore() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost/8080/scores"; // double check path
		Scores score = new Scores(userManager.findById(1), quizManager.findById(1), 50, new Date());
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Scores> request = new HttpEntity<>(score, httpHeader); // makes request
		Scores newScore = restTemplate.postForObject(url, request, Scores.class);
		assertEquals(1, 50); // assert statement
	}
	
}
