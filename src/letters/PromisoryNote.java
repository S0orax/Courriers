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
		return "a promisory note letter whose content is money content ("+content.getAmount()+")";
	}

	/**
	 * Make money transfert and send an thanks letter
	 */
	@Override
	public void doAction() {
		sender.withdraw(content.getAmount());
		receiver.credit(content.getAmount());
		
		System.out.println("  - "+content.getAmount()+" euros are debited from "+sender.getName()+" account whose balance is now "+sender.getBalance()+" euros");
		System.out.println("  + "+receiver.getName()+" account is credited with "+content.getAmount()+" euros; Its balance is now "+receiver.getBalance()+" euros");
		
		// Make the thanks letter
		ThanksLetter thanks = new ThanksLetter(receiver, sender, this);
		// Send the letter
		sender.getCity().sendLetter(thanks);
		
		System.out.println("-> " + sender.getName()+" mails "+thanks.getDescription()+" to "+receiver.getName()+" for cost of "+thanks.getCost()+" euro(s)");
	}
}
