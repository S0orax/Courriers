package content;

public class TextContent implements Content
{

	private String message;
	
	public TextContent(){
		super();
	}

	public String getMessage() {
		return this.message;	
	}
	
	public String getDescription() {
		return "";	
	}
	
}

