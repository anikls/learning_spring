package learning.db.dao;

import learning.db.dto.UserEntity;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NAgafonov
 */
@Component
public class UserDAOImpl implements UserDAO {

    private final DataSource dataSource;

    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        System.out.println("created user "+ userEntity);
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.execute("INSERT INTO users (id,username) VALUES (" +  userEntity.getId() +",'" + userEntity.getUsername() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("created user id=" + userEntity.getId());
    }

    @Override
    public UserEntity getUser(Long id) {
        System.out.println("get user by " + id);
        UserEntity userEntity = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, username FROM Users WHERE id = " + id);
            while (rs.next()) {
                userEntity = new UserEntity();
                userEntity.setId(rs.getLong("id"));
                userEntity.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        System.out.println("get all users ");
        List<UserEntity> userEntityList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getLong("id"));
                userEntity.setUsername(rs.getString("username"));
                userEntityList.add(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntityList;
    }

    @Override
    public UserEntity updateUser(Long id, String username) {
        System.out.println("update user by " + id);
        UserEntity userEntity = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.execute("UPDATE Users SET username = '" + username + "' WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntity;
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("remove user by " + id);
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM Users WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
