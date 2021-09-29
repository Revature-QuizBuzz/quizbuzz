package quiz.services;

import java.sql.SQLException;
import quiz.models.Tags;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TagsManager {
	

    List<Tags> getAllTags();

    Tags createTag(String name);

    List<Tags> createTags(List<String> name);
    
    Tags getTagByName(String name);

    Tags findByName(String name);
	
	public ResponseEntity<Tags> createTags(Tags t) throws SQLException ;//adds new tag to db
	
	public ResponseEntity<Integer> deleteTags(Integer t) throws SQLException;
}
