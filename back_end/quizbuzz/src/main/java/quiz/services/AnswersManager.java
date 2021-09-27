package quiz.services;
import java.util.List;

import quiz.models.Answers;

public interface AnswersManager {
	
	List< Answers> findAll(int id);
	List<Answers> getAllAnswers();
		
}
