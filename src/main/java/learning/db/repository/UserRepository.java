package learning.db.repository;

import learning.db.entity.User;

import java.util.List;

/**
 * @author NAgafonov
 */
public interface UserRepository {
    void createUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, String username);
    void deleteUser(Long id);
}
