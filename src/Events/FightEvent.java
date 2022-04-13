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
        System.out.println(monster.getName());
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
            fightSetUp(player, this.getMonster()); //we launch the method that will handle the fight setup
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

    /**
     * Method that sets up the fight by calculating the various stats
     * @param player
     * @param monster
     * @throws InterruptedException
     */
    private void fightSetUp(Player player, Monster monster) throws InterruptedException
    {
        //we start by calculating the damage and resistance of player :
        System.out.println("Your current stats :"+"\n");
        Thread.sleep(500);
        player.calculateStats();
        //now that the stats have been calculated, we launch the fight sequence :
        System.out.println("The air cools around you. The fight begins.\n");
        fightSequence(player, monster);
    }

    /**
     * The main fight sequence
     * @param player
     * @param monster
     * @throws InterruptedException
     */
    private void fightSequence(Player player, Monster monster) throws InterruptedException
    {
        
        Thread.sleep(1000);
        playerAttack(player,monster);
        if(monster.getHp()<=0) //we check here if the player has killed in one shot the monster
        {
            System.out.println(monster.getDeathDialogue());
            Thread.sleep(500);
            this.getReward().obtainLoot(player,this.getReward());
            return;
        }
        monsterAttack(player,monster);
        checkFightState(player,monster);
    }

    /**
     * The method that handles the player attacking
     * @throws InterruptedException
     */
    private void playerAttack(Player player, Monster monster) throws InterruptedException
    {
        System.out.print("You attack the monster.\n");
        Thread.sleep(500);
        monster.setHp(monster.getHp()-player.getPlayerATK());
        System.out.println("You deal "+player.getPlayerATK()+" damages to "+monster.getName()+".\n");
    }

    /**
     * The method that handles the monster attacking
     * @throws InterruptedException
     */
    private void monsterAttack(Player player, Monster monster) throws InterruptedException
    {
        System.out.print("The monster attacks you.\n");
        Thread.sleep(500);
        player.setHp(player.getHp()-monster.getATK());
        System.out.println("The monster dealt "+monster.getATK()+" damage to you.\n");
    }

    /**
     * The method that checks wether the player or the monster has died
     * @throws InterruptedException
     */
    private void checkFightState(Player player,Monster monster) throws InterruptedException
    {
        //we start by checking the monster :
        if(monster.getHp()<=0)
        {
            System.out.println(monster.getDeathDialogue());
            Thread.sleep(500);
            return;
        }
        //we then check the player :
        if(player.getHp()<=0)
        {
            System.out.println(player.getDeathDialogue());
            return;
        }
        //if we reached this point, both the monster and player are alive and well
        System.out.println("Both you and "+monster.getName()+" stand tall as the dust settles.\n");
        fightSequence(player, monster); //so we start the sequence again
    }
}
