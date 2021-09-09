package quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quiz.dao.TagsDAO;
import quiz.models.Tags;

@Service
public class TagsManagerImpl implements TagsManager{
	
	@Autowired
	private TagsDAO dao;
//	
//	@Override
//	public List<Tags> getAllTags() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Tags create(Tags t) {//adds tag to db
		return dao.save(t);
	}

}
