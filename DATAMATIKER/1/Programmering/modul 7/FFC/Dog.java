public class Dog{
    private int feeYear;
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    public void setFeeYear(int year) {
        this.feeYear = year;
    }
    
    public boolean feeDue(int thisYear) {
        return thisYear > feeYear;
    }
    
    public String getName() {
        return name;
    }
    
    public int getFeeYear() {
        return feeYear;
    }
}
