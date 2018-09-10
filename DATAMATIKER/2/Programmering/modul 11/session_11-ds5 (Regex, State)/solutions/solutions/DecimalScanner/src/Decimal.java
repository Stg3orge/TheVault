/** 
 * @author (FEN)
 * @version (2015-04-12)
 */

public class Decimal extends State {
	private State dec, end, err;
	
    public void setTransitions(State dec, State end, State err)
    {
        this.dec= dec;
        this.end= end;
        this.err= err;
    }

	@Override
	public State transition(char c) {
        if (c == '\0')
            return end;
        else if ('0' <= c && c <= '9')
                 return dec;
             else
                 return err;
	}

}
