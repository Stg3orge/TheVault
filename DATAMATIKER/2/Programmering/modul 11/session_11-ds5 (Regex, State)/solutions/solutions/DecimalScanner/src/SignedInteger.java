/** 
 * @author (FEN)
 * @version (2015-03-15)
 */

public class SignedInteger extends State {
    
	private State uSign, err, dec;

    public void setTransitions(State uSign, State err, State dec)
    {
        this.uSign= uSign;
        this.err= err;
        this.dec= dec;
    }
    
	@Override
	public State transition(char c) {

        if('0'<=c && c<='9')
            return uSign;
        else if (c=='+' || c=='-')
            	return uSign;
        else
            return err;
	}

}
