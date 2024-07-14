package learning.db.service;

import learning.db.dao.UserDAOImpl;
import learning.db.dto.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NAgafonov
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDao;

    public UserServiceImpl(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(UserEntity user) {
        userDao.createUser(user);
    }

    @Override
    public UserEntity getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(Long id, String newName) {
        userDao.updateUser(id, newName);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

}
