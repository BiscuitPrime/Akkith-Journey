package Loot;

/**
 * The enumeration for the different loots.
 * Types :
 * - WEAPON
 * - EQUIPMENT
 * - BUFF_ITEM
 * @author Henri 'Biscuit Prime' Nomico
 */
public enum ItemType{
    /**
     * Loot types :
     * - Weapon : a weapon used by the player (only one weapon can be used at once)
     * - Equipment : an equipment piece
     * - Buff item : grants a buff to the player (includes heal)
     */
    WEAPON("A mighty weapon"), EQUIPMENT("An equipment piece"), BUFF_ITEM("A buffing item");

    //the type
    private String type;

    //constructor of the lootType
    private ItemType(final String type){
        this.type=type;
    }
}