package Loot;

import java.util.Optional;

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
    //Stats of the item are contained in a statSheet object:
    private StatSheet statSheet;
    /**
     * Returns the Armor value (may be null)
     * @return Armor (Optional<Float>)
     */
    public Integer getArmor(){
        return statSheet.getArmor();
    }
    /**
     * Returns the ATK value (may be null)
     * @return ATK (Optional<Float>)
     */
    public Integer getATK(){
        return statSheet.getATK();
    }

    /**
     * Constructor of the item
     * @param id id of the item
     * @param name name of the item
     * @param type type of the item
     * @param description description of said item
     * @param statSheet StatSheet object associated with the item
     */
    public Item(final int id, final String name, final ItemType type, final String description, final StatSheet statSheet){
        this.id=id;
        this.name=name;
        this.type=type;
        this.description=description;
        this.statSheet=statSheet;
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
