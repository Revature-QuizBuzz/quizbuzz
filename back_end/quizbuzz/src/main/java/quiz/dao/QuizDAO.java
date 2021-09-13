package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>{
//	List<Quiz> deleteByQuizId(int quizId);
}
