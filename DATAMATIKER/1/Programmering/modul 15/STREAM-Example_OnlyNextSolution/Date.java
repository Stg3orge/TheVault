import java.time.*;
/**
 * Write a description of class Date here.
 *
 * @author Kis Boisen Hansen, KNOL
 * @version 2011.03.14, 2015.10.13, 2016.10.16
 */
public class Date {
    private int day;    // 1<= day <= days in month
    private int month;  // 1<= month <= 12
    private int year;

    /**
     * @param d day of the month
     * @param m month of the year
     * @param y the year 4 digits
     */
    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public void setToNextDate() {
        day = day + 1;
        checkDayOverFlow();
    }
    
    public void setToPreviousDate() {
        day = day - 1;
        checkDayUnderFlow();
    }

    /**
     * @return the date as a string
     */
    public String toString() {
        //return year + "-" + month + "-" + day;
        return year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
    }

    private void checkDayOverFlow() {
        if(day > daysInMonth()){
            day = 1;
            month = month + 1;
            checkMonthOverFlow();
        }
    }
    
    private void checkDayUnderFlow(){
        if(day < 1){
            day = daysInMonth();
            month = month - 1;
            checkMonthUnderFlow();
        }
    }
    
    private void checkMonthOverFlow() {
        if(month > 12){
            month = 1;
            year = year + 1;
        }
    }
    
    private void checkMonthUnderFlow(){
        if(month < 1){
            month = 12;
            year = year - 1;
        }
    }

    private int daysInMonth() {
        int[] numberOfDaysInMonth = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
        int number = numberOfDaysInMonth[month];
        //special case
        if(month == 2 && leapYear()) {
            number = number + 1;
        }
        return number;

    }

    private boolean leapYear() {
        if( divisibleBy(4, year) 
            && !(divisibleBy(100, year)) 
            || divisibleBy(400, year)) {
                
            return true;
        }
        else {
            return false;
        }
    }

    private boolean divisibleBy(int divisor, int yy) {
        if (yy % divisor == 0){
            return true;
        }
        else{    
            return false;
        }
    }
}


