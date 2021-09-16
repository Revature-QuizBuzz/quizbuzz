package quiz.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz.models.Question;


@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
    List<Question> findAllByQuizId(int id);
}
