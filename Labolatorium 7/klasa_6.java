import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import java.util.Scanner;

public class klasa_6 extends Agent {
	
	protected void setup()
	{
		System.out.println("Agent "+ getLocalName() + " startuje");
		
		addBehaviour(new CheckNumberVersionTwo());
		
	}

}

class CheckNumberVersionTwo extends SimpleBehaviour{

	boolean finished = false;

	public void action()
	{
		System.out.println("zachowanie startuje");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj liczbe: ");
		int mat = scanner.nextInt();
		if(mat < 0) {
			System.out.println("Zakonczenie dzialania pracy agenta.");
			finished = true;
		}
	}
		
	
	public boolean done()
	{
		if(finished)
			System.out.println("zachowanie zakonczone");
		return finished;
	}
}