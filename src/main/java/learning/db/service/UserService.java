package learning.db.service;

import learning.db.dto.UserEntity;

import java.util.List;

/**
 * @author NAgafonov
 */
public interface UserService {

    void createUser(UserEntity user);

    UserEntity getUser(Long id);

    List<UserEntity> getAllUsers();

    void updateUser(Long id, String newName);

    void deleteUser(Long id);

}
