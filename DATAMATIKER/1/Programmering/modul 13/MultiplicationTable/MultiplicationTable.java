
public class MultiplicationTable {
    
    public MultiplicationTable() {
       
    }
    
    public void Print(){
        for(int x = 1; x < 11; x++){
            
            System.out.println("\n");
            
            for(int y = 1; y < 11; y++){
                
                System.out.print(x * y  + "\t");
                
            }
            
        }
    }
}
