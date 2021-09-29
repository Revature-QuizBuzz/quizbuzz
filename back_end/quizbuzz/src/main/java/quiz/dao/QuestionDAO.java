package quiz.dao;

import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> main
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quiz.models.Question;


@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
	
	public List<Question> findAll();

    @Query("SELECT q FROM Question q where q.question = ?1")
    Question findByQuestion(String question);
    
    @Query(value = "SELECT * FROM quizbuzz.questions WHERE quiz_id= ?1", nativeQuery=true)
    List<Question> findAllByQuizId(int id);
}
