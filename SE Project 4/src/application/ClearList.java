package application;

/**
 * Concrete Command: Clear List
 * @author Micah Weiberg
 * @version 12-15-19
 * @param <T> Generic type to be added to list
 * Project 4
 */
public class ClearList<T> implements MenuItem {

	/** ItemList object containing access to clearList() method */
	private ItemList<T> itemList;
	
	/**
	 * Constructor
	 * @param itemList ItemList object
	 */
	public ClearList(ItemList<T> itemList) {
		this.itemList = itemList;
	}
	
	/**
	 * Execute command to clear specified ArrayList
	 * @return String of information
	 */
	@Override
	public String execute() {
		itemList.clearList();
		return "";
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
		return "Clear List ";
	}
}