package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import quiz.dao.QuizDAO;
import quiz.models.Quiz;
import quiz.models.User;

import java.util.List;

public interface QuizManager {
    Quiz create(Quiz quiz);
    Quiz findById(int id);
    List<Quiz> findAll();
    List<Quiz> findByUser(int userId);
}
