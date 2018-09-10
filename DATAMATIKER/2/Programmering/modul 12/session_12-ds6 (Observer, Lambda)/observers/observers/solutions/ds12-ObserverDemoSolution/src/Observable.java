/**
 * @author fen
 *
 */


public interface Observable {
    public void notifyObservers();
    public void addObserver(Observer obs);
    public void removeObser(Observer obs);
}
