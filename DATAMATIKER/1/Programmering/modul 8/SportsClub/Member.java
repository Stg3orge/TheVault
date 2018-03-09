
public class Member {

    private String cprNo;
    private String name;
    private String address;
    private String phoneNumber;

    public Member(String _cpr, String _name, String _address, String _phonenumber) {
        setCprNo(_cpr);
        setName(_name);
        setAddress(_address);
        setPhoneNumber(_phonenumber);
    }

    public void setCprNo(String _cpr){
        if(_cpr.length() == 10){
            cprNo = _cpr;
        }
        else{
            System.out.println("Invalid CPR Number. Please try again.");
        }
    }

    public String getCprNo(){
        return cprNo;
    }

    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String _address){
        address = _address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNumber(String _phone){
        phoneNumber = _phone;
    }
    
    public int getBirthYear(){
        String temp;

        temp = getCprNo();
        temp = temp.substring(6,10);        
        
        return Integer.parseInt(temp);
    }
}
