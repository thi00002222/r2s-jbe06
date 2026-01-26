package app;

import dao.UserDAO;
import dao.UserDaoImpl;
import entity.User;
import exception.DAOException;
import org.mindrot.jbcrypt.BCrypt;


import java.util.Scanner;

public class Login {
    private final UserDAO userDAO = new UserDaoImpl();
    Scanner scanner = new Scanner(System.in);

    public User login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        try {
            User user = userDAO.findByUsername(username);

            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                System.out.println("Login successful! Welcome, " + user.getUsername());
                System.out.println("Your role: " + user.getRole());
                System.out.println(user.getUser_id());
                return user;
            }
//            for (User user : userDAO.findAll()) {
//                if (user.getUsername().equals(username) && BCrypt.checkpw(password, user.getPassword())) {
//                    System.out.println("Login successful! Welcome, " + user.getUsername());
//                    System.out.println("Your role: " + user.getRole());
//                    System.out.println(user.getUser_id());
//                    return user;
//                }
//            }

            System.out.println("Invalid username or password.");

        } catch (DAOException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return null;
    }
}
