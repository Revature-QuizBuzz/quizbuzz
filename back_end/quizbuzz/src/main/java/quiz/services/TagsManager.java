package quiz.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import quiz.models.Tags;

public interface TagsManager {
	
	public List<Tags> getAllTags();
	
	public ResponseEntity<Tags> createTags(Tags t) throws SQLException ;//adds new tag to db
}
