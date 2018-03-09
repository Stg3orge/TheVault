
public class Frame {
    // instance variables - replace the example below with your own
    private String name;
    private String material;
    private double price;
    
    public Frame(String name, String material, double price) {
        // initialise instance variables
        this.name = name;
        this.material = material;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }

    public String getMaterial(){
        return material;
    }
    
    public double getPrice(){
        return price;
    }
    
    
}
