

import static org.junit.Assert.*;
import org.junit.After; 
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestNewsFeed.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestNewsFeed
{
    private NewsFeed newsFeed1;
    private MessagePost messageP1;
    private PhotoPost photoPos1;
    private MessagePost messageP2;

    
    
    
    

    /**
     * Default constructor for test class TestNewsFeed
     */
    public TestNewsFeed()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        newsFeed1 = new NewsFeed();
        messageP1 = new MessagePost("Joe", "Banana is good for you!");
        photoPos1 = new PhotoPost("Joe", "banana.jpg", "A tasty banana");
        messageP2 = new MessagePost("Jane", "I like your banana!");
        newsFeed1.addMessagePost(messageP1);
        newsFeed1.addPhotoPost(photoPos1);
        newsFeed1.addMessagePost(messageP2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
