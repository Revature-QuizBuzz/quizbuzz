package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import quiz.dao.QuizDAO;
import quiz.models.Quiz;

import java.util.List;

public interface QuizManager {
    Quiz create(Quiz quiz);

    List<Quiz> findAll();

    List<Quiz> findByUser(int userId);

    Quiz findByName(String name);

    Quiz getQuizById(int id);
    
    void deleteQuiz (Integer quizId);

    List<Quiz> getFeaturedQuizzes();
    
    List<Quiz> findByQuizName(String quizName);
    
    Quiz findByUserAndQuizName(Integer userId, String quizName);
}
