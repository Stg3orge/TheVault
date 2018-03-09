public class Member {
    private String name;
    private String email;
    private String phoneNo;
    
    private Dog dog;
    
    public Member(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dog = null;
    }
    
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    
    public boolean feeDue(int thisYear){
        boolean res = this.dog.feeDue(thisYear);
        return res;
    }
}























