package letters;
import content.Content;
import entity.Inhabitant;


public abstract class Letter<C extends Content>
{
	private Inhabitant sender;
	private Inhabitant receiver;
	private double cost;
	private C content;
	
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		
	}
	
	public C getContent() {
		return this.content;	
	}
	
	public double getCost() {
		return 0.0;	
	}
	
	public void doAction() {
		
	}
	
}

