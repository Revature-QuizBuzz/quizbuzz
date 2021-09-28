package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.models.Tags;

@Repository
public interface TagsDAO extends JpaRepository<Tags, Integer>{
    @Query("SELECT t FROM Tags t WHERE t.name = ?1")
    Tags findByName(String name);
    //public List<Tags> getAllTags();
}
