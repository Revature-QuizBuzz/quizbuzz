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
    
    //@Query(value = "SELECT * FROM quizbuzz.quizzes WHERE name LIKE :name%", nativeQuery = true)
    @Query(value = "SELECT distinct quizzes.quiz_id, quizzes.user_id, quizzes.name, quizzes.description, quizzes.total_score, quizzes.created_date, quizzes.date_modified FROM quizbuzz.quizzes LEFT JOIN quizbuzz.quiz_tags ON quiz_tags.quiz_id = quizzes.quiz_id INNER JOIN quizbuzz.tags ON tags.tag_id = quiz_tags.tag_id and tags.name like :name% or quizzes.name like :name%", nativeQuery = true)
    List<Quiz> findByQuizName(@Param("name") String quizName);
}
