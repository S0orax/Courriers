package letters;

import entity.Inhabitant;

public class RegisteredLetter extends Letter<Letter<?>>{

	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}

	@Override
	public String getContentDescription() {
		return null;
	}

	@Override
	public void doAction() {
		
	}
	
	@Override
	public String toString() {
		return "a registered letter whose content is "+content.toString();
	}

}
