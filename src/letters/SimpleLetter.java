package letters;

import content.TextContent;
import entity.Inhabitant;


public class SimpleLetter extends Letter<TextContent>
{

	public SimpleLetter(Inhabitant sender, Inhabitant reciever,	TextContent content) {
		super(sender, reciever, content);
	}

	@Override
	public void doAction() {
		
	}

	@Override
	public String getDescription() {
		return null;
	}
	

}

