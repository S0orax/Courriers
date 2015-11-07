package letters;

import entity.Inhabitant;

public class UrgentLetter extends Letter<Letter<?>> {

	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void doAction() {
		
	}

}
