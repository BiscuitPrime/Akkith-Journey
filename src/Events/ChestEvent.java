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

}
