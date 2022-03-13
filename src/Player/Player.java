package Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Loot.Loot;
import Loot.LootType;

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
    private Map<String,Loot> inventory;
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
    public void addToInventory(final Loot item){
        this.inventory.put(item.getName(),item);
    }

    /**
     * Constructor of the player.
     * @param name
     * @param hp
     */
    public Player(final String name, final int hp){
        this.name=name;
        this.hp=hp;
        this.inventory=new HashMap<>();
        this.addToInventory(new Loot(1,"Coin of Passage",LootType.EQUIPMENT,"A golden token forged in the pits of Uda Keiviv, symbol of the soldiers amongst the Golden Armies of Light."));
    }
}
