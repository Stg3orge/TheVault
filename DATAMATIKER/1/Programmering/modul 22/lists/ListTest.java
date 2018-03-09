//FEN 2006.10.10
//FEN 2009.03-15: changing to Java 5 (Generics, boxing)
import java.util.*;
public class ListTest {
    List<Integer> numberList;
    public ListTest(){
        numberList= new LinkedList<Integer>();//new ArrayList<Integer>();
        for(int i= 0; i<200001; i++){
            numberList.add(i);
        }
        System.out.println("Number list created: "+ numberList.size());
        
    }
    public void traverseGet(){
        for(int i= 0;i<numberList.size();i++){
            if(numberList.get(i)%25000 == 0) 
                System.out.println("Hello from "+ i+ "!");
        }
        System.out.println("Done: Using get: "+numberList.getClass()
                                        +" size: "+numberList.size());
    }
    public void traverseIterator(){
        System.out.println("TraversIterator");
        Iterator<Integer> it= numberList.iterator();
        int i;
        while(it.hasNext()){
            i= it.next();
            if(i% 25000==0) 
                System.out.println("Hello from "+ i+ "!");
        }
        System.out.println("Done: Using iterator: "+numberList.getClass()
                                        +" size: "+numberList.size());
    }
    public void traverseForeach(){
        for(int i : numberList){
            if(i%25000 == 0) System.out.println("Hello!");
        }
        System.out.println("Done: Using foreach: "+numberList.getClass()+" size: "+numberList.size());
    }
}
