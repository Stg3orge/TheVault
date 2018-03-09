import java.util.*;

public class ArrayListExample {
    private ArrayList<String> names;
    
    public ArrayListExample() {
        names = new ArrayList<>();
    }
    
    public void teachMe() {
        names.add("joe");
        names.add("jane");
        names.add(null);
        System.out.println("Size is: " +  names.size());
        System.out.println("Name nr. 1 is: " + names.get(0));
        
        for(String currentName : names) {
            System.out.println("name: " + currentName);
        }
    }
    
    public void teachMeDogTricks() {
        Dog dog = new Dog("Barfie");
        dog.setFeeYear(2015);
        
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        //dogs.add(null);
        
        for(Dog d: dogs) {
            System.out.println("Dog name: " + d.getName() + ", fee: " + d.getFeeYear() + " fee due: " + d.feeDue(2015));
        }
        
    }
}















