package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * class ViewModel of update profile changes view to reflect new information after user has updated it
 */
public abstract class ViewModel {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(PropertyChangeListener listener) {

        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    protected void firePropertyChanged(String propertyName, Object oldValue, Object newValue) {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }
}