package Events;

import Loot.Loot;

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
    public String getName(){return this.name;}
    //reward of the event
    private Loot reward;
    public Loot getReward(){return this.reward;}

    /**
     * Constructor of the Event 
     */
    public Event(final int id, final String name, final Loot loot){
        this.id=id;
        this.name=name;
        this.reward=loot;
    }

    /**
     * The function that handles the launch of the associated event.
     */
    public void launchEvent(){};

    /**
     * The function that handles the end of the associated event.
     */
    public void endEvent(){};
}