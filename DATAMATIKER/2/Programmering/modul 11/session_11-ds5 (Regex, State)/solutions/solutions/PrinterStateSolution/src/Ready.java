/** 
  * @author (FEN)
  * @version (2015-03-17)
  */
public class Ready extends State {

	public Ready() {
		super();
	}

	@Override
	public void action() {
        System.out.println("Printer ready...");
        //Printer is waiting to receive a job
	}

}
