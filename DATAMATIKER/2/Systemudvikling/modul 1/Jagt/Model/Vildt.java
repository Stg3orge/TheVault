package Model;
import java.util.ArrayList;

/**
 * 
 * @author Henrik Munk Hvarregaard 
 */
public class Vildt
{
    private String art;
    private float vaegt;
    private String sex;   

    /**
     * Constructors for objects of class Vildt
     */
    
    public Vildt()
    {
    }   
    
    public Vildt(String art)
    {
        this.art = art;
    }
    
    public Vildt(String art, float vaegt, String sex)
    {
       this.art = art;
       this.vaegt = vaegt;
       this.sex = sex;

    }
    
    public boolean udrydningstruet()
    {
        boolean endangered = false;
        ArrayList<String> endangeredAnimals = new ArrayList<String>();
        endangeredAnimals = populatingAnimalList();       
        populatingAnimalList();        
        
        if(endangeredAnimals.contains(getArt()))
        {
            endangered = true;
        }
        
        return endangered;
    }  
    
    private ArrayList<String> populatingAnimalList()
    {
        ArrayList<String> tmpList = new ArrayList<String>();
        tmpList.add("Elephas maximus");
        tmpList.add("Geochelone pardalis");
        tmpList.add("Virginia Opossum");
        tmpList.add("Nyctalus noctula");
        tmpList.add("Thylacinus cynocephalus");
        tmpList.add("Rhincodon typus");
        tmpList.add("Rattus norvegicus");
        tmpList.add("Lumbricus terrestris");        
        return tmpList;
    }
    
    public String getArt()
    {
        return art;
    }
    
    public void setArt(String art)
    {
        this.art = art;
    }
        
    public float getVaegt()
    {
        return vaegt;
    }
    
    public void setVaegt(float vaegt)
    {
        this.vaegt = vaegt;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    
    

    
}
