package letters;
import content.Content;
import entity.Inhabitant;


public abstract class Letter<C extends Content>
{
	private Inhabitant sender;
	private Inhabitant reciever;
	private double cost;
	private C content;
	
	public Letter(Inhabitant sender, Inhabitant reciever, C content) {
		this.sender = sender;
		this.reciever = reciever;
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

