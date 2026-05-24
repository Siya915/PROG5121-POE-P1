package login;
import java.util.UUID;
public class Message 
{

    private String messageID;
    private String messageText;

    public Message(String messageText) 
    {
        this.messageText = messageText;
        this.messageID = createMessageID();
    }

    public String createMessageID() 
    {
        return UUID.randomUUID().toString().substring(0,8);
    }

    public String getMessageID() 
    {
        return messageID;
    }

    public String sendMessage() 
    {
        return "Message successfully sent.";
    }

    public String disregardMessage() 
    {
        return "Press 0 to delete the message.";
    }

    public String storeMessage() 
    {
        return "Message successfully stored.";
    }
}

