package model;
import java.util.*;
public class Container {
    private ArrayList<Member> listOfMembers;
    private static Container instance;
    
    private Container(){
        listOfMembers = new ArrayList<>();
    }
    
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }
    
    public void addMember(Member m){
        listOfMembers.add(m);
    }
}
