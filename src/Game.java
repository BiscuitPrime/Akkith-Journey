import java.io.Console;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import Events.ChestEvent;
import Events.Event;
import Events.FightEvent;
import Events.LoreEvent;
import Loot.Item;
import Loot.ItemType;
import Monsters.Monster;
import Player.Player;

/**
 * The class that handles the game itself.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Game {
    
    /**
     * The list of events used for a run of the game.
     */
    private static Map<String,Event> listEvents;
    /**
     * Returns list of events for a given run. 
     * @return listEvents
     */
    public static Map<String,Event> getEventList(){return listEvents;}
    /**
     * Adds an event to the list of events for a given run.
     * @param event
     */
    public static void addToEventList(final Event event){listEvents.put(event.getName(),event);}

    /**
     * the scanner that will be used to read inputs.
     */
    public static Scanner scanner;

    /**
     * The function that handles the game
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException 
    {
        scanner = new Scanner(System.in);
        Player player = new Player("Akkith", 56);

        /**
         * Test phases
         */
        Monster monsterOne = new Monster(1,"Aoi","The monster",new Item(1, "Weapon", ItemType.WEAPON, "description"), "startDialogue", "endDialogue", "death");
        FightEvent fightOne = new FightEvent(2, "Fight at world's end", new Item(3, "Sword from monster", ItemType.EQUIPMENT, "An helmet"), "The monster stand before you", monsterOne);
        fightOne.launchEvent(player, scanner);
        System.out.println(player.getInventory());

        /**
         * the actual game
         */
        /*
        createEventChain(2);
        launchChain(player, scanner); //the launch of the game is done when all events have been selected
        */
    }

    /**
     * Creates the chain of events, stored in listEvents.
     * @param n number of events in the given chain.
     */
    private static void createEventChain(final int n)
    {
        listEvents = new HashMap<>(); //we create the event chain
        LoreEvent startingEvent = new LoreEvent(1, "Ruins of Oba Kilien Mok", null, "You look at the desolation that was once a glorious city. The pale fumes are the only remains amongst the charred corpses and the blackened buildings that have all but crumbled to dust. Once a glorious city, you remember. You also remember its fall, as you defended the inhabitants from the Armies of Entropy. You must have been struck, as you find your armor wrent and sword broken. Finding no souls, you decide to go for the closest city that might still stand : Ak Variv.");
        ChestEvent chestOne = new ChestEvent(2, "Sarcophagus of Heilith", new Item(1, "Sword of Bil Akath", ItemType.WEAPON, "The mighty sword of the last Archon under Akkalioth's orders. Under its blade, numerous angels have fallen, as the Fangs of Entropy closed upon the lucent city of Dek Ithien. It was lost during the siege of Ol Imoliv, when the archon was slain by Hildrimen, Rage Incarnate."), "The serene golden and purple hide fades around the edges of the box. An arm's length it measures, yet some strange force emanates from this boxy monument of time past.");
        addToEventList(startingEvent);
        addToEventList(chestOne);
    }

    /**
     * The function that launches the chain and so the game.
     * @param player
     * @param scanner
     * @throws InterruptedException
     */
    private static void launchChain(final Player player, final Scanner scanner) throws InterruptedException
    {
        System.out.println("You awake in a strange place.");
        Thread.sleep(500);
        Iterator<String> chainIterator = getEventList().keySet().iterator();
        while(chainIterator.hasNext()) 
        {
            getEventList().get(chainIterator.next()).launchEvent(player, scanner);
            waitForPlayerEnterInput(player);
        }
        scanner.close();//we close the scanner at the end of the game.
    }

    /**
     * The function that waits for a player input to switch events
     */
    public static void waitForPlayerEnterInput(final Player player)
    {
        System.out.println("\nPress any key to continue or type E to display player stats.");
        String readLine = scanner.nextLine();
        if(readLine.contains("E"))
        {
            System.out.println("\nPlayer stats :");
            System.out.println("Name : "+player.getName());
            System.out.println("Hp : " + player.getHp());
            System.out.println(player.getName()+" inventory :");
            System.out.println(player.getInventory());
            waitForPlayerEnterInput(player);
        }
        System.out.println("\n");
    }
}
