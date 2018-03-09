
/**
 * Implements a click counter, also called a tally counter.
 * At e.g. events, organizers often want to know how many people attended. 
 * Surveys are often conducted by counting e.g. people or cars passing by.
 * For this, a click counter is often used. 
 * A person resets the click counter - modeled by calling the reset() method.
 * He then clicks the counter every time he observes what he wishes to count. Modeled by calling the click() method.
 * The current count is displayed on counter, here modeled by calling the getCount() method.
 * 
 * Task:
 * Implement JUnit test class, and test all the functions.
 * Do they pass the tests as expected?
 * If you find errors, fix the code!
 * 
 * @author Istvan Knoll
 * @version 2014-10-27
 */
public class ClickCounter {
    private int count;
    
    /**
     * Creates a new ClickCounter object
     */
    public ClickCounter() {
        count=0;
    }
    
    /**
     * Returns the current count - the display value of the click counter
     * @return count the value that would be showing on the click counter
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Models the behaviour of the click counter. Each click increments count by 1.
     */
    public void click() {
        count += count + 1;
    }
    
    /**
     * Resets count to 0.
     */
    public void reset() {
        if(count == 0){
        }
    }
}
