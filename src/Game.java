import Player.Player;

/**
 * The class that handles the game itself.
 */
public class Game {
    
    /**
     * The function that handles the game
     * @param args
     */
    public static void main(String[] args) {
        Player player = new Player("Akkith", 56);
        System.out.println(player.getName());
    }
}
