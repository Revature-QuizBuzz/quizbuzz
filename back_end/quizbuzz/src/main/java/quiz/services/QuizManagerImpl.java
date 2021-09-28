package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.QuizDAO;
import quiz.models.Quiz;

import java.util.List;

import quiz.dao.QuizDAO;

@Service
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QuizDAO daoQuiz;

    @Override
    public Quiz create(Quiz quiz){
        return daoQuiz.save(quiz);
    }

    @Override
    public Quiz findById(int id) {
        return daoQuiz.findById(id);
    }

    @Override
    public List<Quiz> findAll() {
        return daoQuiz.findAll();
    }

    @Override
	public void deleteQuiz(Integer quizId) {
		daoQuiz.deleteById(quizId);
	}
    public List<Quiz> findByUser(int userId) {
        return daoQuiz.findByUserId(userId);
    }

    @Override
    public Quiz findByName(String name) {
        return daoQuiz.findByName(name);
    }

}
