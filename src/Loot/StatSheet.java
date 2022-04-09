package Loot;

import java.util.Optional;

/**
 * Class used for the stat sheets of equipments, items and such.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class StatSheet {
    /**
     * The ATK stat
     */
    private Integer ATK;
    /**
     * Returns the ATK value that may be null
     * @return ATK value (Integer)
     */
    public Integer getATK(){
        return this.ATK;
    }

    /**
     * The Armor stat
     */
    private Integer Armor;
    /**
     * Returns the Armor value that may be null
     * @return Armor value (Integer)
     */
    public Integer getArmor(){
        return this.Armor;
    }

    /**
     * Constructor of the Statsheet
     * @param atk : ATK value (Integer)
     * @param armor : Armor value (Integer)
     */
    public StatSheet(final Integer atk, final Integer armor)
    {
        this.ATK=atk;
        this.Armor=armor;
    }
}
