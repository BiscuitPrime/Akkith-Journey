package Events;

import java.util.Scanner;

import Loot.Item;
import Player.Player;

/**
 * The class for the lore events, that act as simple passage between other events.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class LoreEvent extends Event {
    
    /**
     * Constructor of the Lore Event.
     * @param id : id of event
     * @param name : name of the event
     * @param loot : MUST BE NULL FOR A LORE EVENT (avoid waste of time)
     */
    public LoreEvent(final int id, final String name, final Item loot, final String description){
        super(id,name,null, description);
    }

    /**
     * The function that handles the launch of the associated event.
     * @param player
     * @param scanner : the scanner used to read player's input
     * @throws InterruptedException
     */
    public void launchEvent(final Player player, final Scanner scanner) throws InterruptedException{
        System.out.println("You come across the "+this.getName());
        Thread.sleep(500);
        System.out.println(this.getDescription());
        Thread.sleep(500);
        endEvent(player, scanner);
    }

    /**
     * The function that handles the end of the associated event.
     * @param player
     * @param scanner : the scanner used to read player's input
     * @throws InterruptedException
     */
    public void endEvent(final Player player, final Scanner scanner) throws InterruptedException{
        System.out.println("You leave "+this.getName());
        Thread.sleep(500);
        System.out.println("Behind you, the air shivers as the shadows claim back what you left.");
    }
}
