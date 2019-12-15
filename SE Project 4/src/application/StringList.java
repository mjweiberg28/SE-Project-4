package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * StringList class that extends ItemList as String objects
 * @author Micah Weiberg
 * @version 12-15-19
 * Project 4
 */
public class StringList extends ItemList<String> {

	/** ArrayList of Strings */
	private ArrayList<String> aL;
	
	/** Specifies the type of element being entered (words, numbers, etc) */
	private String elementType;
	
	/** Specifies the type of list (String, Number, etc) being executed */
	private String listType;
	
	/**
	 * Constructor
	 * @param aL ArrayList of Strings
	 * @param element Element to add to list
	 * @param elementType Type of element to be entered (words)
	 * @param listType Type of list being executed (StringList)
	 */
	public StringList(ArrayList<String> aL, String elementType, String listType) {
		this.aL = aL;
		this.elementType = elementType;
		this.listType = listType;
	}

	/**
	 * Adds an element to the specified ArrayList
	 * @param aL ArrayList of Strings
	 * @param element Element to add to ArrayList
	 * @throws Exception if String is empty
	 */
	@Override
	public void addToList(String element) throws Exception {
		if (element == null || element.isEmpty()) {
			throw new Exception("Invalid String");
		}
		aL.add(element);
	}

	/**
	 * Prints the elements within the specified ArrayList
	 * @param aL ArrayList of Strings
	 * @return String of elements from ArrayList
	 */
	@Override
	public String printList() {
		String listString = ""; // initialize variable

		for (int i = 0; i < aL.size(); i++) {
			listString += aL.get(i)+ ", ";
		}
		
		// if list is not empty, remove last 2 characters from String
		// last 2 chars would be ", " from adding the last element in for loop
		if (!aL.isEmpty()) {
			listString = listString.substring(0, listString.length() - 2);
		}
		return listString;
	}

	/**
	 * Clears the elements within the specified ArrayList
	 * @param aL ArrayList of Strings
	 */
	@Override
	public void clearList() {
		aL.clear();
	}
	
	/**
	 * Sorts the elements within the specified ArrayList
	 * @param aL ArrayList of Strings
	 */
	public void sortList() {
		Collections.sort(aL);
	}
	
	/**
	 * Getter for element type of list
	 * @return String for element type ("words")
	 */
	@Override
	public String getElementType() {
		return elementType;
	}

	/**
	 * Getter for list type
	 * @return String for list type ("String")
	 */
	@Override
	public String getListType() {
		return listType;
	}

	/**
	 * Getter for ArrayList of Strings
	 * @return list of Strings
	 */
	@Override
	public ArrayList<String> getList() {
		return aL;
	}
}