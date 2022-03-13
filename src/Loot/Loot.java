package Loot;

import Player.Player;

/**
 * Class used by the loot items.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Loot {
    //name of the loot
    private String name;
    public String getName(){return this.name;}
    //id of the loot
    private int id;
    public int getId(){return this.id;}
    //type of the loop
    private LootType type;
    public LootType getType(){return this.type;}
    //description of the loot
    private String description;
    public String getDescription(){return this.description;}

    /**
     * Constructor of the loot item
     * @param id id of the loot
     * @param name name of the loot
     * @param type type of the loot
     * @param description description of said loot
     */
    public Loot(final int id, final String name, final LootType type, final String description){
        this.id=id;
        this.name=name;
        this.type=type;
        this.description=description;
    }

    /**
     * The method called when a loot is obtained.
     * @param player the player that obtains the loot
     * @param lootObtained the obtained loot
     */
    public void obtainLoot(final Player player, final Loot lootObtained)
    {
        System.out.println("You obtain the "+lootObtained.getName());
        player.addToInventory(lootObtained);
    }
}
