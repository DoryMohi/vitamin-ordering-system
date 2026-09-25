import java.util.ArrayList;
import java.util.List;

///manages a list of observers and sends notifications to all listeners
public class Notifier {

    /// array list for adding and removing
    private List<NotificationListener> listeners = new ArrayList<NotificationListener>();

    public void addListener(NotificationListener listener) {
        listeners.add(listener);
    }

    public void removeListener(NotificationListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(String message) {
        for (NotificationListener listener : listeners) {
            listener.update(message);
        }
    }
}
