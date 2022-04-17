package Events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Loot.Item;
import Loot.ItemType;
import Loot.StatSheet;

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
        LoreEvent startingEvent = new LoreEvent(1, "Ruins of Oba Kin", null, "You look at the desolation that was once a glorious city. The pale fumes are the only remains amongst the charred corpses and the blackened buildings that have all but crumbled to dust. Once a glorious city, you remember. You also remember its fall, as you defended the inhabitants from the Armies of Entropy. You must have been struck, as you find your armor wrent and sword broken. Finding no souls, you decide to go for the closest city that might still stand : Ak Variv.");
        addToEventList(startingEvent);
        ChestEvent chestOne = new ChestEvent(2, "Sarcophagus of Heilith", new Item(1, "Sword of Bil Akath", ItemType.WEAPON, "The mighty sword of the last Archon under Akkalioth's orders. Under its blade, numerous angels have fallen, as the Fangs of Entropy closed upon the lucent city of Dek Ithien. It was lost during the siege of Ol Imoliv, when the archon was slain by Hildrimen, Rage Incarnate.", new StatSheet(200, 0)), "The serene golden and purple hide fades around the edges of the box. An arm's length it measures, yet some strange force emanates from this boxy monument of time past.");
        addToEventList(chestOne);  
    }

    /**
     * The method that handles the creation of the event chain procedurally.
     * @return
     */
    public void procedureCreateEventChain()
    {
        eventsChain = new HashMap<>();
        LoreEvent startingEvent = new LoreEvent(1, "Ruins of Oba Kin", null, "You look at the desolation that was once a glorious city. The pale fumes are the only remains amongst the charred corpses and the blackened buildings that have all but crumbled to dust. Once a glorious city, you remember. You also remember its fall, as you defended the inhabitants from the Armies of Entropy. You must have been struck, as you find your armor wrent and sword broken. Finding no souls, you decide to go for the closest city that might still stand : Ak Variv.");
        last_added_event=startingEvent;
        procedure(startingEvent);
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
