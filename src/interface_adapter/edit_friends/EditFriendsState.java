package interface_adapter.edit_friends;

public class EditFriendsState {
    private String currentUser = "";
    private String addition = "";
    private String deletion = "";

    public EditFriendsState(EditFriendsState copy){
        currentUser = copy.currentUser;
        addition = copy.addition;
        deletion = copy.deletion;
    };
    public EditFriendsState() {}

    public String getCurrentUser() {
        return currentUser;
    }
    public String getAddition() {
        return addition;
    }
    public String getDeletion() {
        return deletion;
    }
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
    public void setAddition(String addition) {
        this.addition = addition;
    }
    public void setDeletion(String deletion) {
        this.deletion = deletion;
    }

}
