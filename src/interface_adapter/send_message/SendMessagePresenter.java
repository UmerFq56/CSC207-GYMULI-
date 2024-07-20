package interface_adapter.send_message;

import use_case.send_message.SendMessageOutputData;
import use_case.send_message.SendMessageOutputBoundary;

public class SendMessagePresenter implements SendMessageOutputBoundary {

    private final SendMessageViewModel sendMessageViewModel;

    public SendMessagePresenter(SendMessageViewModel sendMessageViewModel) {
        this.sendMessageViewModel = sendMessageViewModel;
    }


    @Override
    public void prepareSuccessView(SendMessageOutputData message) {

    }

    @Override
    public void prepareFailView(String Error){
        //SendMessageState sendMessageState = SendMessageViewModel.getState();
        // sendMessageState.setsendMessageError(error);
        sendMessageViewModel.firePropertyChanged();

    }

}
