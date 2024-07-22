package learning.db.service;

import learning.db.dto.UserDto;

import java.util.List;

/**
 * @author NAgafonov
 */
public interface UserService {

    void createUser(UserDto user);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();

    void updateUser(Long id, String newName);

    void deleteUser(Long id);

}
