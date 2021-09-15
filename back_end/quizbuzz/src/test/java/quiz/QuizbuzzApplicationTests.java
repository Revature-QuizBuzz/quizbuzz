package quiz;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import quiz.dao.QuizDAO;
import quiz.models.Quiz;
import quiz.models.Tags;
import quiz.models.User;
import quiz.services.QuizManager;
import quiz.services.TagsManager;
import quiz.services.UserManager;

@SpringBootTest
class QuizbuzzApplicationTests {

	@Autowired
	private TagsManager manager;

	@Autowired
	private UserManager userManager;

	@InjectMocks
	QuizManager quizManager;
	@Mock
	QuizDAO quizDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void createTags(Tags tag) {
		ResponseEntity<Tags> newTag = manager.createTags(tag);
		assertNotEquals(newTag, null);
	}

	@Test
	void createQuiz() {
		Quiz quiz = new Quiz();
		quiz.setId(90000);
		quiz.setUser(new User(2));
		quiz.setScores(null);
		quiz.setQuestions(null);
		quiz.setTags(null);
		quiz.setName("Test Quiz in QuizbuzzApplication");
		quiz.setTotalScore(100);
		quiz.setDescription("Quiz made in QuizbuzzApplication");
		quizDAO.save(quiz);
//		verify(quizManager, times(1)).create(any());

		ArgumentCaptor<Quiz> captor = ArgumentCaptor.forClass(Quiz.class);
		verify(quizDAO).save(captor.capture());
		System.out.println(captor.getValue().getName());
		Assertions.assertTrue(captor.getValue().getName().equals(quiz.getName()));
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
