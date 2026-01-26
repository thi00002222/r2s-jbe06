package form;

import entity.User;
import org.mindrot.jbcrypt.BCrypt;
import util.ScannerUtil;

public class UserForm {

    public static User inputUpdateUserForm(User loggedInUser) {
        String username = ScannerUtil.readNonEmptyString("Enter new username: ");
        String password = ScannerUtil.readNonEmptyString("Enter new password: ");

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt()); // In a real application, hash the password here
        return new User(loggedInUser.getUser_id(),username, hashedPassword, loggedInUser.getRole());

    }

    public static int inputUserId(String action) {
        return ScannerUtil.readInt("Enter user ID to " + action + ": ");
    }
}
