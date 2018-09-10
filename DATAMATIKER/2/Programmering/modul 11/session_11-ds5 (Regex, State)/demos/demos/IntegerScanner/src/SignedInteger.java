/** 
 * @author (FEN)
 * @version (2015-03-15)
 */

public class SignedInteger extends State {
    
	private State uSign, err;

    public void setTransitions(State uSign, State err)
    {
        this.uSign= uSign;
        this.err= err;
    }
    
	@Override
	public State transition(char c) {

        if('0'<=c && c<='9')
            return uSign;
        else
            return err;
	}

}
