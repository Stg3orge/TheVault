package Model;
import java.util.ArrayList;

/** 
 * 
 * @author Henrik Munk Hvarregaard
 */
public class JaegerContainer
{
    private ArrayList<Jaeger> jaegere;

    public JaegerContainer()
    {
        jaegere = new ArrayList<Jaeger>();        
    }
    
    public void addJaeger(Jaeger jaeger)
   {
       jaegere.add(jaeger);	
   }

    public Jaeger findJaeger(int id)
    {
        int i = 0;           
        boolean notFound = true;
        Jaeger tmpJ = new Jaeger();

        while(notFound && i < jaegere.size()) 
        {            
            if(jaegere.get(i).getId()==id)
            {
                tmpJ = jaegere.get(i);
                notFound = false;
            }
            else 
            {                
                i++;
            }
        }
        if(notFound) 
        {          
            return null;
        }

        else 
        {           
            return tmpJ;
        }

    }

}
