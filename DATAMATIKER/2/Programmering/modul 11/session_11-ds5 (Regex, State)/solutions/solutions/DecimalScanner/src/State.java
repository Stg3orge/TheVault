/**
 * Abstract class State - Represents a general state
 * 
 * @author (FEN)
 * @version (2015-03-14)
 */
public abstract class State
{

    //returns next state
    abstract public State transition(char c);

    //in case there are any actions connected to a transition
    
    //abstract public void action(char c);
}
