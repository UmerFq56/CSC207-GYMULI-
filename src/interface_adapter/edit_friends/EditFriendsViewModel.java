package interface_adapter.edit_friends;

import interface_adapter.ViewModel;

public class EditFriendsViewModel extends ViewModel {
    public static final String ADD_FRIEND_BUTTON_LABEL = "Add";
    public static final String DELETE_FRIEND_BUTTON_LABEL = "Delete";
    public static final String BLOCK_BUTTON_LABEL = "Block";
    public static final String UNBLOCK_BUTTON_LABEL = "Unblock";

    public EditFriendsState state = new EditFriendsState();



}
