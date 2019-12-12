package application;

/**
 * Concrete Command: Add to List
 * @author Micah Weiberg
 * @version 12-11-19
 * @param <T> Generic type to be added to list
 * Project 4
 */
public class AddToList<T> implements MenuItem {

	/** ItemList object containing access to addToList() method */
	private ItemList<T> itemList;
	
	/** Element to be added to list */
	private String element;
	
	/**
	 * Constructor
	 * @param itemList ItemList object
	 */
	public AddToList(ItemList<T> itemList) {
		
		this.itemList = itemList;
	}
	
	/**
	 * Execute command to add element to specified ArrayList
	 * @return empty String
	 */
	@Override
	public String execute() {
		try {
			itemList.addToList(element);
			return "";
		} catch (Exception e) {
			return "Invalid Number\n";
		}
	}

	/**
	 * Prints instructions for entering elements into specified ArrayList
	 * @return String of instructions
	 */
	@Override
	public String instructions() {
		
		return "\nEnter " + itemList.getElementType() + " into List one at a time\n"
				+ "Enter the word \"quit\" to stop\n\n";
	}

	/**
	 * Prints instructions to enter a new element based on list size
	 * @return String of instructions
	 */
	@Override
	public String promptElement() {

		return "Enter " + itemList.getElementType().substring(0, itemList.getElementType().length() - 1) + 
				" " + (itemList.getList().size() + 1) + ": ";
	}
	
	/**
	 * Set element to be added to list when execute is called (setter method)
	 */
	@Override
	public void enterElement(String element) {

		this.element = element;
	}
	
	/**
	 * toString to be displayed in list of MenuItems
	 */
	public String toString() {
		
		return "Enter " + itemList.getElementType() + " into List ";
	}
}