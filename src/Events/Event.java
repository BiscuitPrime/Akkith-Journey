package Events;

/**
 * The interface used by events.
 * @author Henri 'Biscuit Prime' Nomico
 */
public interface Event{

    /**
     * The function that handles the launch of the associated event.
     */
    public void launchEvent();

    /**
     * The function that handles the end of the associated event.
     */
    public void endEvent();
}