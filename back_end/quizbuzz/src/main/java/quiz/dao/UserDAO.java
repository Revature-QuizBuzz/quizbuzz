package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.models.ScoreBoard;
import quiz.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
//
//	@Query(value = "SELECT user_id, f_name, total_points, total_possible_points, point_percentage FROM quizbuzz.users", nativeQuery = true)
//	public List<Object> findScoreBoard();
	
	@Query(value = "SELECT user_id AS id, f_name as firstName, total_points AS totalPoints, total_possible_points AS possiblePoints, point_percentage AS pointPercentage FROM quizbuzz.users", nativeQuery = true)
	List<ScoreBoard> findScoreBoard();
}
