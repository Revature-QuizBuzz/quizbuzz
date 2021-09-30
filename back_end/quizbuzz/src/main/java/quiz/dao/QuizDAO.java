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
import quiz.models.Tags;

import java.util.List;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {
    List<Quiz> findAll();

//    Quiz findById(int id);

    @Query("SELECT q FROM Quiz q WHERE q.user.id = ?1")
    List<Quiz> findByUserId(int userId);

    @Query("SELECT q FROM Quiz q WHERE q.tags = ?1")
    List<Quiz> findAllByTags(Tags tags);

    @Query("SELECT DISTINCT q FROM Quiz q WHERE q.name = ?1")
    Quiz findByName(String name);
    
//    @Query(value="select * from quizbuzz.quizzes limit 5", nativeQuery=true)
//    public List<Quiz> getFeaturedQuizzes();
    
    @Query(value = "SELECT distinct quizzes.quiz_id, quizzes.user_id, quizzes.name, quizzes.description, quizzes.total_score, quizzes.created_date, quizzes.date_modified FROM quizbuzz.quizzes LEFT JOIN quizbuzz.quiz_tags ON quiz_tags.quiz_id = quizzes.quiz_id INNER JOIN quizbuzz.tags ON tags.tag_id = quiz_tags.tag_id and tags.name like :name% or quizzes.name like :name%", nativeQuery = true)
	List<Quiz> findByQuizName(@Param("name") String quizName);
    
    @Query(value = "SELECT q FROM Quiz q WHERE q.user.id = ?1 AND q.name = ?2")
    Quiz findByUserAndQuizName(@Param("user_id") Integer userId, @Param("name") String quizName);
}
