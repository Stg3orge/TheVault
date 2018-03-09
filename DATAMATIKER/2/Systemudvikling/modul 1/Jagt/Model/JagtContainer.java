package Model;
import java.util.ArrayList;

/**
 * 
 * @author Henrik Munk Hvarregaard
 */
public class JagtContainer
{
     private ArrayList<Jagt> jagter;
    /**
     * Constructor for objects of class JagtContainer
     */
    public JagtContainer()
    {
        jagter = new ArrayList<Jagt>();
    }
    
    public void addJagt(Jagt jagt)
   {
       jagter.add(jagt);	
   }
   

    
}
