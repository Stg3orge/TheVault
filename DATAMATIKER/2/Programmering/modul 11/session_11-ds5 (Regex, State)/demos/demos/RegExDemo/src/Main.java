import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
	public static void main(String args[]){
		
		checkEmail();
        getEmailList();
        checkIntegers();
        
	}
	
	public static void checkEmail() {
		String email = "finn.nordbjerg@gmail.com";
		String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        
        Pattern pattern = Pattern.compile(emailPattern);
 
        Matcher m = pattern.matcher(email);

        if(m.find())
          System.out.println(email + " is ok");
        else
            System.out.println(email + " is not ok");
        	
	}

	public static void getEmailList() {
		String doc = "Dette er en mailadresse: fen@ucn.dk og det er det"
                + "her også peter@peterfich.com og nogle flere:"
                + "moh@solar.dk; jens@hilli.dk; Tazzz-321@gmail.com, Mgj3aa@gmail.com;"
                + "mhj@logimatic.dk og så kommer der tekst igen."
                + "og en mailadresse uki@dadlnet.dk bla. bla."
                + " i alt 8 adresser plus den her: finn.nordbjerg@gmail.com";
		String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        
        Pattern pattern = Pattern.compile(emailPattern);
 
        Matcher m = pattern.matcher(doc);
        
        List<String> maillist = new LinkedList<>();
        while(m.find()) {

          maillist.add(m.group());
        }
        
        System.out.println("Expecting 9 email addresses:");
        int i= 1;
        for(String email : maillist)
        	System.out.println(i++ + "\t"+email);
	}
	
	public static void checkIntegers() {
		String number = "--123";
		String numberPattern = "^(\\+|-)?[0-9]+$";
        
        Pattern pattern = Pattern.compile(numberPattern);
 
        Matcher m = pattern.matcher(number);

        if(m.find())
          System.out.println(number + " is ok");
        else
            System.out.println(number + " is not ok");
        	
	}

}


