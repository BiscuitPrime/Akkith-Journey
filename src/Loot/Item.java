package Loot;

import Player.Player;

/**
 * Class used by the items.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Item {
    //name of the item
    private String name;
    public String getName(){return this.name;}
    //id of the item
    private int id;
    public int getId(){return this.id;}
    //type of the item
    private ItemType type;
    public ItemType getType(){return this.type;}
    //description of the item
    private String description;
    public String getDescription(){return this.description;}

    /**
     * Constructor of the item
     * @param id id of the item
     * @param name name of the item
     * @param type type of the item
     * @param description description of said item
     */
    public Item(final int id, final String name, final ItemType type, final String description){
        this.id=id;
        this.name=name;
        this.type=type;
        this.description=description;
    }

    /**
     * The method called when an item is obtained.
     * @param player the player that obtains the item
     * @param lootObtained the obtained item
     * @throws InterruptedException
     */
    public void obtainLoot(final Player player, final Item lootObtained) throws InterruptedException
    {
        Thread.sleep(500);
        System.out.println("You obtain the "+lootObtained.getName());
        player.addToInventory(lootObtained);
    }
}
