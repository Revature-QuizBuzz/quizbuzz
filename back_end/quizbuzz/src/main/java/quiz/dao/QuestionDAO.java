package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Question;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
    List<Question> findAllByQuizId(int id);
}
