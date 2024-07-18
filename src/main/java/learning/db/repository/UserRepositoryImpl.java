package learning.db.repository;

import learning.db.entity.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NAgafonov
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createUser(User user) {
        System.out.println("created user "+ user);
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.execute("INSERT INTO users (id,username) VALUES (" +  user.getId() +",'" + user.getUsername() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("created user id=" + user.getId());
    }

    @Override
    public User getUser(Long id) {
        System.out.println("get user by " + id);
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, username FROM Users WHERE id = " + id);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("get all users ");
        List<User> userList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User updateUser(Long id, String username) {
        System.out.println("update user by " + id);
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.execute("UPDATE Users SET username = '" + username + "' WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
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
