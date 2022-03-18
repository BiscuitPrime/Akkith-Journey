package Events;

import java.util.Scanner;

import Loot.Item;
import Monsters.Monster;
import Player.Player;

/**
 * The class that handles a fight with a monster.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class FightEvent extends Event {
    
    /**
     * The enemy fought during the event.
     */
    private Monster monster;
    /**
     * Returns the monster fought during the event.
     * @return monster
     */
    public Monster getMonster(){return this.monster;}

    /**
     * Constructor of the FightEvent class.
     * @param id Id of the encounter
     * @param name Name of the encounter
     * @param loot Loot given by the event (the monster does not have the loot itself)
     * @param description Description of the encounter
     * @param monster Monster fought during the encounter
     */
    public FightEvent(final int id, final String name, final Item loot, final String description, final Monster monster)
    {
        super(id,name,loot,description);
        this.monster=monster;
    }

    /**
     * The function that handles the launch of the fight.
     * @param player 
     * @param scanner
     * @throws InterruptedException
     */
    public void launchEvent(final Player player, final Scanner scanner) throws InterruptedException
    {
        System.out.println(this.getDescription());
        Thread.sleep(500);
        System.out.println(monster.getDescription());
        Thread.sleep(500);
        System.out.println(monster.getStartingDialogue());
        Thread.sleep(500);
        System.out.println("\nDo you choose to fight this foe ? Type FIGHT to begin the fight, or FLEE to run away without loot.");
        if(waitForPlayerFightInput(scanner)=="FIGHT")//if the player choses to fight, we launch the fight subroutine
        {
            Thread.sleep(500);
            System.out.println("You chose to fight this foe.");
            fight(player, this.getMonster()); //we launch the method that will handle the fight
        }
        else
        {
            Thread.sleep(500);
            System.out.println("You chose to flee before the enemy.");
            Thread.sleep(500);
            System.out.println("You gain nothing. Your HP flails before your cowardice : you do not regen any HP.");
        }
        endEvent(player, scanner);
    }

    /**
     * The function that handles the end of the fight.
     * @throws InterruptedException
     */
    public void endEvent(final Player player, final Scanner scanner) throws InterruptedException
    {
        System.out.println("You leave behind the scars of this fight.");
    };

    /**
     * The method that handles the player's response to the fight
     * @param scanner
     * @return
     */
    public String waitForPlayerFightInput(Scanner scanner)
    {
        try
        {
            String readLine = scanner.nextLine();
            if(readLine.contains("FIGHT"))
            {
                return "FIGHT";
            }
            else if (readLine.contains("FLEE"))
            {
                return "FLEE";
            }
            else
            {
                System.out.println("Type FIGHT or FLEE to proceed.");
                waitForPlayerFightInput(scanner);
            }
            return "ERROR";
        } 
        catch (Exception e) 
        {
            return "An error occured during the WaitForPlayerFightInput of the FightEvent class";
        }
    }

    private void fight(Player player, Monster monster)
    {
        //we start by calculating the damage and resistance of player :
        player.calculateStats();
    }
}
