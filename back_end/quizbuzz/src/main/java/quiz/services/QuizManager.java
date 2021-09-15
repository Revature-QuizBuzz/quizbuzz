package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import quiz.dao.QuizDAO;
import quiz.models.Quiz;

import java.util.List;

public interface QuizManager {
    Quiz create(Quiz quiz);
    Quiz findById(int id);
    List<Quiz> findAll();
    void deleteQuiz (Integer quizId);
}
