package quiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import quiz.models.Quiz;
import quiz.models.Tags;
import quiz.models.User;
import quiz.services.QuizManager;
import quiz.services.TagsManager;
import quiz.services.UserManager;

import static org.junit.Assert.assertNotEquals;

@SpringBootTest
class QuizbuzzApplicationTests {

	@Autowired
	private TagsManager manager;

	@Autowired
	private UserManager userManager;


	@Test
	void contextLoads() {
	}

//	@Test
//	void createTags(Tags tag) {
//		ResponseEntity<Tags> newTag = manager.createTags(tag);
//		assertNotEquals(newTag, null);
//	}

	@Test
	void createTags(Tags tag) {
		ResponseEntity<Tags> newTag = manager.createTags(tag);
		assertNotEquals(newTag, null);
	}

	@Autowired
	QuizManager quizManager;

	@Test
	void createQuiz() {
		String name = "Quiz from Test";
		Quiz found = quizManager.findByName(name);
		Quiz quiz = new Quiz();
		if (found == null) {
			quiz.setUser(new User(1));
			quiz.setScores(null);
			quiz.setQuestions(null);
			quiz.setTags(null);
			quiz.setName(name);
			quiz.setTotalScore(100);
			quiz.setDescription("Quiz made in QuizbuzzApplicationTest");
			quizManager.create(quiz);
			found = quizManager.findByName(name);
		}

		assertNotEquals(found, null);
	}


	@Test
	void login() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("1234");
		User found = userManager.findLogin(user);
		assertNotEquals(found, null);
	}

}
