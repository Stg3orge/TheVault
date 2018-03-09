package controller;

public class Controller {
    //private Container container;
    
    public Controller(){
        
    }
    
    public void createMember(String name, String phone, String mail){
        model.Member m = new model.Member(name, phone, mail);
        model.Container.getInstance().addMember(m);
    }
}
