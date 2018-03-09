
public class Stuff {

    private String name;
    private double price;
    private int count;
    
    public Stuff(String name, double _price, int _count) {
        this.name = name;
        setPrice(_price);
        setCount(_count);
    }
    
    public Stuff(){
        
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setCount(int count){
        this.count = count;
    }

}
