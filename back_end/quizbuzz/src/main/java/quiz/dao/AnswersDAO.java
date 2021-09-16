package quiz.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quiz.models.Answers;
import quiz.models.Question;

@Repository
public interface AnswersDAO extends JpaRepository<Answers, Integer>{


}
