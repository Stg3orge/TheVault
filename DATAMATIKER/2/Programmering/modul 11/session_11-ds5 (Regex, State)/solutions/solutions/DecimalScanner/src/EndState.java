/** 
 * @author (FEN)
 * @version (2015-03-15)
 */

public class EndState extends State {

    //dummy implementation - no transitions from EndState
	@Override
	public State transition(char c) {
		return this;
	}

}
