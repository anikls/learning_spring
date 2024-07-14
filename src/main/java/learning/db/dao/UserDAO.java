package learning.db.dao;

import learning.db.dto.UserEntity;

import java.util.List;

/**
 * @author NAgafonov
 */
public interface UserDAO {
    void createUser(UserEntity userEntity);
    UserEntity getUser(Long id);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(Long id, String username);
    void deleteUser(Long id);
}
