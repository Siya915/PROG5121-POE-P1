package login;
import java.util.Scanner;
public class MainApp 
{

    public static void main(String[] args) 
    {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== REGISTER ===");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter SA cell number (+27...): ");
        String cell = input.nextLine();

        String regMessage = login.registerUser(username, password, cell, firstName, lastName);
        System.out.println(regMessage);

        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean status = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(status));
    
    
        System.out.println("\n=== MESSAGE OPTIONS ===");

        System.out.println("Enter your message:");
        String msgText = input.nextLine();

        Message msg = new Message(msgText);

        System.out.println("Message ID generated: " 
                + msg.getMessageID());

        System.out.println("""
        Choose:
        1 = Send Message
        2 = Disregard Message
        3 = Store Message
        """);

        int option = input.nextInt();

        switch(option)
        {

            case 1:
                System.out.println(msg.sendMessage());
                break;

            case 2:
                System.out.println(msg.disregardMessage());
                break;

            case 3:
                System.out.println(msg.storeMessage());
                break;

            default:
                System.out.println("Invalid option");
        }
    }
}    



