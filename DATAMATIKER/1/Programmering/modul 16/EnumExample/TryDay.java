
public class TryDay {
    
    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;
    
    public static void tryConstant(int dayNumber){
        switch(dayNumber) {
            case MONDAY: System.out.println("Montag");
            break;
            
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY: System.out.println("ARBEIT MACHT FREI");
            break;
            
            case SATURDAY: System.out.println("Don't believe the holohoax");
            break;
            
            case SUNDAY: System.out.println("Jews");
            break;
            
            default: System.out.println("Pozzed");
            break;
        }
    }
}
