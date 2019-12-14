package application;

import java.util.ArrayList;

/**
 * Concrete Command: Add New List
 * @author Micah Weiberg
 * @version 12-11-19
 * Project 4
 */
public class AddNewList implements MenuItem {

	/* ListViewer object to add new list to */
	private ListViewer listViewer;
	
	/* Specifies type of list to be created */
	private String listType;
	
	/**
	 * Constructor
	 * @param consoleMenu ConsoleMenu to add new list to
	 * @param listType Type of list to be created
	 */
	public AddNewList(ListViewer listViewer, String listType) {
		
		this.listViewer = listViewer;
		this.listType = listType;
	}
	
	/**
	 * Execute command to create new specified ArrayList
	 * @return Empty string
	 */
	@Override
	public String execute() {
		ArrayList<MenuItem> newOptions = new ArrayList<MenuItem>();
		if (listType.contentEquals("String")) {
			StringList sL = new StringList(new ArrayList<String>(), "words", "String");
			newOptions.add(new AddToList<String>(sL));
			newOptions.add(new PrintList<String>(sL));
			newOptions.add(new ClearList<String>(sL));
			newOptions.add(new SortList(sL));
			
		} else if (listType.contentEquals("Number")) {
			NumberList nL = new NumberList(new ArrayList<Number>(), "numbers", "Number");
			newOptions.add(new AddToList<Number>(nL));
			newOptions.add(new PrintList<Number>(nL));
			newOptions.add(new ClearList<Number>(nL));
			newOptions.add(new BiggestNumber(nL));
		}
		
		for (int i = 0; i < newOptions.size(); i++) {
			
		}
		
		listViewer.addMenuOptions(newOptions);
		
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
		
		return "Add " + listType + " List";
	}
}