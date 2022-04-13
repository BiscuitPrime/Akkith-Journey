package Events;

import java.util.HashMap;
import java.util.Map;

import Loot.Item;
import Loot.ItemType;
import Loot.StatSheet;

/**
 * This class is only used to possess all the possible events that the game will use.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class EventListCreator {
    /**
     * The event list
     */
    private static Map<String,Event> eventsList;
    /**
     * Gets the event list
     * @return eventList
     */
    public Map<String,Event> getEventlist(){return eventsList;}

    /**
     * Creator 
     * @return
     */
    public EventListCreator(){
        eventsList = new HashMap<>();
    }

    /**
     * The method that creates all the various elements of the eventList.
     */
    public Map<String,Event> createEventList(){
        LoreEvent startingEvent = new LoreEvent(1, "Ruins of Oba Kilien Mok", null, "You look at the desolation that was once a glorious city. The pale fumes are the only remains amongst the charred corpses and the blackened buildings that have all but crumbled to dust. Once a glorious city, you remember. You also remember its fall, as you defended the inhabitants from the Armies of Entropy. You must have been struck, as you find your armor wrent and sword broken. Finding no souls, you decide to go for the closest city that might still stand : Ak Variv.");
        addToEventList(startingEvent);
        ChestEvent chestOne = new ChestEvent(2, "Sarcophagus of Heilith", new Item(1, "Sword of Bil Akath", ItemType.WEAPON, "The mighty sword of the last Archon under Akkalioth's orders. Under its blade, numerous angels have fallen, as the Fangs of Entropy closed upon the lucent city of Dek Ithien. It was lost during the siege of Ol Imoliv, when the archon was slain by Hildrimen, Rage Incarnate.", new StatSheet(200, 0)), "The serene golden and purple hide fades around the edges of the box. An arm's length it measures, yet some strange force emanates from this boxy monument of time past.");
        addToEventList(chestOne);
        return eventsList;
    }

    /**
     * Method that adds a given event to the list
     * @param event
     */
    private void addToEventList(final Event event){
        eventsList.put(event.getName(),event);
    }
}
