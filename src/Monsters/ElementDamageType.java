package Monsters;

/**
 * The different element damage types used in the game.
 * All the types : 
 * @ELEMENTS
 * - SHADOW
 * - LIGHT
 * - DARKNESS
 * - ENTROPY
 * - LIFE
 * - DEATH
 */
public enum ElementDamageType {
    /**
     * The different elemental types.
     */
    SHADOW(""),LIGHT(""),DARKNESS(""),ENTROPY(""),LIFE(""),DEATH("");

    /**
     * The type of the element.
     */
    private String type;

    /**
     * Constructor of the elementDamageType.
     * @param type
     */
    private ElementDamageType(final String type){
        this.type=type;
    }
}
