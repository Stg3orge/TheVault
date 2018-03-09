
/**
 * Write a description of class Order here.
 * 
 * @author (Kis Boisen Hansen) 
 * @version (2010.09.23)
 */
public class Order {
    // instance variables 
    private int number;
    private String orderDate;
    private String deliveryDate;
    private String payDate;
    private boolean status;
    private OrderLine myOrderLine;// at the moment only one partorder pr. order
    
    private Customer c;

    /**
     * Constructor for objects of class Order
     */
    public Order(int newNr, String date, String newDelivery) {
        number = newNr;
        orderDate = date;
        deliveryDate = newDelivery;
        status = false;
        myOrderLine = null;
        
       
       
    }
    public void setPartOrder(OrderLine newOrderLine) {
        myOrderLine = newOrderLine;

    }
    public void printInfo() {
        System.out.println("Orderno : " + number);
        System.out.println("Order date: " + orderDate);
        System.out.println("Delivery date : " + deliveryDate);
        // TODO: Write the missing code
        myOrderLine.printInfo();
    }
    
    public void setCustomer(Customer nogetAndet) {
        c = nogetAndet;
    }
}














