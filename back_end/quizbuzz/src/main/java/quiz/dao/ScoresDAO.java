package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Scores;

@Repository
public interface ScoresDAO extends JpaRepository<Scores, Integer>{

}
