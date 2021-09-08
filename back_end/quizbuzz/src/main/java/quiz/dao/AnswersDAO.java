package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Answers;

@Repository
public interface AnswersDAO extends JpaRepository<Answers, Integer>{

}
