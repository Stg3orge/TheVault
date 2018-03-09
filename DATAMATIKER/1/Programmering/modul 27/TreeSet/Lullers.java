
import java.util.*;
public class Lullers {
    
    TreeSet set;
   // Person person;
    
    public Lullers() {
        set = new TreeSet();
        //person = new Person("Jacob", 23);
        
        set.add("LOL");
        set.add("Ok");
        set.add("Today");
        set.add("Tommorow");
        set.add("Lizard");
        
        
        //set.add(person);
    }
    
    public void deleteNow(){
        set.remove("Ok");
    }
}
