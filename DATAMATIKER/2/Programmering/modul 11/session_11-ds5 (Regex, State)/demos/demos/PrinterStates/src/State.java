import java.util.*;
/**
 * Abstract class State - Represents a general state
 * 
 * @author (FEN)
 * @version (2015-03-17)
 */
public abstract class State
{
   private Map<Events, State> adjacents;

   public State()
   {
       adjacents = new TreeMap<Events, State>();
   }

   public Map<Events, State> getAdjacents()
   {
       return adjacents; 
   }

   public void addTransition(Events e, State s)
   {
       adjacents.put(e, s);
   }

   public String eventString()
   {
       String returnStr = "";
       Set<Events> keys= adjacents.keySet();
       Iterator<Events> it= keys.iterator();
       while(it.hasNext()){
           Events currKey= it.next();
           returnStr = returnStr + currKey + ", ";
       }

       return returnStr;
   }

   //get next state
	public State transition(Events e) {
       return getAdjacents().get(e);
	}

   //Actions associated with the concrete state
   public abstract void action();
}
