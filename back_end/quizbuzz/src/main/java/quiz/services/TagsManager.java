package quiz.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import quiz.models.Tags;

public interface TagsManager {
	
	public List<Tags> getAllTags();

    Tags findByName(String name);
	
	public ResponseEntity<Tags> createTags(Tags t) throws SQLException ;//adds new tag to db
	
	public ResponseEntity<Integer> deleteTags(Integer t) throws SQLException;
}
