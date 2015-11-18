package test.letter;

import static org.junit.Assert.*;
import letters.Letter;
import letters.RegisteredLetter;
import content.Content;
import entity.Inhabitant;

public class TestRegisteredLetter extends TestLetter {

	@Override
	protected Letter<?> createLetter(Inhabitant sender, Inhabitant receiver) {
		return new RegisteredLetter(sender, receiver, new MookLetter(sender, receiver, new MookContent()));
	}

	@Override
	protected void testDoActionForThisLetter() {
		MookLetter letterContent = (MookLetter) this.letter.getContent();
		MookContent content = (MookContent) letterContent.getContent();
		
		
		
		assertFalse(letterContent.actionDone);
		assertFalse(content.actionDone);
		this.letter.doAction();
		assertTrue(letterContent.actionDone);
		assertTrue(content.actionDone);
	}
	
	class MookContent implements Content {
		
		private boolean actionDone;
		
		public MookContent() {
			this.actionDone = false;
		}
		
		@Override
		public String getDescription() {
			this.actionDone = true;
			return "test";
		}
		
	}
	
	class MookLetter extends Letter<MookContent> {
		
		private boolean actionDone;
		
		public MookLetter(Inhabitant sender, Inhabitant receiver, MookContent content) {
			super(sender, receiver, content);
			this.actionDone = false;
		}

		@Override
		public String getDescription() {
			return this.content.getDescription();
		}

		@Override
		public void doAction() {
			this.actionDone = true;
			this.getDescription();
		}
		
	}

}
