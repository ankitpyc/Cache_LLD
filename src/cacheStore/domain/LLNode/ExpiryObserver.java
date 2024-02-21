package src.cacheStore.domain.LLNode;

import java.util.Observable;
import java.util.Observer;

public class ExpiryObserver implements Observer {
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TTLNode) {
            TTLNode observableValue = (TTLNode) o;
            System.out.println("Value with key '" + observableValue.key +
                    "' has expired. Removing from the cache.");
        }
    }
}
