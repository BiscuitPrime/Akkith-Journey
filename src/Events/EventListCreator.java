package Events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Loot.Item;
import Loot.ItemType;
import Loot.StatSheet;
import Monsters.Monster;

/**
 * This class is only used to possess all the possible events that the game will use.
 * @author Henri 'Biscuit Prime' Nomico
 */
public class EventListCreator {
    /**
     * The complete event list
     */
    private static Map<String,Event> eventsList;
    /**
     * Gets the event list
     * @return eventList
     */
    public Map<String,Event> getEventlist(){return eventsList;}
    /**
     * Method that adds a given event to the list
     * @param event
     */
    private void addToEventList(final Event event){
        eventsList.put(event.getName(),event);
    }

    /**
     * Events chain
     */
    private static Map<String, Event> eventsChain;
    /**
     * Gets the event chain
     * @return eventChain
     */
    public Map<String,Event> getEventChain(){return eventsChain;}
    public void addToEventChain(final Event event){eventsChain.put(event.getName(),event);}

    private int chance_pourcentage;
    private int id_flag;
    private Event last_added_event;

    /**
     * Creator of the EventListCreator class. 
     * In it, we create a list of all possible events.
     * @return
     */
    public EventListCreator(){
        eventsList = new HashMap<>();
        createEventList();
        chance_pourcentage=50;
    }

    /**
     * The method that creates all the various elements of the eventList.
     */
    public void createEventList(){
        //we create the various objects of the game :
        Item entropicArmorSword = new Item(0, "Sword", ItemType.WEAPON, "Entropic armor weapon", new StatSheet(7, 0));
        Monster entropicArmor = new Monster(0, "Entropic Armor", "The decrepit remains of a knight long gone, animated by the wills of the Akrakon Pantheon. The half-wrent armor cracks and bends as it seeks anything alive.", entropicArmorSword, 20, "*menacing crackling noises*", "*breaking noises*", "*shattering noises*");
        Item wrentHelmet1 = new Item(1, "Wrent Helmet", ItemType.EQUIPMENT, "A broken helmet. Under the dust you can still make out the flowery crest of Terra.", new StatSheet(0, 30));
        Item wrentHelmet2 = new Item(1, "Wrent Helmet", ItemType.EQUIPMENT, "A broken helmet. Under the dust you can still make out the flowery crest of Terra.", new StatSheet(0, 30));
        Item boneTentacle = new Item(2, "Bone Tentacle", ItemType.WEAPON, "A cackling bone tentacle stripped from the octopus' fading body. Sturdy as metal, you can use it as a flail.", new StatSheet(10, 0));
        Monster chaosOctopus = new Monster(1, "Chaos Octopus", "A giant octopus of bones that will crush anyone who would dare enter its territory. Born in the deepest reaches of the Next Plane, its bony hide is covered with obsidian relics of ages past.", boneTentacle, 25, "*wierd guttering sounds*", "*weird sounds*", "*weird fainting sounds*");
        //we create and add the events :
        addToEventList(new FightEvent(1, "Battle at Om Kili", wrentHelmet1, "In the ruined streets of Om Kili, you find an Entropic Armor. The bodyless purple metal machine walks with you with burning hatred.", entropicArmor));
        addToEventList(new LoreEvent(1, "Mist over Kareth Oba", null, "You watch the thick mist falling over the small village of Kareth Oba. The wretched wooden remains of old burned-down houses point to the sky like accusing fingers."));
        addToEventList(new LoreEvent(2, "Somber Docks of Virith", null, "You discover the docks of Virith, a small port on the Night Sea. The old wooden boats are but consumed remnants of ashes, skeletons littering the rocky docks."));
        addToEventList(new FightEvent(2, "Encounter at Virith's Docks", boneTentacle, "As you walk along the Virith docks, you are attacked by a dozen grasping tentacles of hard bones, rupturing the land as they flail around you. A monstrous white figure emerges from the sea, fires unquenched for hatred burning deep in the holes of its skull. A Chaos Octopus has emerged from its wake.", chaosOctopus));
        ChestEvent chestOne = new ChestEvent(2, "Sarcophagus of Heilith", new Item(1, "Sword of Bil Akath", ItemType.WEAPON, "The mighty sword of the last Archon under Akkalioth's orders. Under its blade, numerous angels have fallen, as the Fangs of Entropy closed upon the lucent city of Dek Ithien. It was lost during the siege of Ol Imoliv, when the archon was slain by Hildrimen, Rage Incarnate.", new StatSheet(200, 0)), "The serene golden and purple hide fades around the edges of the box. An arm's length it measures, yet some strange force emanates from this boxy monument of time past.");
        addToEventList(chestOne);  
    }

    /**
     * The method that handles the creation of the event chain procedurally.
     */
    public void procedureCreateEventChain()
    {
        eventsChain = new HashMap<>();
        LoreEvent startingEvent = new LoreEvent(1, "Ruins of Oba Kin", null, "You look at the desolation that was once a glorious city. The pale fumes are the only remains amongst the charred corpses and the blackened buildings that have all but crumbled to dust. Once a glorious city, you remember. You also remember its fall, as you defended the inhabitants from the Armies of Entropy. You must have been struck, as you find your armor wrent and sword broken. Finding no souls, you decide to go for the closest city that might still stand : Ak Variv.");
        last_added_event=startingEvent;
        procedure(startingEvent);
        //after we created the chain, we add the final event (game ending)
        LoreEvent endingEvent = new LoreEvent(904,"Agolin Respite",null, "Deep in the Agolin Mountains, you finally stumble upon an encampment of the Armies of Light. Amazed by your stories, they say that they will protect you from now on. \nYou survived. Good job.");
        endingEvent.is_end_event=true;
        addToEventChain(endingEvent);
    }

    public void procedure(Event event){
        Event chosenEvent;
        Boolean event_is_added=false;
        eventsChain.put(event.getName(),event);
        if((chance_pourcentage=chance_pourcentage - 20) >0)
        {
            //yes
            id_flag=event.getId();
            chance_pourcentage=chance_pourcentage-20;
        }
        chosenEvent = searchListIdName(id_flag, last_added_event.getName());
        if(chosenEvent!=null)
        {
            //event found
            event_is_added=testRandomChance(chance_pourcentage);
            if(event_is_added)
            {
                //event is selected
                last_added_event=event;
                procedure(chosenEvent); //we start another round of the procedure and end the function there
                return;
            }
        }
        //NO event found or event not selected (either works)
        event_is_added=false;
        while(!event_is_added)
        {
            id_flag+=1;
            chosenEvent = searchListId(id_flag);
            if(chosenEvent==null)
            {
                //NO events found
                return; //we end the procedure
            } else
            {
                //event found
                event_is_added=testRandomChance(chance_pourcentage+10);
                if(event_is_added)
                {
                    //event is selected
                    chance_pourcentage=50;
                    last_added_event=event;
                    procedure(chosenEvent); //we start another round of the procedure and end the function there
                    return;
                }
            }
        }

    }

    public Event searchListIdName(int id_flag, String last_event_name)
    {
        Event selectedEvent;
        Iterator<String> chainIterator = eventsList.keySet().iterator();
        selectedEvent=eventsList.get(chainIterator.next());
        while(chainIterator.hasNext() && id_flag!= selectedEvent.getId() && selectedEvent.getName()!=last_event_name){
            selectedEvent=eventsList.get(chainIterator.next());
        }
        if(selectedEvent.getId()==id_flag && selectedEvent.getName()!=last_event_name){return selectedEvent;}
        return null; //returns null as no event has been found
    }

    public Event searchListId(int id_flag){
        Event selectedEvent;
        Iterator<String> chainIterator = eventsList.keySet().iterator();
        selectedEvent=eventsList.get(chainIterator.next());
        while(chainIterator.hasNext() && id_flag!= selectedEvent.getId()){
            selectedEvent=eventsList.get(chainIterator.next());
        }
        if(selectedEvent.getId()==id_flag){return selectedEvent;}
        return null; //returns null as no event has been found
    }

    private Boolean testRandomChance(int chance_pourcentage){
        int random_int = (int)Math.floor(Math.random()*100);
        if(random_int<chance_pourcentage)
        {
            return true;
        }
        return false;
    }
}
