/**
 * class Start - Start state
 * 
 * @author (FEN)
 * @version (2015-03-14)
 */
public class Start extends State {
    // from class Start there are 3 possible transitions
    private State uSign, sign, err, dec;

    public void setTransitions(State uSign, State sign, State err, State dec)
    {
        this.uSign= uSign;
        this.sign= sign;
        this.err= err;
        this.dec= dec;
    }

	@Override
	public State transition(char c) {
		
        if ('0' <= c && c <= '9')
            return uSign;
        else if (c == '+' || c == '-')
            return sign;
        else if (c=='.' || c==',')
        	return dec;
        else        	
            return err;
	}
}
