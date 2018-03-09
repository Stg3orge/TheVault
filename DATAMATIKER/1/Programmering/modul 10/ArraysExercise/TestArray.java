import java.util.Arrays;
public class TestArray {

    private int[] a = {90, 15, 36};

    public TestArray() {

    }

    public void printArray(){
        for(int i=0; i < a.length; i++){
            System.out.println("Number: " + a[i]);
        }
    }

    public boolean isEven(int index){
        boolean result = false;

        if(a[index] % 2 == 0){
            result = true;
        }

        return result;
    }

    public int countEven(){

        int count = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                count++;
            }
        }

        return count;
    }

    public boolean linearSearch(int i){
        boolean temp = false;
        
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        
        for(int element : a){
            if(element == i){
                temp = true;
            }
        }
        return temp;
    }

    public void addAnInt(int number){
        int[] neoArray = new int[a.length + 1];
        
        for(int i = 0; i < a.length; i++){
            neoArray[i] = a[i];
            System.out.println("neoArray Number: " + neoArray[i]);
        }
        
        neoArray[a.length] = number;
        a = neoArray;
    }
}
