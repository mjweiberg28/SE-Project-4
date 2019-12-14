package application;

import java.util.ArrayList;
import java.util.Collections;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * StringList class that extends ItemList as String objects
 * @author Micah Weiberg
 * @version 12-11-19
 * Project 4
 */
public class StringList extends ItemList<String> {

	/** ArrayList of Strings */
	private ArrayList<String> aL;
	
	/** Specifies the type of element being entered (words, numbers, etc) */
	private String elementType;
	
	/** Specifies the type of list (String, Number, etc) being executed */
	private String listType;
	
	/** PropertyChangeSupport for firing a request to change */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
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
	 */
	@Override
	public void addToList(String element) {
		int oldValue = aL.size();
		aL.add(element);
		int newValue = aL.size();
		System.out.println("old: " + oldValue + " new: " + newValue);
		this.pcs.firePropertyChange("addElement", oldValue, newValue);
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
		int oldValue = aL.size();
		aL.clear();
		int newValue = aL.size();
		this.pcs.firePropertyChange("clearList", oldValue, newValue);
	}
	
	/**
	 * Sorts the elements within the specified ArrayList
	 * @param aL ArrayList of Strings
	 */
	public void sortList() {
		boolean oldValue = false;
		ArrayList<String> copyList = new ArrayList<String>(aL);
		for (int i = 0; i < aL.size(); i++) {
			System.out.println(aL.get(i));
		}
		Collections.sort(aL);
		this.pcs.firePropertyChange("sortList", oldValue, aL);
	}
	
	/**
	 * Adds PropertyChangeListener to StringList objects
	 * @param listener object listening for changes
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}
	
	/**
	 * Removes PropertyChangeListener
	 * @param listener object listening for changes
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
	
	/**
	 * Getter for element type of list
	 * @return String for element type ("numbers")
	 */
	@Override
	public String getElementType() {
		return elementType;
	}

	/**
	 * Getter for list type
	 * @return String for list type ("Number")
	 */
	@Override
	public String getListType() {
		return listType;
	}

	/**
	 * Getter for ArrayList of Numbers
	 * @return list of Numbers
	 */
	@Override
	public ArrayList<String> getList() {
		return aL;
	}
}