
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course {
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int hours_per_week;
    private int number_of_weeks;
    private int price_per_hour;
    private String litterature;

    /**
     * Constructor for objects of class Course
     */
    public Course(String _name, String _desc) {
        
        if(_name.length() == 8 && _desc.length() > 15){
            System.out.println("Correct lengths of both description and name");
            name = _name;
            description = _desc;
        }
        
        if(_name.length() != 8){
            System.out.println("Error: Name not required length of 8");
        }
    
        if(_desc.length() < 16){
            System.out.println("Error: Description not required length of 16 or more");
        }
        
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String _name){
        name = _name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String _desc){
        if(_desc.length() > 15){
            description = _desc;
        }
        else{
            System.out.println("Error: Description not greater in length than 15");
        }
    }
    
    public int getHours_Per_Week(){
        return hours_per_week;
    }
    
    public void setHours_Per_Week(int _hours_per_week){
        hours_per_week = _hours_per_week;
    }
    
    public int getNumber_Of_Weeks(){
        return number_of_weeks;
    }
    
    public void setNumber_Of_Weeks(int _number_of_weeks){
        number_of_weeks = _number_of_weeks;
    }
    
    public int getPrice_Per_Hour(){
        return price_per_hour;
    }
    
    public void setPrice_Per_Hour(int _price_per_hour){
        price_per_hour = _price_per_hour;
    }
    
    public String getLitterature(){
        return litterature;
    }
    
    public void setLitterature(String _litterature){
        litterature = _litterature;
    }
    
    public int price_Of_Course(){
        int temp;
        
        temp = hours_per_week * number_of_weeks * price_per_hour;
        
        return temp;
    }
    
    public void Print(){
        int temp;
        
        temp = price_Of_Course();
        
        System.out.println(name + ": " + description + " Hours per Week: " + hours_per_week + " Number of Weeks: " + number_of_weeks + " Price per Hour: " +
        price_per_hour + " Litterature: " + litterature + " Price of the entire course: " + temp);
    }
    
    
    public String getFirstTen(){        
        return description.substring(0,10);
    }
    
    public int getLengthOfDescription(){
        return description.length();
    }
}
