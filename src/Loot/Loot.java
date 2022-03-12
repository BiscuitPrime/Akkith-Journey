package Loot;

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

    //constructor of the loot
    public Loot(final int id, final String name, final LootType type){
        this.id=id;
        this.name=name;
        this.type=type;
    }
}
