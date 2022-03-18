package Events;

import java.util.Scanner;

import Loot.Item;
import Player.Player;

/**
 * The class used by events.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Event
{
    //id of the chest event
    private int id;
    public int getId(){return this.id;}
    //Name of the Chest event
    private String name;
    /**
     * Returns the name of the event.
     * @return name of the event
     */
    public String getName(){return this.name;}
    //reward of the event
    private Item reward;
    /**
     * Returns the reward of the event.
     * @return the reward
     */
    public Item getReward(){return this.reward;}
    //description of the event
    private String eventDescription;
    /**
     * Returns the description of the event.
     * @return event's description
     */
    public String getDescription(){return this.eventDescription;}

    /**
     * Constructor of the event.
     * @param id : id of the event
     * @param name : name of the event
     * @param loot : loot that is rewarded by the event
     * @param description : description of said event
     */
    public Event(final int id, final String name, final Item loot, final String description){
        this.id=id;
        this.name=name;
        this.reward=loot;
        this.eventDescription=description;
    }

    /**
     * The function that handles the launch of the associated event.
     * @throws InterruptedException
     */
    public void launchEvent(final Player player, final Scanner scanner) throws InterruptedException{};

    /**
     * The function that handles the end of the associated event.
     * @throws InterruptedException
     */
    public void endEvent(final Player player, final Scanner scanner) throws InterruptedException{};
}