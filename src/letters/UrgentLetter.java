package letters;

import entity.Inhabitant;

public class UrgentLetter extends Letter<Letter<?>> {
	
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
		
		cost *= 2;
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
		return "an urgent letter whose content is "+content.toString();
	}
}
