package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
