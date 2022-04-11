package Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Loot.Item;
import Loot.ItemType;
import Loot.StatSheet;

/**
 * The Player Class
 * @author : Henri 'Biscuit Prime' Nomico
 */
public class Player {
    
    /**
     * Current Health of the player
     */
    private int hp;
    /**
     * returns the player hp.
     * @return player hp
     */
    public int getHp(){
        return this.hp;
    }
    /**
     * sets the player hp.
     * @param hp : new hp being set
     */
    public void setHp(int hp){
        this.hp=hp;
    }

    /**
     * Name of the player
     */
    private String name;
    /**
     * returns player name
     * @return player name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Inventory of the player, containing all obtained items.
     */
    private Map<String,Item> inventory;
    /**
     * Returns a collection of the player's inventory
     * @return player inventory (keySet)
     */
    public Set<String> getInventory(){
        return this.inventory.keySet();
    }
    /**
     * Adds an item to the player's inventory.
     * @param item : the added item
     */
    public void addToInventory(final Item item){
        this.inventory.put(item.getName(),item);
    }

    /**
     * The ATK stat of the player
     */
    private float atk_stat;
    /**
     * Returns the ATK stat of the player
     * @return atk_stat
     */
    public float getPlayerATK(){return this.atk_stat;}

    /**
     * The Armor stat of the player
     */
    private float armor_stat;
    /**
     * Returns the player armor stat
     * @return armor_stat
     */
    public float getPlayerArmor(){return this.armor_stat;}

    /**
     * Constructor of the player.
     * @param name
     * @param hp
     */
    public Player(final String name, final int hp){
        this.name=name;
        this.hp=hp;
        this.inventory=new HashMap<>();
        this.addToInventory(new Item(1,"Coin of Passage",ItemType.EQUIPMENT,"A golden token forged in the pits of Uda Keiviv, symbol of the soldiers amongst the Golden Armies of Light.",new StatSheet(null, 100)));
        this.addToInventory(new Item(2,"Steel Sword",ItemType.WEAPON, "A simple steel sword",new StatSheet(2, null)));
    }

    /**
     * The method called by the fight event tht calculates the player's stats
     */
    public void calculateStats()
    {
        calculateATK();
        calculateArmor();
    }

    /**
     * Calculates the armor
     */
    public void calculateArmor()
    {
        System.out.println("Armor : ");
        int localArmor=0;
        //we sum up all the ATK stats in the various weapons items of the player (system to be reworked when weapon handling is added)
        for (Map.Entry<String, Item> entry : this.inventory.entrySet())
        {
            if(entry.getValue().getType()==ItemType.EQUIPMENT)
            {
                localArmor+=entry.getValue().getArmor();
            }
        }
        this.armor_stat=localArmor;
        System.out.println(this.armor_stat+"\n");

    }

    /**
     * Calculates the player ATK
     */
    public void calculateATK()
    {
        System.out.println("ATK : ");
        int localAtk=0;
         //we sum up all the ATK stats in the various weapons items of the player (system to be reworked when weapon handling is added)
        for (Map.Entry<String, Item> entry : this.inventory.entrySet())
        {
            if(entry.getValue().getType()==ItemType.WEAPON)
            {
                localAtk+=entry.getValue().getATK();
            }
        }
        this.atk_stat=localAtk;
        System.out.println(this.atk_stat+"\n");
    }

    /**
     * The dialogue played when the player is killed
     * @return
     */
    public String getDeathDialogue() {
        return "You have perished.";
    }
}
