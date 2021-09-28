package quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quiz.dao.TagsDAO;
import quiz.models.Tags;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<Tags> createTags(Tags t) {
		dao.save(t);
		return null;
	}

	@Override
	public Tags findByName(String name) {
		return dao.findByName(name);
	}


    @Autowired
    TagsDAO daoTags;

    @Override
    public List<Tags> getAllTags() {
        List<Tags> tags = daoTags.findAll();
        return tags;
    }

    @Override
    public Tags createTag(String name) {
        Tags newTag = new Tags();
        newTag.setName(name);
        return daoTags.save(newTag);
    }
    
    @Override
    public Tags getTagByName(String name) {
    	return daoTags.findByName(name);
    }

    @Override
    public List<Tags> createTags(List<String> names) {
        List<Tags> newTags = new ArrayList<>();
        List<Tags> oldTags = getAllTags();
        
        for(String name: names) {
        	if(!oldTags.contains(getTagByName(name))) {
        		Tags newTag = createTag(name);
        		newTags.add(newTag);
        	}
        }
        return newTags;
    }
}
