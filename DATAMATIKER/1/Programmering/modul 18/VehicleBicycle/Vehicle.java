
public class Vehicle {
    private String color;

    public Vehicle(String color){
        this.color = color;
    }

    public String getDescription(){
        String s;
        
        s = "Color: " + getColor() + " ";
        
        return s;
        
    }

    public String getColor(){
        return color;
    }
}
