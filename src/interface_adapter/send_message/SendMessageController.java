package interface_adapter.send_message;

import use_case.send_message.SendMessageInputBoundary;
import use_case.send_message.SendMessageInputData;
import entity.Message;
import entity.User;

import java.time.LocalDateTime;

public class SendMessageController {
    private final SendMessageInputBoundary sendMessageInteractor;

    public SendMessageController(SendMessageInputBoundary sendMessageInteractor) {
        this.sendMessageInteractor = sendMessageInteractor;
    }

    /**
     * creates a new Message object with the following parameters
     * @param chatName
     * @param message
     * @param time - time of message creation
     * @param sender
     * @param receiver
     */

    public void execute(String chatName, String message, LocalDateTime time, String sender, String receiver){
        SendMessageInputData inputData = new SendMessageInputData(chatName, message, LocalDateTime.now(), sender, receiver);
        sendMessageInteractor.execute(inputData);
    }
}
