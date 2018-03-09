package model;

import java.util.ArrayList;

public class Member {
    private String name;
    private String phone;
    private String email;
    private ArrayList<Dog> dogs;
    
    public Member(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        dogs = new ArrayList<>();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    
    public void addDog(Dog dog) {
        if(dog != null){
            dogs.add(dog);
        }
    }
    
    /**
     * Retrieve the dog objects, this member has. The returned variable does not
     * allow direct modification of the internal structure of Member object.
     * @return an ArrayList containing the memeber's dogs
     */
    public ArrayList<Dog> getDogs() {
        //return dogs; <-- We want to encapuslate the ArrayList of this object
        ArrayList<Dog> result = new ArrayList<>(dogs);
        return result;
    }
    
    public void removeDog(Dog dog) {
        dogs.remove(dog);
    }
    
    /**
     * Returns the number of dogs for which the given Member has not paid membership fee
     * @param year is the year for which we want to check for
     * @return a number representing the number of dogs fee is due for
     */
    public int unpaidCount(int year) {
        int result = 0;
        for(Dog dog: dogs) {
            if(dog.isFeeDue(year)){
                result++;
            }
        }
        return result;
    }
    
    /**
     * Returns the dogs the given member has not paid the fee for. The list is empty if
     * the member doesn't owe money to the club.
     * @param year the year we want to check for
     * @return a list of dogs fee is due for for the given year
     */
    public ArrayList<Dog> unpaidList(int year) {
        ArrayList<Dog> result = new ArrayList<>();
        for(Dog dog : dogs) {
            if(dog.isFeeDue(year)){
                result.add(dog);
            }
        } 
        return result;
    }
    
    /**
     * Any unpaid fees?
     * @param year the year we check for
     * @return <code>true</code> if the member owes money, <code>false</code> otherwise.
     */
    public boolean isFeeDue(int year) {
        boolean result = false;
        Dog currDog = null;
        int i = 0;
        while(i < dogs.size() && !result) {
            currDog = dogs.get(i);
            if(currDog.isFeeDue(year)){
                result = true;
            }
            else {
                i++;
            }
        }
        return result;
    }
    
    /**
     * Prints the member's info to the console, including the info for all the member's dogs
     */
    public void describe() {
        // Describe owner
        System.out.println("Owner's name: " + name);
        System.out.println("Owner's phone number: " + phone);
        System.out.println("Owner's email: " + email);
        
        // Describe dog - the Dog object handles the task
        // This is object interaction: we call the describe() method on each Dog object
        if(dogs.size() > 0) {
            System.out.println("Owner's dogs:");
            for(int i = 0; i < dogs.size(); i++) {
                if(dogs.get(i) != null) {
                    dogs.get(i).describe();
                }
            }
        }
        else {
            System.out.println("Owner has no dogs");
        }
    }
    
}