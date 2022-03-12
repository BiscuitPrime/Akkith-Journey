package Player;
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
     * Constructor of the player.
     * @param name
     * @param hp
     */
    public Player(final String name, final int hp){
        this.name=name;
        this.hp=hp;
    }
}
