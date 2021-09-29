package quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.models.Tags;

@Repository
public interface TagsDAO extends JpaRepository<Tags, Integer>{
<<<<<<< HEAD
    @Query("SELECT t FROM Tags t WHERE t.name = ?1")
    Tags findByName(String name);
=======
	
	@Query(value = "SELECT * FROM tags WHERE name= ?1", nativeQuery=true)
	Tags findByName(String name);

>>>>>>> update-quiz
    //public List<Tags> getAllTags();
}
