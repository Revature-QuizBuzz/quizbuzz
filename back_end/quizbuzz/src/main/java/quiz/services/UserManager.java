package quiz.services;

import quiz.models.User;

public interface UserManager {
    User findById(int id);
}
