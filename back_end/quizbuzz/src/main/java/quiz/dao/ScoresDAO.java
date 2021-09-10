package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Scores;

@Repository
public interface ScoresDAO extends JpaRepository<Scores, Integer>{
	
	public List<Scores> findAll();

}
