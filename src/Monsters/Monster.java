package Monsters;

import Loot.Loot;

/**
 * Monster class used by monsters.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Monster {
    //NOTE : A MONSTER DOES NOT HAVE THE LOOT - IT IS THE ASSOCIATED EVENT THAT HAS IT

    private int id;
    private String name;
    private String description;
    private Loot weapon; //IT IS NOT LOOT FOR A PLAYER, BUT RATHER THE WEAPON USED BY THE MONSTER ITSELF
    
}
