package interface_adapter.send_message;

public class SendMessageState {
    private String message = "";
    private String sender = "";
    private String receiver = "";

    public SendMessageState(SendMessageState copy){
        message = copy.message;
        sender = copy.sender;
        receiver = copy.receiver;
    }
    public SendMessageState(){}

    public String getMessage() {
        return message;

    // public String getsendMessageError(){
    //  return SendMessageError;//
    }
    public String getSender() {
        return sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


}
