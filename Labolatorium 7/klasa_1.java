import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class klasa_1 extends Agent{
	
	protected void setup()
	{
		System.out.println("startuje");
		
		
		System.out.println("zaraz sie usunie");
		doDelete();
	}

}

