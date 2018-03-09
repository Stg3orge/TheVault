import java.util.*;
public class Try {
    public static void main(String... args) {
        NewsFeed nf = new NewsFeed();
        
        System.out.println("DEBUG: Creating message from Joe \"Banana is good for you!\"");
        MessagePost mp1 = new MessagePost("Joe", "Banana is good for you!");
        nf.addMessagePost(mp1);
        
        System.out.println("DEBUG: Creating photo post from Joe \"A tasty banana, enjoy!\"");
        PhotoPost pp1 = new PhotoPost("Joe", "tasty_banana.jpg", "A tasty banana, enjoy!");
        nf.addPhotoPost(pp1);
        
        System.out.println("DEBUG: Creating message from Dorianne \"I like your banana, Joe!\"");
        MessagePost mp2 = new MessagePost("Dorianne", "I like your banana, Joe!");
        nf.addMessagePost(mp2);
        
        System.out.println("\nENTER to continue");
        new Scanner(System.in).nextLine();
        
        System.out.println("\n             *****************\nDEBUG: Displaying all posts\n\n");
        
        nf.show();
    }
}