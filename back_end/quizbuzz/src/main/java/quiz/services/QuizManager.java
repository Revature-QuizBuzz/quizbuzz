package quiz.services;

import quiz.models.Quiz;

import java.util.List;

public interface QuizManager {
    Quiz create(Quiz quiz);

    Quiz findById(int id);

    List<Quiz> findAll();

    List<Quiz> findByUser(int userId);

    Quiz findByName(String name);
    List<Quiz> getFeaturedQuizzes();
}
