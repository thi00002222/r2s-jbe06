package app;

import dao.UserDAO;
import dao.UserDaoImpl;
import entity.User;
import exception.DAOException;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class SignUp {

    private final UserDAO userDAO = new UserDaoImpl();
    Scanner scanner = new Scanner(System.in);

    public User registerUser() {
        System.out.print("Enter desired username: ");
        String username = scanner.nextLine();

        System.out.print("Enter desired password: ");
        String password = scanner.nextLine();

        try {
            for (User user : userDAO.findAll()) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username already exists. Please choose a different username.");
                    return null;
                }
            }

            String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            User newUser = new User(username, hashed, "client");

            userDAO.insert(newUser);
            System.out.println("Sign up successful! You can now log in with your new account.");
            return newUser;

        } catch (DAOException e) {
            System.out.println("Sign up failed: " + e.getMessage());
        }
        return null;
    }
}
