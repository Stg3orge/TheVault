
public class Bicycle {
    
    private String name;
    private Frame frame;
    private Gear gear;
    private Brake brake;
    
    public Bicycle(String name) {
        this.name = name;        
    }
        
    public String getName(){
        return name;
    }

    
    public void setFrame(Frame frame){
        this.frame = frame;
    }
    
    public Frame getFrame(){
        return frame;
    }

    
    public void setGear(Gear gear){
        this.gear = gear;
    }

    public Gear getGear(){
        return gear;
    }
    
    
    public void setBrake(Brake brake){
        this.brake = brake;
    }
    
    public Brake getBrake(){
        return brake;
    }
    
    
    public double getPrice(){
       double temp;
    
       temp = brake.getPrice() + gear.getPrice() + frame.getPrice();
       
       return temp;
    }
    
    
    public String getDescription(){
        String temp;
        
        temp = "Brake Manufacturer: " + brake.getManufacturer() + " Gear description: " + gear.getName()
         + " Frame description: " + frame.getName();
        
        return temp;   
    }
    
    public void Print()
    {        
        System.out.println(getDescription());
    }
    
}
