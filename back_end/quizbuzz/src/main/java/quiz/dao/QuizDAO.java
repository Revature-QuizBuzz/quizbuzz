package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quiz.models.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.models.Quiz;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>{
    List<Quiz> findAll();
    public Quiz findById(int id);
    
    @Query(value = "SELECT * FROM quizbuzz.quizzes WHERE name LIKE :name%", nativeQuery = true)
	List<Quiz> findByQuizName(@Param("name") String quizName);
}
