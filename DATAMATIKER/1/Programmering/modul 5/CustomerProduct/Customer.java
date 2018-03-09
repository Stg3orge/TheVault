
/**
 * Write a description of class Customer here.
 * 
 * @author (Kis Boisen Hansen) 
 * @version (2010.09.23)
 */
public class Customer {
    // instance variables - replace the example below with your own
    private int number;
    private String name;
    private String address;
    private String phone;
    private Order myOrder;//at the moment onlyone instance of order

    /**
     * Constructor for objects of class Customer
     */
    public Customer(int newNr, String newName, String newAddress, String newPhone) {
       number = newNr;
       address = newAddress;
       name = newName;
       phone = newPhone;
       myOrder = null;
    }

    public void setOrder(Order newOrder) {
        myOrder = newOrder;
    }
    public void printInfo() {
        System.out.println("Customer no.:  " + number);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone#: " + phone);
        // print out information about the customers order
        // write the code
        myOrder.printInfo();
          
    }
    
    public String getName() {
        return name;
    }
}
