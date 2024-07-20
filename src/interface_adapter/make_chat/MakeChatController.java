package interface_adapter.make_chat;

import use_case.make_chat.MakeChatInputBoundary;
import use_case.make_chat.MakeChatInputData;

import java.time.LocalDateTime;

public class MakeChatController {
    MakeChatInputBoundary makeChatInteractor;
    public MakeChatController(MakeChatInputBoundary makeChatInteractor) {
        this.makeChatInteractor = makeChatInteractor;
    }
    public void makeChat(String chatName, String user1, String user2, LocalDateTime time) {
        MakeChatInputData inputData = new MakeChatInputData(chatName, user1, user2, time);
        makeChatInteractor.makeChat(inputData);
    }
}
