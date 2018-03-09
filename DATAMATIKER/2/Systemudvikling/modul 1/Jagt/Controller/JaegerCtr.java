package Controller;
import Model.*;

/**
 * 
 * @author Henrik Munk Hvarregaard
 */
public class JaegerCtr
{
   private JaegerContainer jCon;
    /**
     * Constructor for objects of class JaegerCtr
     */
    public JaegerCtr()
    {
        jCon = new JaegerContainer();
        
        //construction of demo Jæger
        //--
        Jaeger j = new Jaeger(1, "Henrik Munk Hvarregaard", "jagtvej");         
        jCon.addJaeger(j);
        //----
    }

    public Jaeger findJaeger(int id)
    {
        return jCon.findJaeger(id);        
    }
}
