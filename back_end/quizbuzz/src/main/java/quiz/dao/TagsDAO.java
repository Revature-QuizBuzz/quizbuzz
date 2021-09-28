package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.models.Tags;

@Repository
public interface TagsDAO extends JpaRepository<Tags, Integer>{
	
	@Query(value = "SELECT * FROM tags WHERE name= ?1", nativeQuery=true)
	Tags findByName(String name);

    //public List<Tags> getAllTags();
}
