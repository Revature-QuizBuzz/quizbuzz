package quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.dao.UserDAO;
import quiz.models.User;

@Service
public class UserManagerImpl implements UserManager{

    @Autowired
    UserDAO userDAO;

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }
}
