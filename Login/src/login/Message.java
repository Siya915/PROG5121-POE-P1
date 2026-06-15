package login;
import java.util.UUID;
import java.util.Random;
public class Message 
{
  private static int totalMessages = 0;

    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String status;

    public Message(String recipient, String messageText, String status) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.status = status;

        this.messageID = createMessageID();
        totalMessages++;

        this.messageHash = createMessageHash();
    }

    public String createMessageID() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public String createMessageHash() {
        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":" + totalMessages
                + ":" + firstWord + lastWord;
    }

    public boolean checkRecipientCell() {
        return recipient.matches("^\\+27[0-9]{9}$");
    }

    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    public String sendMessage() {
        return "Message successfully sent.";
    }

    public String storeMessage() {
        return "Message successfully stored.";
    }

    public String disregardMessage() {
        return "Press 0 to delete the message.";
    }

    // getters
    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getStatus() { return status; }    
}

  

