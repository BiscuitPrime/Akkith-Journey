package Monsters;

import Loot.Item;
import Loot.ItemType;

/**
 * Monster class used by monsters.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Monster {
    //NOTE : A MONSTER DOES NOT HAVE THE LOOT - IT IS THE ASSOCIATED EVENT THAT HAS IT

    private int id;

    //name of the associated monster
    private String name;
    /**
     * gets the name of the monster.
     * @return monster's name
     */
    public String getName(){return this.name;}

    //hp of the associated monster
    private float monsterHp;
    public float getHp(){return this.monsterHp;}

    //Description of the monster, told at the beginning of the encounter
    private String description;
    /**
     * gets the starting description, for the beginning of the event.
     * @return description
     */
    public String getDescription(){return this.description;}

    //weapon used by the monster
    private Item weapon; //IT IS NOT LOOT FOR A PLAYER, BUT RATHER THE WEAPON USED BY THE MONSTER ITSELF
    public Item getWeapon(){return this.weapon;}

    //starting dialogue for the monster
    private String startingDialogue;
    public String getStartingDialogue(){return this.startingDialogue;}

    //victory dialogue when the monster kills you
    private String endDialogue;
    public String getEndDialogue(){return this.endDialogue;}

    //death dialogue for the monster (when monster killed)
    private String deathDialogue;
    public String getDeathDialogue(){return this.deathDialogue;}

    public Monster(int id, String name, String description, Item weapon, final String startDialogue, final String endDialogue, final String deathDialogue)
    {
        if(weapon.getType()!=ItemType.WEAPON)
        {
            System.out.println("Error in monster constructor : inputed item is not weapon");
        }
        this.id=id;
        this.name=name;
        this.description=description;
        this.weapon=weapon;
        this.startingDialogue=startDialogue;
        this.endDialogue=endDialogue;
        this.deathDialogue=deathDialogue;
    }
}
