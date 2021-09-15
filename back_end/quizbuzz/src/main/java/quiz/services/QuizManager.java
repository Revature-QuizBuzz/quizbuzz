package quiz.services;

import quiz.models.Quiz;

import java.util.List;

public interface QuizManager {
    List<Quiz> findAll();

    Quiz getQuizById(int id);

    Quiz updateQuiz(int quizId, Quiz quiz);
}
