/** 
 * @author (FEN)
 * @version (2015-03-15)
 */

public class UnsignedInt extends State{
    private State uSign, end, err;

    public void setTransitions(State uSign, State end, State err)
    {
        this.uSign= uSign;
        this.end= end;
        this.err= err;
    }
    @Override
    public State transition(char c)
    {
        if (c == '\0')
            return end;
        else if ('0' <= c && c <= '9')
                 return uSign;
             else
                 return err;
    }
}
