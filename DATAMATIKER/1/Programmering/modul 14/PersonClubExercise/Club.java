import java.util.*;
public class Club {
    
    private ArrayList<Person> members;

    public Club() {
        members = new ArrayList<>();
    }
    
    public void addMember(Person p){
        if(!members.contains(p)){
            members.add(p);
        }
    }
    
    public ArrayList<Person> getMembers(){
        return members;
    }
}
