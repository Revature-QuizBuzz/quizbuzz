package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import quiz.dao.QuizDAO;
import quiz.models.Quiz;

import java.util.List;

public interface QuizManager {
    Quiz create(Quiz quiz);
    Quiz findById(int id);
    List<Quiz> findAll();
    List<Quiz> findByQuizName(String quizName);
}
