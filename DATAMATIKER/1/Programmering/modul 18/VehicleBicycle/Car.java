
public class Car extends Vehicle{
    
    private String fuelType;
    
    public Car(String color, String fuelType) {
        super(color);
        this.fuelType = fuelType;
    }
    
    public String getDescription(){
    
        return super.getDescription() + "Fuel Type: " + getFuelType();
        
    }
    
    public String getFuelType(){
        return fuelType;
    }
}
