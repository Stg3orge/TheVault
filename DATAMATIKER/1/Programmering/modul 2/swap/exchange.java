
/**
 * Write a description of class exchange here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class exchange {
    private int val;
    private int val1;
    
    public exchange(int value, int value2){
        val = value;
        val1 = value2;
    }

    public void swap(){
        int temp = val;
        val = val1;
        val1 = temp;
    }
        
}