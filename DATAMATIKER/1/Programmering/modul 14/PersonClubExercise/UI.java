import java.util.*;
public class UI {
    
    private Club club;
    
    public void Try_Me(){
        club = new Club();
        
        Person p1 = new Person("Joe", "joe@gmail.com");
        Person p2 = new Person("Jane", "jane@gmail.com");
        
        club.addMember(p1);
        club.addMember(p2);
        
        print(club.getMembers());
        //----------------------------

        Person p = club.getMembers().get(0);
        print(p);
        
        club.getMembers().remove(p);
        print(club.getMembers());
        
        
        
    }
    
    private void print(ArrayList<Person> pp){
        for(Person element : pp){
            System.out.println(element.getName() + " " + element.getEmail() + " ");
        }
    }
    
    private void print(Person p){
        System.out.println(p);
    }
    
    public UI() {
      
    }

}
