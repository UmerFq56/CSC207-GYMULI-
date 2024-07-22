package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatFactory {
    /**
     *
     * @param chatName - name of chatroom
     * @param users - Users in Chat
     * @param noOfMembers - number of users in Chat
     * @param allmessages - all messages
     * @return new Chat object
     */
    public Chat createChat(String chatName, ArrayList<String> users, Integer noOfMembers, ArrayList<Message> allmessages, LocalDateTime time) {
        return new Chat(chatName, users, noOfMembers, allmessages, time);
    }
}
