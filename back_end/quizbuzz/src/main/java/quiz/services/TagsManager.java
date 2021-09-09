package quiz.services;

import java.util.List;

import quiz.models.Tags;

public interface TagsManager {
	
	public List<Tags> getAllTags();
	
	public Tags create(Tags t);//adds new tag to db
}
