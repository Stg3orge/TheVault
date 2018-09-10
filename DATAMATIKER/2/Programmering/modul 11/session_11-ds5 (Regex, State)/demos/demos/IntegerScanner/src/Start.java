/**
 * class Start - Start state
 * 
 * @author (FEN)
 * @version (2015-03-14)
 */
public class Start extends State {
    // from class Start there are 3 possible transitions
    private State uSign, sign, err;

    public void setTransitions(State uSign, State sign, State err)
    {
        this.uSign= uSign;
        this.sign= sign;
        this.err= err;
    }

	@Override
	public State transition(char c) {
		
        if ('0' <= c && c <= '9')
            return uSign;
        else if (c == '+' || c == '-')
            return sign;
        else
            return err;
	}
}
