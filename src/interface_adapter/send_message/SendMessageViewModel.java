package interface_adapter.send_message;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SendMessageViewModel extends ViewModel {
    public final String SENDMESSAGE_BUTTON_LABEL = "Send";
    public final String SENDMESSAGE_TEXT = "Send Message";
    public final String RECIPIENT_LABEL = "Recipient";
    //do we have to have a text intake box? for writing the text//

    private SendMessageState state = new SendMessageState();

    public SendMessageViewModel() {
    }

    public void setState(SendMessageState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SendMessageState getState(){
        return state;
    }

}
