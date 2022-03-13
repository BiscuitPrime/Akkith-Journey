import java.util.Map;

import org.w3c.dom.ranges.Range;

import Events.ChestEvent;
import Events.Event;
import Loot.Loot;
import Loot.LootType;
import Player.Player;

/**
 * The class that handles the game itself.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Game {
    
    /**
     * The list of events used for a run of the game.
     */
    private Map<String,Event> listEvents;
    /**
     * Returns list of events for a given run. 
     * @return listEvents
     */
    public Map<String,Event> getEventList(){return listEvents;}

    /**
     * The function that handles the game
     * @param args
     */
    public static void main(String[] args) {
        createEventChain(5);
        Player player = new Player("Akkith", 56);
        ChestEvent chestOne = new ChestEvent(1, "Sarcophagus of Heilith", new Loot(1, "Sword of Bil Akath", LootType.WEAPON, "The mighty sword of the last Archon under Akkalioth's orders. Under its blade, numerous angels have fallen, as the Fangs of Entropy closed upon the lucent city of Dek Ithien. It was lost during the siege of Ol Imoliv, when the archon was slain by Hildrimen, Rage Incarnate."));
        chestOne.launchEvent();
    }

    /**
     * Creates the chain of events, stored in listEvents.
     * @param n number of events in the given chain.
     */
    private static void createEventChain(final int n)
    {
        for(int i=0;i<n;i++){

        }

    }
}
