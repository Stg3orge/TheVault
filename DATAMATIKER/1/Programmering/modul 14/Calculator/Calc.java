import java.util.*;
public class Calc {
    private static Scanner scanner;
    
    static{
        scanner = new Scanner(System.in);
    }
    
    private static ArrayList<Integer> calcList;
    
    public static void calc(){
        calcList = new ArrayList<>();
        double a = promptDouble("Gimme a number: ");
        double b = promptDouble("Gimme another one: ");
        
        System.out.println("Make your choice. " + "\n" + "Options are: " + "addition " + "subtract " + "mult " + "divide");
        String c = choice(scanner.nextLine());
        //int x = (int)a;
        //System.out.println(a + " + " + b + " + " + " = " + (a+b));
    }
    
    public static double promptDouble(String text){
        System.out.println(text);
        String input = scanner.nextLine();
        double res = Double.parseDouble(input);
        return res;
    }
    
    public static String choice(String input){
        System.out.println("What should be calculated?");
        System.out.println("Choices are: " + "\n" + "add"
        + "\n" + "subtract" + "\n" + "mult" + "\n" + "divide");
        switch(input){
            case "add": addition();
                break;
            case "subtract":
                break;
            case "mult":
                break;
            case "divide":
                break;
            default: System.out.println("Invalid Input");
                break;
        }
    }
    
    public static double addition(){
       
    }
    
}