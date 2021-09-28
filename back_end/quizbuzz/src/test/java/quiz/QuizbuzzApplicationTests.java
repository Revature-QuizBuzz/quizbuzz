package quiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import quiz.models.*;
import quiz.services.*;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/*

@SpringBootTest
class QuizbuzzApplicationTests {

	@Autowired
	private TagsManager tagsManager;

	@Autowired
	private UserManager userManager;

	@Autowired
	QuizManager quizManager;

	@Autowired
	QuestionManager questionManager;

	@Autowired
	AnswersManager answersManager;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createTags(Tags tag) {
//		ResponseEntity<Tags> newTag = manager.createTags(tag);
//		assertNotEquals(newTag, null);
//	}

	@Test
	void createQuiz() {
		String name = "Coffee Quiz";
		Quiz found = quizManager.findByName(name);
		Quiz quiz = new Quiz();
		if (found == null) {
			quiz.setUser(new User(1));
			quiz.setScores(null);
			quiz.setQuestions(null);
			quiz.setTags(null);
			quiz.setName(name);
			quiz.setTotalScore(100);
			quiz.setDescription("Quiz about coffee.");
			quizManager.create(quiz);
			found = quizManager.findByName(name);
		}

		assertNotEquals(found, null);
		assertEquals(found.getName(),name);
	}

	@Test
	void createQuestion() {
		if(quizManager.findByName("Coffee Quiz") == null)
			createQuiz();
		String name = "What does coffee equal?";
		Question found = questionManager.findByQuestion(name);
		Question question = new Question();
		if (found == null) {
			question.setQuestion(name);
			question.setAnswers(null);
			question.setQuiz(quizManager.findByName("Coffee Quiz"));
			question.setPossiblePoints(100);
			question.setType("multiplechoice");
			questionManager.create(question);
			found = questionManager.findByQuestion(name);
		}

		assertNotEquals(found, null);
	}

	@Test
	void createAnswer() {
		if(questionManager.findByQuestion("What does coffee equal?") == null)
			createQuestion();
		String answer = "Coffee equals enlightenment.";
		Answers found = answersManager.findByAnswer(answer);
		Answers answers = new Answers();
		if (found == null) {
			answers.setAnswer(answer);
			answers.setCorrect(true);
			answers.setQuestion(questionManager.findByQuestion("What does coffee equal?"));
			answersManager.create(answers);
			found = answersManager.findByAnswer(answer);
		}

		assertNotEquals(found, null);
	}

	@Test
	void createTags() {
		if(quizManager.findByName("Coffee Quiz") == null)
			createQuiz();
		String name = "Hot Drinks";
		Tags found = tagsManager.findByName(name);
		Tags newTags = new Tags();
		if (found == null) {
			newTags.setName(name);
			List<Quiz> quizSet = new ArrayList<>();
			quizSet.add(quizManager.findByName("Coffee Quiz"));
			newTags.setQuizzes(quizSet);
			tagsManager.createTags(newTags);
			found = tagsManager.findByName(name);
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
*/
