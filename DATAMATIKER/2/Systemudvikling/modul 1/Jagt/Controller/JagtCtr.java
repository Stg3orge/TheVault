package Controller;
import Model.*;
import java.util.Date;
/**
 * 
 * @author Henrik Munk Hvarregaard
 */
public class JagtCtr
{
  private VildtCtr vildtCtr;
  private JaegerCtr jaegerCtr;
  private JagtContainer jCon;
  
    /**
     * Constructor for objects of class JagtCtr
     */
    public JagtCtr()
    {
        vildtCtr = new VildtCtr();
        jaegerCtr = new JaegerCtr();
        jCon = new JagtContainer();
    }
    
    public void nedlaegDyr(int jaegerId, String art)
    {  
        Jagt j = new Jagt();
        Date now = new Date();
        j.setNr(autoGenerateNr());
        j.setDato(now.toString());
        j.setJaeger(jaegerCtr.findJaeger(1));
        j.setVildt(vildtCtr.purchjagt(art));
        
        jCon.addJagt(j);        
    }
    
    private int autoGenerateNr()
    {
        //autogenerate code
        return 1;
    }
   
}
