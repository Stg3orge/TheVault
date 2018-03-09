
public class Person {
    // instance variables - replace the example below with your own
    private String name;
    private String email;


    public Person(String name, String email) {
        setName(name);
        setEmail(email);
    }
    
    public void setName(String _name){
        name = _name;
    }
    
    public void setEmail(String _email){
        email = _email;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
}
