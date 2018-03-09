
public class Bicycle extends Vehicle {
    
    private int gearCount;
    
    public Bicycle(String color, int gearCount) {
        super(color);
        this.gearCount = gearCount;
    }
    
    public String getDescription(){
        
        return super.getDescription() + "Gear Count: " + getGearCount();
        
    }
    
    public int getGearCount(){
        return gearCount;
    }
}
