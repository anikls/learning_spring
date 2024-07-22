package learning.db.service;

import learning.db.dto.UserDto;
import learning.db.entity.User;
import learning.db.repository.UserRepository;
import learning.db.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NAgafonov
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepositoryImpl userDao) {
        this.userRepository = userDao;
    }

    @Override
    public void createUser(UserDto user) {
        userRepository.createUser(new User(user.getId(), user.getUsername()));
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.getUser(id);
        return new UserDto(user.getId(), user.getUsername());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(Long id, String newName) {
        userRepository.updateUser(id, newName);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

}
