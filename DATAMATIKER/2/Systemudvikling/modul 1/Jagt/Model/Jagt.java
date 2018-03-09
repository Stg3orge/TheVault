package Model;

/**
 * 
 * @author Henrik Munk Hvarregaard 
 */

public class Jagt
{
    private int nr;
    private String dato;
    private Jaeger jaeger;
    private Vildt vildt;
   

    /**
     * Constructors for objects of class Jagt
     */
    public Jagt()
    {
    }
    
    public Jagt(int nr, String dato, Jaeger jaeger, Vildt vildt)
    {
        this.nr = nr;
        this.dato = dato;  
        this.jaeger = jaeger;
        this.vildt = vildt;
    }

     public int getNr()
    {
        return nr;
    }
    
    public void setNr(int nr)
    {
        this.nr = nr;
    }
    
    public String getDato()
    {
        return dato;
    }
    
    public void setDato(String dato)
    {
        this.dato = dato;
    }
    
    public void setJaeger(Jaeger jaeger)
    {
        this.jaeger = jaeger;
    }
    public Jaeger getJaeger()
    {
        return jaeger;
    }
    
    public void setVildt(Vildt vildt)
    {
        this.vildt = vildt;
    }
    public Vildt getVildt()
    {
        return vildt;
    }
}
