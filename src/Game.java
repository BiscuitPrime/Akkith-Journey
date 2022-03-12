import Events.ChestEvent;
import Loot.Loot;
import Loot.LootType;
import Player.Player;

/**
 * The class that handles the game itself.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Game {
    
    /**
     * The function that handles the game
     * @param args
     */
    public static void main(String[] args) {
        Player player = new Player("Akkith", 56);
        ChestEvent chestOne = new ChestEvent(1, "Sarcophagus of Heilith", new Loot(1, "Sword of Bil Akath", LootType.WEAPON));
        System.out.println(chestOne.getReward().getName());
        System.out.println(player.getName());
        System.out.println(player.getHp());
    }
}
