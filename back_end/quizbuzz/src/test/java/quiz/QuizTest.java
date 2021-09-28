package quiz;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import quiz.models.Question;
import quiz.models.Quiz;

public class QuizTest {
	
	Quiz testQuizA;
	List<Question> emptyList;
	List<Question> qList;
	Question q1;
	Question q2;
	Question q3;

	// @Before tells JUnit to run this setup before each test method
	@Before
	public void setUp() throws Exception {
		// set up a quiz with no questions
		testQuizA = new Quiz(111);
		emptyList = new ArrayList<>();
		qList = new ArrayList<>();
		
		// create questions with no set quiz
		qList = new ArrayList<>();
		q1 = new Question(10);
		q2 = new Question(11);
		q3 = new Question(12);
		
		qList.add(q1);
		qList.add(q2);
		qList.add(q3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetQuestions() {
		// setQuestions() should take in a list of questions
		// and return void.
		
		// first show that all the quiz fields for the dummy questions are null
		Assert.assertTrue(q1.quizIsNull());
		Assert.assertTrue(q2.quizIsNull());
		Assert.assertTrue(q3.quizIsNull());
		
		testQuizA.setQuestionsQuiz(testQuizA, qList);//qList);
		
			
		Assert.assertFalse(q1.quizIsNull());
		Assert.assertFalse(q2.quizIsNull());
		Assert.assertFalse(q2.quizIsNull());
		
	}

}
