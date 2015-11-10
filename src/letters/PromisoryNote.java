package letters;

import content.Content;
import content.MoneyContent;
import entity.Inhabitant;

public class PromisoryNote extends Letter<MoneyContent> {

	public PromisoryNote(Inhabitant sender, Inhabitant receiver, MoneyContent content) {
		super(sender, receiver, content);
	}

	/**
	 * @see Content#getDescription()
	 */
	public String getContentDescription() {
		return null;
	}

	@Override
	public void doAction() {
		
	}
	
	@Override
	public String toString() {
		return "a promisory note letter";
	}
}
