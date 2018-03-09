public class OrderLine{
    // instance variables - replace the example below with your own
    private int quantity;
    private Order order;//is connected to one order
    private Product product;// is connected to one product

    /**
     * Constructor for objects of class PartOrder
     */
    public OrderLine(int newQuantity, Order newOrder, Product newProduct) {
       quantity = newQuantity;
       order = newOrder;
       product = newProduct;
    }
    
    public void printInfo() {
        String newLine = System.getProperty("line.separator");
        
        System.out.println("Quantity: " +  quantity + newLine);
        
        product.printInfo();
    }
    
}
