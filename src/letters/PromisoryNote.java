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
	public String getDescription() {
		return null;
	}

	@Override
	public void doAction() {
		
	}

}
