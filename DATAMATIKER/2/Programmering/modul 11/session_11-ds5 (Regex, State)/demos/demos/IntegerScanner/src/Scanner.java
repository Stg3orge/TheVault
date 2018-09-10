/**
 * Checking signed integer
 * 
 * @author (FEN) 
 * @version (201½5-03-15)
 */

public class Scanner {
    private Start start;
    private UnsignedInt uSign;
    private SignedInteger sign;
    private Error err;
    private EndState end;

    public Scanner()
    {
        start = new Start();
        uSign = new UnsignedInt();
        sign = new SignedInteger();
        err = new Error();
        end = new EndState();
        start.setTransitions(uSign, sign, err);
        uSign.setTransitions(uSign, end, err);
        sign.setTransitions(uSign, err);

    }

    public boolean scan(String input)
    {
        //input.length()>0
        boolean ok = false;
        int i = 0;
        State currState = start;
        while (currState != end && currState != err)
        {
            char nextChar;
            if (i == input.length())
                nextChar = '\0';
            else
                nextChar = input.charAt(i);
            //currState.Action();
            currState = currState.transition(nextChar);
            i++;
        }
        if (currState == end)
            ok = true;
        return ok;
    }
}
