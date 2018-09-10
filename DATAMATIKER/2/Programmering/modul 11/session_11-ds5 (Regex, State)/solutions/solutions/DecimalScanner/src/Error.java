/** 
 * @author (FEN)
 * @version (2015-03-15)
 */

public class Error extends State{
	
    //dummy implementation - no transitions from Error
	@Override
	public State transition(char c) {
		return this;
	}
}
