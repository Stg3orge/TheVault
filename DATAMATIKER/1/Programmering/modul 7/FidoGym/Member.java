
import java.util.*;
public class Member {

    private String name;
    private String email;
    private String phone;
    
    private static int counter = 1;
    private int id;
    
    private ArrayList<Dog> ownedDogs;

    public Member(String _name, String _email, String _phone) {
        setName(_name);
        setEmail(_email);
        setPhone(_phone);
        
        id = counter;
        counter++;
        
        ownedDogs = new ArrayList<>();
    }
    
    public int getId(){
        return id;
    }
    
    /*public void setDog(Dog _dog){
    dog = _dog;
    }*/

    public void addDog(Dog _dog){
        ownedDogs.add(_dog);
    }

    /*public Dog getDog(){
    return dog;
    }*/

    public ArrayList<Dog> getDogs(){
        return ownedDogs;
    }

    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String _email){
        email = _email;
    }

    public String getEmail(){
        return email;
    }

    public void setPhone(String _phone){
        phone = _phone;
    }

    public String getPhone(){
        return phone;
    }

    /*public boolean hasDog(){
    if(getDog() == null){
    return false;
    }
    else
    return true;
    }*/

    public boolean hasDog(){

        boolean temp = false;

        for(Dog dog : ownedDogs){
            if(dog != null){
                temp = true;
            }
        }

        return temp;
    }

    public boolean isFeeDue(int thisYear){
        for(Dog dog : ownedDogs){
            if(dog.getFeeYear() < thisYear){
                return true;
            }      
        }
        
        return false;
    }
    
    public int noToBePaid(int thisYear){
        
        int temp = 0;
        
        for(Dog dog : ownedDogs){
            if(dog.getFeeYear() < thisYear){
                temp++;
            }
        }
        
        System.out.println("Owner is missing payment for: " + temp + " dog(s).");
        
        return temp;
    }
    
    public ArrayList<Dog> listOfRequestedPayments(int thisYear){
        
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        
        for(Dog dog : ownedDogs){
            if(dog.getFeeYear() < thisYear){
                dogs.add(dog);
            }
            
        }
        
        return dogs;
    }

    public void describe(){
        System.out.println("Information on member: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phone);
        System.out.println("ID: " + id);

        if(hasDog() == true){
            for(Dog dog : ownedDogs){
                System.out.println("Dog name: " + dog.getName() + "\n");
            }
        }
        else
            System.out.println(name + " does not own a dog");

    }
}
