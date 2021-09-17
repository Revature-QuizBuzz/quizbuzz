package quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.models.Tags;

@Repository
public interface TagsDAO extends JpaRepository<Tags, Integer>{

	
	//public List<Tags> getAllTags();
}
