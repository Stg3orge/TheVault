package Controller;
import Model.*;
/**
 * 
 * @author Henrik Munk Hvarregaard
 */
public class VildtCtr
{
    private Saat saat;

    /**
     * Constructor for objects of class VildtCtr
     */
    public VildtCtr()
    {
        saat = new Saat();
        
         //construction of demo Jæger
        //--
        Vildt v = new Vildt("Lumbricus terrestris", 12, "Tve");         
        saat.udsaetDyr(v);
        //----
    }

    public Vildt purchjagt(String art)
    {
        return saat.purchjagt(art);
    }
}
