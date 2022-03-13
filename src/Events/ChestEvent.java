package Events;

import Loot.Loot;

/**
 * the class used by Chest Events.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class ChestEvent extends Event {

    /**
     * constructor of the ChestEvent.
     */
    public ChestEvent(final int id, final String name, final Loot loot){
        super(id,name,loot);
    }

    /**
     * Launches the chest event, with the displayed description and according words.
     */
    public void launchEvent(){
        System.out.println("You find the " + this.getName() + ".");
        System.out.println("You open the " + this.getName());
        System.out.println("Inside, amongst relics of old past, you find the "+this.getReward().getName());
        System.out.println("You carfully take the object, as dust and specks of dirt crumble over it.");
        this.getReward().obtainLoot(this.getReward()); //we call the method that handles the loot being obtained by the player
    }

}
