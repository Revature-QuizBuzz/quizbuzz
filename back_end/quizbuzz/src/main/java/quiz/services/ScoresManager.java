package quiz.services;

import java.util.List;

import quiz.models.Scores;

public interface ScoresManager {
	
	List<Scores> findAll();

	Scores newScore(Scores score);

}
