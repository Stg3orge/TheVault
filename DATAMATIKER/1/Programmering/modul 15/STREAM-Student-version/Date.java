import java.time.*;
/**
 * This class represents a date that can be 
 * increased and decreased by one day and 
 * provides a String representation of the date.
 *
 * @author Kis Boisen Hansen, KNOL
 * @version 2011.03.14, 2015.10.13, 2016.10.16, 2017.10.18
 */
public class Date {
    // 1<= day <= days in month
    // 1<= month <= 12
    int day;
    int month;
    int year;
    /**
     * @param d day of the month
     * @param m month of the year
     * @param y the year 4 digits
     */
    public Date(int d, int m, int y) {
        System.out.println("I am created!");
        year = y;
        month = m;
        day = d;
    }

    public void setToNextDate() {
        //TODO implement this method stub
        day++;
        checkDayOverflow();
        System.out.println("NEXT");       
    }
    
    private void checkDayOverflow(){
        if(day > 30){
            day = 1;
            month++;
        }
    }
    
    
    
    public void setToPreviousDate() {
        //TODO implement this method stub
        System.out.println("BACK");
    }
    public String toString(){
        return year + "-" + (month < 10 ?"0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
    }
    // Use this in your toString():
    //return year + "-" + (month < 10 ? "0" : "") + m
}


