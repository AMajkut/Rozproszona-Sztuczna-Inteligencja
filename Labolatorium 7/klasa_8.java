import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
public class klasa_8 extends Agent{
	
	protected void setup()
	{
		System.out.println("Start agenta");
		
		addBehaviour(new TickerBehaviour(this, 2000) {
			 protected void onTick() {
			 		System.out.println("maly tick");
			 	}
			 } );
		
		B behaviour = new B(this,5000);
		addBehaviour(behaviour);
		
		addBehaviour(new TickerBehaviour(this,50000)
				{
					protected void onTick()
					{
						removeBehaviour(behaviour);
					}
				});
		
		addBehaviour(new TickerBehaviour(this,100000)
				{
					protected void onTick()
					{
						System.out.println("Koniec agenta");
						doDelete();
					}
				});
	}

}

class B extends TickerBehaviour
{
	public B(Agent a, long period) {
		super(a, period);
	}

	protected void onTick()
	{
		System.out.println("duzy tick");
	}
}