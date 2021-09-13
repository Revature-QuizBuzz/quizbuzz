package quiz.services;

import org.springframework.stereotype.Service;

import quiz.dao.QuizDAO;

@Service
public class QuizManagerImpl implements QuizManager {
	
	QuizDAO quizDAO;
	
	public QuizManagerImpl (QuizDAO quizDAO) {
		this.quizDAO = quizDAO;
	}
	
	@Override
	public void deleteQuiz(Integer quizId) {
		quizDAO.deleteById(quizId);
	}
}
