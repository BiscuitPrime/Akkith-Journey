package Events;

import Loot.Loot;
import Monsters.Monster;

/**
 * The class that handles a fight with a monster.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class FightEvent extends Event {
    
    /**
     * The enemy fought during the event.
     */
    private Monster monster;
    /**
     * Returns the monster fought during the event.
     * @return monster
     */
    public Monster getMonster(){return this.monster;}

    /**
     * Constructor of the FightEvent class.
     * @param id Id of the encounter
     * @param name Name of the encounter
     * @param loot Loot given by the event (the monster does not have the loot itself)
     * @param description Description of the encounter
     * @param monster Monster fought during the encounter
     */
    public FightEvent(final int id, final String name, final Loot loot, final String description, final Monster monster)
    {
        super(id,name,loot,description);
        this.monster=monster;
    }
}
