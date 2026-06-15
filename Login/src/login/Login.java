package login;
import java.util.regex.Pattern;
public class Login 
{
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$";
        return Pattern.matches(regex, password);
    }

    public boolean checkCellPhoneNumber(String cellPhone) {
        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cellPhone);
    }

    public String registerUser(String username, String password,
                               String cellPhone, String firstName,
                               String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername)
                && password.equals(storedPassword);
    }

    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + firstName + ", " + lastName +
                    " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }

}


    



