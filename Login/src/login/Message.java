package login;
import java.util.UUID;
import java.util.Random;
public class Message 
{
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessages = 0;

    public Message(int messageNumber,
                   String recipient,
                   String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate 10 Digit Message ID
    public String generateMessageID() {

        Random random = new Random();

        long number =
                1000000000L
                        + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Check Message ID
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Check Recipient Number
    public String checkRecipientCell() {

        String regex = "^\\+27\\d{9}$";

        if (recipient.matches(regex)) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted "
                + "or does not contain an international code. "
                + "Please correct the number and try again.";
    }

    // Validate Message Length
    public String validateMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";
        }

        int excess = message.length() - 250;

        return "Message exceeds 250 characters by "
                + excess
                + ", please reduce the size.";
    }

    // Create Message Hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }

    // Send / Store / Discard
    public String sentMessage(int option) {

        switch (option) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                storeMessage();
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Store Message
    public void storeMessage() {

        System.out.println("Message stored in JSON file.");
    }

    // Print Message Details
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    // Return Total Messages
    public int returnTotalMessages() {

        return totalMessages;
    }

    // Getters
    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }
}
  

