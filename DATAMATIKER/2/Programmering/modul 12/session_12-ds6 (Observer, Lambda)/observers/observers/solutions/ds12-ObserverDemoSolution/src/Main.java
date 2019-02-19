/**
 * @author fen
 * 2015-03-20
 *
 */
public class Main {
    public static void main(String[] args)
    {
        Bottle myBottle = new Bottle();
        Observer happyHarry = new Optimist();
        Observer sensibleSam = new Realist();
        Observer boaringBill = new Pessimist();
        myBottle.addObserver(happyHarry);
        myBottle.addObserver(boaringBill);
        myBottle.addObserver(sensibleSam);
        
        System.out.println("Drinking:");
        myBottle.changeAmount(33);

        System.out.println("Filling bottle:");
        myBottle.fillBottle();
    }

}
