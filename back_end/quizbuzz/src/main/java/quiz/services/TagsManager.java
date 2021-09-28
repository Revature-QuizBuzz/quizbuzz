package quiz.services;

import quiz.models.Tags;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TagsManager {
	
	//public List<Tags> getAllTags();
	
	public ResponseEntity<Tags> createTags(Tags t);//adds new tag to db

    List<Tags> getAllTags();

    Tags createTag(String name);

    List<Tags> createTags(List<String> name);
    
    Tags getTagByName(String name);

    Tags findByName(String name);
}
