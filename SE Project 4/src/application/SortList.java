package application;

/**
 * Concrete Command: Sort List of Strings
 * @author Micah Weiberg
 * @version 12-15-19
 * Project 4
 */
public class SortList implements MenuItem {

	/** StringList object containing access to sortList() method */
	private StringList stringList;
	
	/**
	 * Constructor
	 * @param stringList StringList object
	 */
	public SortList(StringList stringList) {
		this.stringList = stringList;
	}
	
	/**
	 * Execute command to sort specified ArrayList
	 * @return String of information
	 */
	@Override
	public String execute() {
		stringList.sortList();
		return "List is now sorted";
	}

	/**
	 * Implemented method from MenuItem
	 * @return empty String
	 */
	@Override
	public String instructions() {
		return "";
	}

	/**
	 * Implemented method from MenuItem
	 * @return empty String
	 */
	@Override
	public String promptElement() {
		return "";
	}

	/**
	 * Implemented method from MenuItem, do nothing
	 */
	@Override
	public void enterElement(String element) {
	}

	/**
	 * toString to be displayed in list of MenuItems
	 */
	public String toString() {
		return "Sort List ";
	}
}