package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import quiz.dao.QuizDAO;
import quiz.models.Quiz;

public interface QuizManager {
    public Quiz create(Quiz qz);
}
