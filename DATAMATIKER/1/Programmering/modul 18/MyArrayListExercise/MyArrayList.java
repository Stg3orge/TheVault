import java.util.*;
public class MyArrayList {

    private Object[] objects;
    private int size = 1;

    public MyArrayList() {
        objects = new Object[size];
    }

    public int size(){
        return size;
    }

    public void add(Object o){

        boolean cond = true;

        while(cond == true){

            for (int i = 0; i < objects.length; i++) { 

                if (objects[i] == null) {
                    objects[i] = o;
                    break;
                }
                else{
                    expandArray(objects);
                }
            }
        }
    }

    public Object getObject(int i){
        return null;
    }

    public Object remove(int i){

        for (int j = 0; j < objects.length; j++){

            if(objects[j].equals(i)){

                objects[j] = null;
                return objects[j];

            }
        }

        return null;
    }

    private Object[] expandArray(Object[] objectArray){
        Object[] newObjectArray = new Object[objectArray.length + 1];

        for(int i = 0; i < objectArray.length; i++){

            newObjectArray[i] = objectArray[i];

        }

        return newObjectArray;
    }
}
