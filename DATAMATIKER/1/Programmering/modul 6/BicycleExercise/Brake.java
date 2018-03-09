
public class Brake {

    private String manufacturer;
    private String type;
    private double price;

    public Brake(String manufacturer, String type, double price) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
    }
    
    public String getManufacturer(){
        return manufacturer;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }

}
