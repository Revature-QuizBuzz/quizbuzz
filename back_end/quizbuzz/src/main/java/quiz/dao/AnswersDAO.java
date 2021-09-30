package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quiz.models.Answers;

@Repository
public interface AnswersDAO extends JpaRepository<Answers, Integer>{
    
	@Query("SELECT a FROM Answers a where a.answer = ?1")
    Answers findByAnswer(String answer);
    
}
