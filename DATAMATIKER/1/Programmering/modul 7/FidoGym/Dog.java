
public class Dog {
    // instance variables - replace the example below with your own
    private String name;
    private int feeYear;
    
    public Dog(String _name, int _feeYear) {
        setName(_name);
        setFeeYear(_feeYear);
    }    
    
    public String getName(){
        return name;
    }

    public int getFeeYear(){
        return feeYear;
    }

    public void setName(String _name){
        name = _name;
    }

    public void setFeeYear(int _feeYear){
        feeYear = _feeYear;
    }
}
