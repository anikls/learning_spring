package learning.db;

import learning.db.dto.UserEntity;
import learning.db.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NAgafonov
 */
public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext("learning.db");
        UserService userService = context.getBean(UserService.class);

        userService.createUser(new UserEntity(1L, "Ivan"));
        userService.createUser(new UserEntity(2L, "Jonn"));
        System.out.println(userService.getUser(1L));
        System.out.println(userService.getUser(2L));
        userService.updateUser(1L, "Bill");
        System.out.println(userService.getUser(1L));
        System.out.println(userService.getAllUsers());
        userService.deleteUser(1L);
        userService.deleteUser(2L);
        System.out.println(userService.getAllUsers());
    }
}
