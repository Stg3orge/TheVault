/**
 * @author knol
 * @version 2016-09-25
 */

public class Member {
    private String cprNo;
    private String name;
    private String address;
    private String phoneNumber;
    
    public Member() {}
    
    public Member(String cpr, String name, String address, String phone) {
        setCprNo(cpr);
        setName(name);
        setAddress(address);
        setPhoneNumber(phone);
    }
    
    public void setCprNo(String cpr){this.cprNo = cpr;}
    public String getCprNo(){return cprNo;}
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void setAddress(String address){this.address = address;}
    public String getAddress(){return address;}
    public void setPhoneNumber(String phone){this.phoneNumber = phone;}
    public String getPhoneNumber(){return phoneNumber;}
    
    public int getBirthYear() {
        int year = -1;
        if(cprNo != null) {
            String strYear = cprNo.substring(4, 6);
            year = Integer.parseInt(strYear);
            String strCentury = cprNo.substring(6, 7);
            int century = Integer.parseInt(strCentury);
            if(century < 5) { // simplified - compare to: https://da.wikipedia.org/wiki/CPR-nummer
                year += 1900;
            }
            else {
                year += 2000;
            }
        }
        return year;
    }
    
    public String toString() {
        return name + " (" + getBirthYear() + ")";
    }
}