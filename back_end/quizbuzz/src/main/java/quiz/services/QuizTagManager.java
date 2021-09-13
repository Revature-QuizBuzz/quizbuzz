package quiz.services;

import java.util.List;

import quiz.models.Quiz;
import quiz.models.QuizTag;
import quiz.models.Tags;

public interface QuizTagManager {

	List<QuizTag> makeQuizTags(Quiz quiz);

	List<Tags> getTags(Quiz quiz);
	
}
