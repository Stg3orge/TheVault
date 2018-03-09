
/**
 * Write a description of class Product here.
 * 
 * @author (Kis Boisen Hansen) 
 * @version (2010.09.23)
 */
public class Product {
    // instance variables 
    private int id;
    private String description;
    private double price;
    private int amountInStock;

    /**
     * Constructor for objects of class Product
     */
    public Product(int newId, String newDescription, double newPrice, int newStock) {
        id = newId;
        description = newDescription;
        price = newPrice;
        amountInStock = newStock;
      
    }
    
    public void printInfo() {
        System.out.println("Product id: " + id);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Transaction Complete");
    }
    
}
