
public class PrintArray {
    public void printArray() {
        Tux tux = new Tux();
        String[][] arr = tux.getArray();
        // Task: Write a few lines of code that prints the double array "arr"
        // Each array should be printed on a new line: System.out.println();
        // Each String in the inner arrays should be printed on the same line: System.out.print(...);
        // If you open the Tux class, and BlueJ freezes, you may have to restart BlueJ (don't open it)
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    } 
}
