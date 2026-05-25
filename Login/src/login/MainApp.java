package login;
import java.util.Scanner;
public class MainApp 
{

    public static void main(String[] args) 
    {

        Scanner input = new Scanner(System.in);

        System.out.println("===== QUICKCHAT REGISTRATION =====");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter SA cell number: ");
        String cell = input.nextLine();

        Login login = new Login(
                firstName,
                lastName,
                username,
                password,
                cell
        );

        System.out.println(login.registerUser());

        // LOGIN
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        boolean loginSuccess =
                login.loginUser(enteredUsername, enteredPassword);

        System.out.println(
                login.returnLoginStatus(loginSuccess)
        );

        // Only continue if login successful
        if (loginSuccess) 
        {

            System.out.println("\nWelcome to QuickChat.");

            boolean running = true;

            while (running) {

                System.out.println("""
                        
                        ===== MENU =====
                        1) Send Messages
                        2) Show recently sent messages
                        3) Quit
                        """);

                System.out.print("Choose option: ");

                int option = input.nextInt();
                input.nextLine();

                switch (option) 
                {

                    case 1:

                        System.out.print
                        (
                                "How many messages would you like to send? "
                        );

                        int total = input.nextInt();
                        input.nextLine();

                        for (int i = 0; i < total; i++) 
                        {

                            System.out.println(
                                    "\n===== MESSAGE "
                                            + (i + 1)
                                            + " ====="
                            );

                            System.out.print("Recipient number: ");
                            String recipient = input.nextLine();

                            System.out.print("Enter message: ");
                            String text = input.nextLine();

                            Message msg =
                                    new Message(i, recipient, text);

                            System.out.println(
                                    msg.checkRecipientCell()
                            );

                            System.out.println(
                                    msg.validateMessageLength()
                            );

                            System.out.println("""
                                    
                                    1) Send Message
                                    2) Disregard Message
                                    3) Store Message
                                    """);

                            int sendOption = input.nextInt();
                            input.nextLine();

                            System.out.println(
                                    msg.sentMessage(sendOption)
                            );

                            System.out.println(
                                    msg.printMessages()
                            );
                        }

                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        running = false;
                        System.out.println("Goodbye.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
         



