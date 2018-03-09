import java.util.*;
public class StuffOrganizer {

    private ArrayList<Stuff> stuff;

    public StuffOrganizer() {
        stuff = new ArrayList<>();
    }

    public void addStuff(Stuff s){
        stuff.add(s);
    }

    public ArrayList<Stuff> getAllStuff(){
        return stuff;
    }

    public boolean removeStuff(Stuff s){

        for(int i=0; i<stuff.size(); i++){
            if(stuff.get(i).equals(s)){
                return stuff.remove(s);
            }
        }
        return false;
    }

    public Stuff removeStuffByName(String name){
        int index = 0;

        Stuff result = null;

        while(index < stuff.size()){

            String temp = stuff.get(index).getName();

            if(temp.contains(name)){
                result = stuff.get(index);
                stuff.remove(index);
                return result;
            }
            else{
                index++;
            }
        }

        return result;
    }

    public Stuff findByName(String name){

        Stuff s = null;

        for(int i = 0; i < stuff.size(); i++){
            if(stuff.get(i).getName().equals(name)){
                s = stuff.get(i);
            }
        }

        return s;

    }

    public ArrayList<Stuff> findByValueOver(double value){
        ArrayList<Stuff> result = new ArrayList<>();

        for(Stuff element : stuff){
            if(element.getPrice() > value){
                result.add(element);
            }
        }

        return result;
    }

    public ArrayList<Stuff> findByValueBelow(double value){
        ArrayList<Stuff> result = new ArrayList<>();

        for(Stuff element : stuff){
            if(element.getPrice() < value){
                result.add(element);
            }
        }

        return result;
    }
    
    public ArrayList<Stuff> findByCountOver(int count){
        ArrayList<Stuff> result = new ArrayList<>();
        
        for(Stuff element : stuff){
            if(element.getCount() > count){
                result.add(element);
            }
        }
        
        return result;
    }
    
        public ArrayList<Stuff> findByCountUnder(int count){
        ArrayList<Stuff> result = new ArrayList<>();
        
        for(Stuff element : stuff){
            if(element.getCount() < count){
                result.add(element);
            }
        }
        
        return result;
    }
}
