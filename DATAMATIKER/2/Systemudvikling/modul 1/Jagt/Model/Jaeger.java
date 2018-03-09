package Model;

/** 
 * 
 * @author Henrik Munk Hvarregaard
 */
public class Jaeger
{
    // instance variables
    private int id;
    private String navn;
    private String adresse;

    /**
     * Constructors for objects of class Jaeger
     */
    public Jaeger()
    {
    }
    
    public Jaeger(int id, String navn, String adresse)
    {
        this.id = id;
        this.navn = navn;
        this.adresse = adresse;
    }

   public int getId()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }
    
     public String getNavn()
    {
        return navn;
    }
    public void setNavn (String navn)
    {
        this.navn = navn;
    }
    
     public String getAdresse()
    {
        return adresse;
    }
    public void setAdresse (String adresse)
    {
        this.adresse = adresse;
    }
    
}
