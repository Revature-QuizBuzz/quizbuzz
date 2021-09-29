package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.models.Question;
import quiz.models.Scores;


@Repository
public interface ScoresDAO extends JpaRepository<Scores, Integer>{
	List<Scores> findAll();

	@Query(value = "select * from quizbuzz.user_scores where user_id = ?1", nativeQuery=true)
	List<Scores> findMyId(int id);
}