/**
 * Checking signed integer
 * 
 * @author (FEN) 
 * @version (2015-03-15)
 */

public class Scanner {
    private Start start;
    private UnsignedInt uSign;
    private SignedInteger sign;
    private Error err;
    private EndState end;
    private Decimal dec;

    public Scanner()
    {
        start = new Start();
        uSign = new UnsignedInt();
        sign = new SignedInteger();
        err = new Error();
        end = new EndState();
        dec = new Decimal();
        start.setTransitions(uSign, sign, err, dec);
        uSign.setTransitions(uSign, end, err, dec);
        sign.setTransitions(uSign, err, dec);
        dec.setTransitions(dec, end, err);

    }

    public boolean scan(String input)
    {
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
