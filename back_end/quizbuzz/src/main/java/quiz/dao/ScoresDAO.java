package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Question;
import quiz.models.Scores;

import java.util.List;

@Repository
public interface ScoresDAO extends JpaRepository<Scores, Integer>{

	public List<Scores> findAll();
//  List<Scores> findAllByQuizId(int id);

}
