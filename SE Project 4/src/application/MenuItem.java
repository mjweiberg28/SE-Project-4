package application;

/**
 * Command interface that contains the execute and toString methods
 * @author Micah Weiberg
 * @version 12-15-19
 * Project 4
 */
public interface MenuItem {

	/** Execute the desired action 
	 * @throws Exception */
	public String execute() throws Exception;
	
	/** Return a String of relevant command instructions */
	public String instructions();
	
	/** Return a String of relevant prompts for the command */
	public String promptElement();
	
	/** Save element for command as a String */
	public void enterElement(String element);
	
	/** Return a String of information */
	public String toString();
}