package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car = new Car("Ухмобиль1", 3);
        Car car1 = new Car("Ухмобиль2", 5);
        Car car2 = new Car("Ухмобиль3", 7);
        Car car3 = new Car("Ухмобиль4", 9);

        User user = new User("User1", "Lastname1", "user1@mail.ru");
        User user1 = new User("User2", "Lastname2", "user2@mail.ru");
        User user2 = new User("User3", "Lastname3", "user3@mail.ru");
        User user3 = new User("User4", "Lastname4", "user4@mail.ru");

        user.setCar(car);
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);


        userService.add(user);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        for (User u : userService.listUsers()) {
            System.out.print(u);
            System.out.println(u.getCar());
        }


        System.out.println(userService.getUserCar("Ухмобиль3", 7));


//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

        context.close();
    }
}
