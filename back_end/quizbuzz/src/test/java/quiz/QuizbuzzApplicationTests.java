package quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

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
	void createTags() {
		ResponseEntity<Tags> newTag = manager.createTags(null);
		assertEquals(newTag, null);
	}

	@Test
	void login() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("1234");
		User found = userManager.findLogin(user);
		assertNotEquals(found, null);
	}
	
	@Test
	public void newScore() {
		Scores testScore = new Scores(userManager.findById(1), quizManager.findById(1), 90, new Date());
		Scores newScore = scoreManager.newScore(testScore);
		//assertNotEquals(newScore.getId(), null);		
	}
	
	//Sample Test
	void validateScore() {
		
	}
	
}
