package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Question;
import quiz.models.QuizTag;

import java.util.List;

@Repository
public interface QuizTagDAO extends JpaRepository<QuizTag, Integer>{
    List<QuizTag> findAllByQuizId(int id);
}
