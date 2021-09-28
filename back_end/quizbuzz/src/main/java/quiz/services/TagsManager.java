package quiz.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import quiz.models.Tags;

public interface TagsManager {
	
	//public List<Tags> getAllTags();
	
	public ResponseEntity<Tags> createTags(Tags t);//adds new tag to db

    Tags findByName(String name);
}
