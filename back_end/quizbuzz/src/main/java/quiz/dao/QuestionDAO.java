package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Question;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
	
	public List<Question> findAll();

    List<Question> findAllByQuizId(int id);
}
