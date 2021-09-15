package quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import quiz.dao.TagsDAO;
import quiz.models.Tags;

@Service
public class TagsManagerImpl implements TagsManager{
	
	@Autowired
	private TagsDAO dao;
	
	@Override
	public List<Tags> getAllTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Tags> createTags(Tags t) {
		dao.save(t);
		return null;
	}

	

}
