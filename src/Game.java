import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import Events.Event;
import Events.EventListCreator;
import Events.FightEvent;
import Loot.Item;
import Loot.ItemType;
import Loot.StatSheet;
import Monsters.Monster;
import Player.Player;

/**
 * The class that handles the game itself.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class Game{
    
    /**
     * The chain of events used for a run of the game.
     */
    private static Map<String,Event> chainEvents;
    /**
     * Returns chain of events for a given run. 
     * @return listEvents
     */
    public static Map<String,Event> getEventChain(){return chainEvents;}
    /**
     * Adds an event to the list of events for a given run.
     * TO BE REMOVED IN FINAL PRODUCT
     * @param event
     */
    public static void addToEventChain(final Event event){chainEvents.put(event.getName(),event);}

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
        Player player = new Player("Akkith", 200);

        /**
         * Test phases
         */
        // EventListCreator listEventCreator = new EventListCreator();
        // System.out.println("Complete event list : "+listEventCreator.getEventlist());
        // listEventCreator.procedureCreateEventChain();
        // System.out.println("Event chain : "+listEventCreator.getEventChain());
        /*
        Item monsterItem = new Item(1, "Weapon", ItemType.WEAPON, "description", new StatSheet(1, 0));
        Monster monsterOne = new Monster(1,"Aokithi","The monster", monsterItem,10, "startDialogue", "endDialogue", "death");
        FightEvent fightOne = new FightEvent(2, "Fight at world's end", monsterItem, "The monster stand before you", monsterOne);
        fightOne.launchEvent(player, scanner);
        System.out.println(player.getInventory());
        */


        /**
         * the actual game
         */
        
        createEventChain();
        launchChain(player, scanner); //the launch of the game is done when all events have been selected
    }

    /**
     * Creates the chain of events, stored in listEvents.
     */
    private static void createEventChain()
    {
        chainEvents = new HashMap<>(); //we create the event chain
        //in the future, the events will have to be created based on a JSON file
        //for now, a special object creates the list of all possible events
        EventListCreator listEventCreator = new EventListCreator();
        //we now create the event chain used for the run :
        listEventCreator.procedureCreateEventChain();
        chainEvents=listEventCreator.getEventChain();
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
        Iterator<String> chainIterator = getEventChain().keySet().iterator();
        while(chainIterator.hasNext()) 
        {
            getEventChain().get(chainIterator.next()).launchEvent(player, scanner);
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
