import java.util.*;
public class IterationHashMap {
    private static HashMap<String, String> map;
    private String text;
    public static void tryMap(){
        map = new HashMap<>();
        map.put("Hej", "Hola");
        map.put("Øl", "Cereveza");
        map.put("Søn", "Hijo");
        map.put("To", "Dos");
        map.put("2", "Dos");
        map.put("Øl", "Dos cerevezas por favor!");
        // Erstatter den gamle Øl key
        
        for(String key : map.keySet()){
            print(key, map.get(key));
        }
        print("--------------", "---------------");
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            
            print(key, value);
        }
        print("--------------", "---------------");
        
    }
    
    private static void print(String a, String b){
        System.out.println(a + " => " + b);
    }
    
}
