package letters;

import content.TextContent;
import entity.Inhabitant;

public class RegisteredLetter extends Letter<Letter<?>>{

	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}

	@Override
	public String getDescription() {
		return "a registered letter whose content is "+content.getDescription();
	}

	/**
	 * Send an aknowledgment
	 */
	@Override
	public void doAction() {
		TextContent text = new TextContent("aknowledgment of receipt for "+content.getDescription());

		SimpleLetter aknowledgment = new SimpleLetter(receiver, sender, text);
		
		sender.getCity().sendLetter(aknowledgment);
		
		// If its content is 
		content.doAction();
	}
}
