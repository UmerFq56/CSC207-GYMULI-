package interface_adapter.delete_chat;

public class DeleteChatState {
    private boolean success;
    private String error;


    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
