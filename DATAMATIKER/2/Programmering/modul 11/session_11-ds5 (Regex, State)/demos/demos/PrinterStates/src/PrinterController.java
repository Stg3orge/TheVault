import java.io.Console;

 /**
     * Simulates controlling of a printer
     * 
     * @author (FEN)
     * @version (2015-03-17)
     */

enum Events { print, goReady, done, cancel, readyToPrint, unknown };

class PrintController
{

    private Start  start;
    private Printing printing;
    private Ready ready;
    private End end;

    public PrintController()
    {
        start = new Start();
        printing = new Printing();
        ready = new Ready();
        end = new End();

        start.addTransition(Events.readyToPrint, printing);
        start.addTransition(Events.cancel, end);
        
        printing.addTransition(Events.cancel, end);
        printing.addTransition(Events.done, end);

        ready.addTransition(Events.print, start);

        end.addTransition(Events.goReady, ready);
    }

    public void Printer()
    {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        boolean done = false;
        State currState = ready;
        while (!done)
        {
            currState.action();
            Events e = getNextEvent(currState);
            currState = currState.transition(e);

            System.out.println();
            System.out.print("Switch printer off (y/n)? ");
            String answer = console.readLine();
            System.out.println();
            if (answer.equals("y")) done = true;
        }
    }

    private Events getNextEvent(State s)
    {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        boolean error = false;
        Events e= Events.unknown;
        do
        {
            error = false;
            e = Events.unknown;
            System.out.println("Posible events: "+s.eventString());
            System.out.print("Next event: ");
            String inputStr = console.readLine();
            if (inputStr.equals("print"))
                e = Events.print;
            else if (inputStr.equals("goReady"))
                e = Events.goReady;
            else if (inputStr.equals("done"))
                e = Events.done;
            else if (inputStr.equals("cancel"))
                e = Events.cancel;
            else if (inputStr.equals("readyToPrint"))
                e = Events.readyToPrint;
            else
                error = true;
        } while (error);

        return e;
    }
}