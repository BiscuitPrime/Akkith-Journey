package Events;

import java.io.Console;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import Loot.Loot;
import Loot.LootType;
import Player.Player;

/**
 * the class used by Chest Events.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class ChestEvent extends Event {

    /**
     * constructor of the ChestEvent.
     */
    public ChestEvent(final int id, final String name, final Loot loot, final String description){
        super(id,name,loot, description);
    }

    /**
     * Launches the chest event, with the displayed description and according words.
     * @param player the player 
     * @throws InterruptedException
     */
    public void launchEvent(final Player player, final Scanner scanner) throws InterruptedException{
        System.out.println("You find the " + this.getName() + ".");
        Thread.sleep(500);
        System.out.println(this.getDescription());
        Thread.sleep(500);
        System.out.println("\nDo you wish to open the chest ? Type YES if you want to open it or NO if you want to leave.");
        //we test wether or not the player wants to open the chest :
        if(waitForPlayerOpenInput(scanner)=="YES")
        {
            Thread.sleep(500);
            System.out.println("\nYou open the " + this.getName());
            Thread.sleep(500);
            System.out.println("Inside, amongst relics of old past, you find the "+this.getReward().getName());
            Thread.sleep(500);
            //Dependent on the loot type, different outputs
            switch(this.getReward().getType())
            {
                case WEAPON :
                    System.out.println("You carefully take the weapon, as dust and specks of dirt crumble over it.");
                    break;
                case EQUIPMENT :
                    System.out.println("You take the equipment, as it cracks in your fingers.");
                    break;
                case BUFF_ITEM :
                    System.out.println("You take the item, as insects cower from it.");
                default:
                    break;
            }
            Thread.sleep(500);
            this.getReward().obtainLoot(player,this.getReward()); //we call the method that handles the loot being obtained by the player
            Thread.sleep(500);
        } 
        else if(waitForPlayerOpenInput(scanner)=="NO") //if the player doesn't open the chest :
        {
            System.out.println("\nYou decide not to open the chest.");
        }
        endEvent(player, scanner); //the end event function is called directly, for chest events, by the launch event as no other interruptions are in the way
    }

    /**
     * Ends the chest event
     * @param player
     * @param scanner : the scanner that handles the player's inputs
     * @throws InterruptedException
     */
    public void endEvent(final Player player, final Scanner scanner) throws InterruptedException{
        System.out.println("You leave behind the "+this.getName());
    }

    private String waitForPlayerOpenInput(final Scanner scanner)
    {
        try 
        {
            String readLine = scanner.nextLine();
            if(readLine.contains("YES"))
            {
                return "YES";
            }
            else if (readLine.contains("NO"))
            {
                return "NO";
            }
            else
            {
                System.out.println("Type YES or NO to proceed.");
                waitForPlayerOpenInput(scanner);
            }
            return "ERROR";
        } 
        catch (Exception e) 
        {
            //TODO: handle exception
            return "An error occured during the WaitForPlayerOpenInput of the ChestEvent class";
        }
    }
}
