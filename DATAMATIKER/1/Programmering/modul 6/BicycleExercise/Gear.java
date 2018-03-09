
public class Gear {
    
    private String name;
    private int speeds;
    private double price;
    
    public Gear(String name, int speeds, double price) {
        this.name = name;
        this.speeds = speeds;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSpeeds(){
        return speeds;
    }
    
    public double getPrice(){
        return price;
    }
    
}
