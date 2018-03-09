package Model;
import java.util.ArrayList;

/**
 * En saat (såt) er et jagtområde/stykke jord - man kan også omtale det jagtsåt
 * 
 * @author Henrik Munk Hvarregaard
 */
public class Saat
{
    private String navn;
    private String land;
    private ArrayList<Vildt> vildt;

    /**
     * Constructor for objects of class Saat
     */
    
    public Saat()
    {
        vildt = new ArrayList<Vildt>();
    }
    
    public void udsaetDyr(Vildt dyr)
    {
        vildt.add(dyr);
    }

    public Vildt purchjagt(String art)
    {
        int i=0;
        boolean found = false;
        Vildt tmpVildt = new Vildt();
        while (!found && i<=vildt.size())
        {
            if (vildt.get(i).getArt()==art)
            {
                tmpVildt = vildt.get(i);
                found = true;
            }
            else
            {
                i++;
            }
        }

        if(found)
        {
            return vildt.get(i);
        }
        else
        {
            return null;
        }
    }
}

