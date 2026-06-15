package login;
import java.util.ArrayList;
import java.util.Scanner;
public class MainApp 
{
        static ArrayList<Message> sentMessages = new ArrayList<>();
        static ArrayList<Message> storedMessages = new ArrayList<>();
        static ArrayList<Message> disregardedMessages = new ArrayList<>();

        static ArrayList<String> messageIDs = new ArrayList<>();
        static ArrayList<String> messageHashes = new ArrayList<>();

        static Login login = new Login();

        public static void loadTestData() 
        {

            sentMessages.add(new Message("+27834557896", "Did you get the cake?", "Sent"));

            storedMessages.add(new Message("+27838884567",
                    "Where are you? You are late! I have asked you to be on time.",
                    "Stored"));

            disregardedMessages.add(new Message("+27834484567",
                    "Yohoooo, I am at your gate.", "Disregard"));

            sentMessages.add(new Message("+27838884567", "It is dinner time!", "Sent"));

            storedMessages.add(new Message("+27838884567", "Ok, I am leaving without you.", "Stored"));
        }

        public static String getLongestStoredMessage() 
        {
            String longest = "";
            for (Message m : storedMessages) 
            {
                if (m.getMessageText().length() > longest.length()) 
                {
                    longest = m.getMessageText();
                }
            }
            return longest;
        }

        public static Message searchMessageByID(String id) 
        {
            for (Message m : sentMessages) 
            {
                if (m.getMessageID().equals(id)) return m;
            }
            for (Message m : storedMessages) 
            {
                if (m.getMessageID().equals(id)) return m;
            }
            return null;
        }

        public static ArrayList<Message> searchByRecipient(String recipient) 
        {
            ArrayList<Message> results = new ArrayList<>();

            for (Message m : sentMessages) 
            {
                if (m.getRecipient().equals(recipient)) results.add(m);
            }

            for (Message m : storedMessages) 
            {
                if (m.getRecipient().equals(recipient)) results.add(m);
            }

            return results;
        }

        public static String deleteByHash(String hash) 
        {
            for (int i = 0; i < storedMessages.size(); i++) 
            {
                if (storedMessages.get(i).getMessageHash().equals(hash)) 
                {

                    String msg = storedMessages.get(i).getMessageText();
                    storedMessages.remove(i);

                    return "Message: \"" + msg + "\" successfully deleted";
                }
            }
            return "Message not found";
        }

        public static void displayReport() 
        {

            System.out.println("\n===== MESSAGE REPORT =====");

            for (Message m : sentMessages) 
            {
                System.out.println("HASH: " + m.getMessageHash());
                System.out.println("RECIPIENT: " + m.getRecipient());
                System.out.println("MESSAGE: " + m.getMessageText());
                System.out.println();
            }

            for (Message m : storedMessages) 
            {
                System.out.println("HASH: " + m.getMessageHash());
                System.out.println("RECIPIENT: " + m.getRecipient());
                System.out.println("MESSAGE: " + m.getMessageText());
                System.out.println();
            }
        }

        public static void main(String[] args) 
        {

            Scanner input = new Scanner(System.in);
            loadTestData();

            System.out.println("Welcome to QuickChat");

            boolean running = true;

            while (running) 
            {

                System.out.println("""

                        1. Send Message
                        2. Show Stored Messages
                        3. Display Report
                        4. Longest Message
                        5. Search by Message ID
                        6. Search by Recipient
                        7. Delete by Hash
                        8. Quit
                        """);

                int option = input.nextInt();

                switch (option) 
                {

                    case 1:
                        System.out.print("Recipient: ");
                        String rec = input.next();
                        input.nextLine();

                        System.out.print("Message: ");
                        String msgText = input.nextLine();

                        Message msg = new Message(rec, msgText, "Sent");

                        if (!msg.checkRecipientCell()) 
                        {
                            System.out.println("Invalid phone number");
                            break;
                        }

                        if (!msg.checkMessageLength()) 
                        {
                            System.out.println("Message too long");
                            break;
                        }

                        sentMessages.add(msg);
                        messageIDs.add(msg.getMessageID());
                        messageHashes.add(msg.getMessageHash());

                        System.out.println(msg.sendMessage());
                        break;

                    case 2:
                        for (Message m : storedMessages) 
                        {
                            System.out.println(m.getMessageText());
                        }
                        break;

                    case 3:
                        displayReport();
                        break;

                    case 4:
                        System.out.println(getLongestStoredMessage());
                        break;

                    case 5:
                        System.out.print("Enter ID: ");
                        String id = input.next();
                        Message found = searchMessageByID(id);
                        System.out.println(found != null ? found.getMessageText() : "Not found");
                        break;

                    case 6:
                        System.out.print("Enter recipient: ");
                        String r = input.next();
                        for (Message m : searchByRecipient(r)) 
                        {
                            System.out.println(m.getMessageText());
                        }
                        break;

                    case 7:
                        System.out.print("Enter hash: ");
                        String h = input.next();
                        System.out.println(deleteByHash(h));
                        break;

                    case 8:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option");
                }
            }

            input.close();
            
           

Login login = new Login();

System.out.println("=== REGISTER ===");

System.out.print("Username: ");
String u = input.nextLine();

System.out.print("Password: ");
String p = input.nextLine();

System.out.print("Cell: ");
String c = input.nextLine();

System.out.print("First Name: ");
String f = input.nextLine();

System.out.print("Last Name: ");
String l = input.nextLine();

System.out.println(login.registerUser(u, p, c, f, l));

System.out.println("=== LOGIN ===");

System.out.print("Username: ");
String lu = input.nextLine();

System.out.print("Password: ");
String lp = input.nextLine();

boolean status = login.loginUser(lu, lp);
System.out.println(login.returnLoginStatus(status));

if (!status) return;
        }
    }
    
    
         



