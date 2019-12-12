package application;

/**
 * Concrete Command: Print List
 * @author Micah Weiberg
 * @version 12-11-19
 * @param <T> Generic type to be added to list
 * Project 4
 */
public class PrintList<T> implements MenuItem {

	/** ItemList object containing access to printList() method */
	private ItemList<T> itemList;
	
	/**
	 * Constructor
	 * @param itemList ItemList object
	 */
	public PrintList(ItemList<T> itemList) {
		
		this.itemList = itemList;
	}

	/**
	 * Execute command to print specified ArrayList
	 * @return String of information
	 */
	@Override
	public String execute() {

		return "List is {" + itemList.printList() + "}";
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
		// do nothing		
	}

	/**
	 * toString to be displayed in list of MenuItems
	 */
	public String toString() {
		
		return "Print List ";
	}
}