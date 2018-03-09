
public class Display {

    private double height;
    private double width;
    private boolean isFlatScreen;
    private boolean haveLoudSpeakers;
    private String description;
    
    public Display(double height, double width, boolean isFlatScreen,
    boolean haveLoudSpeakers, String description) {
        this.height = height;
        this.width = width;
        this.isFlatScreen = isFlatScreen;
        this.haveLoudSpeakers = haveLoudSpeakers;
        this.description = description;
    }
    
    public void Print(){
        String newLine = System.getProperty("line.separator");
        
        System.out.println("Details of Monitor" + newLine
        + newLine + "Height: " + height + newLine + "Width: " + width + newLine
        + "Flatscreen monitor: " + isFlatScreen + newLine + "Includes Loud Speakers: " + haveLoudSpeakers
        + newLine + "Description: " + description);
    }

}
