package letters;
import content.Content;
import entity.Inhabitant;

/**
 * Class to manage the letters
 * @author dubois bellamy
 *
 * @param <C> The content type of this letter
 */
public abstract class Letter<C extends Content> implements Content{
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected int cost;
	protected C content;
	
	/**
	 * Constructor of a new letter
	 * @param sender The inhabitant who's sent the letter
	 * @param receiver the inhabitant who's received the letter 
	 * @param content the content of this letter
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		
		cost = 1;
		
		sender.withdraw(cost);
	}
	
	/**
	 * Get the content of this letter
	 * @return the content of this letter
	 */
	public C getContent() {
		return this.content;	
	}
	
	/**
	 * Get the cost of this letter
	 * @return the cost of this letter
	 */
	public int getCost() {
		return this.cost;	
	}
	
	/**
	 * Do the action of this letter
	 */
	public abstract void doAction();
	
	/**
	 * Get the sender of this letter
	 * @return the sender of this letter
	 */
	public Inhabitant getSender() {
		return this.sender;
	}
	
	/**
	 * Get the receiver of this letter
	 * @return the receiver of this letter
	 */
	public Inhabitant getReceiver() {
		return this.receiver;
	}
}

