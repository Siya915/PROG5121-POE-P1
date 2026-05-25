package login;
import java.util.regex.Pattern;
public class Login 
{
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName,
                 String username,
                 String password,
                 String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Username Validation
    public boolean checkUserName() {

        return username.contains("_")
                && username.length() <= 5;
    }

    // Password Validation
    public boolean checkPasswordComplexity() {

        String regex =
                "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+=|<>?{}\\[\\]~-]).{8,}$";

        return password.matches(regex);
    }

    // Cell Phone Validation
    public boolean checkCellPhoneNumber() {

        String regex = "^\\+27\\d{9}$";

        return cellPhoneNumber.matches(regex);
    }

    // Register User
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; "
                    + "please ensure that your username contains "
                    + "an underscore and is no more than five "
                    + "characters in length.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; "
                    + "please ensure that the password contains "
                    + "at least eight characters, a capital letter, "
                    + "a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted "
                    + "or does not contain international code.";
        }

        return "User registered successfully.";
    }

    // Login Verification
    public boolean loginUser(String enteredUsername,
                             String enteredPassword) {

        return enteredUsername.equals(username)
                && enteredPassword.equals(password);
    }

    // Login Status
    public String returnLoginStatus(boolean loginSuccess) {

        if (loginSuccess) {

            return "Welcome "
                    + firstName + " "
                    + lastName
                    + " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}


    



