package app;

import dao.UserDAO;
import dao.UserDaoImpl;
import entity.User;
import exception.DAOException;
import exception.GlobalExceptionHandler;
import form.UserForm;
import util.Constants;

import java.util.List;
import java.util.Scanner;

public class UserApp {
    public static boolean isAdmin(User user) {
        return user.getRole().equalsIgnoreCase("ADMIN");
    }

    public static void run(User loggedInUser) {


        UserDAO UserDAO = new UserDaoImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. List all users");
            System.out.println("2. Update user");
            System.out.println("3. Delete user");
            System.out.println("4. Find user by ID");
            System.out.println("0. Back to main menu");
            System.out.print("Choose: ");
            String choiceInput = scanner.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            try {

                switch (choice) {
                    case 1:
                        if (!isAdmin(loggedInUser)) {
                            System.out.println("Access denied. Admins only.");
                            break;
                        }

                        try {
                            List<User> users = UserDAO.findAll();
                            System.out.println(Constants.USER_HEADER);
                            for (User u : users) {
                                System.out.printf(Constants.USER_ROW_FORMAT + "%n", u.getUser_id(), u.getUsername(), u.getRole());
                            }

                        } catch (DAOException e) {
                            GlobalExceptionHandler.handle(e);
                        }
                        break;

                    case 2:
                        UserDAO.update(UserForm.inputUpdateUserForm(loggedInUser));
                        break;
                    case 3:
                        if (!isAdmin(loggedInUser)) {
                            System.out.println("Access denied. Admins only.");
                            break;
                        }

                        System.out.print("Enter User ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        UserDAO.delete(deleteId);
                        System.out.println("User deleted successfully.");
                        break;
                    case 4:
                        if (!isAdmin(loggedInUser)) {
                            System.out.println("Access denied. Admins only.");
                            break;
                        }

                        User user = UserDAO.findById(UserForm.inputUserId("find"));

                        if (user == null) {
                            System.out.println("User not found");
                        }else {
                            System.out.println(Constants.USER_HEADER);
                            System.out.printf(Constants.USER_ROW_FORMAT + "%n", user.getUser_id(), user.getUsername(), user.getRole());
                        }

                        break;
                    case 0:

                        System.out.println("Goodbye!");
                        return;
                    default:

                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } catch (DAOException e) {
                GlobalExceptionHandler.handle(e);
            }
        }
    }
}


