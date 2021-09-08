package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

}
