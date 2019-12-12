package application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * NumberList class that extends ItemList as Number objects
 * @author Micah Weiberg
 * @version 12-11-19
 * Project 4
 */
public class NumberList extends ItemList<Number> {
	
	/** ArrayList of Numbers */
	private ArrayList<Number> aL;
	
	/** Specifies the type of element being entered (words, numbers, etc) */
	private String elementType;
	
	/** Specifies the type of list (String, Number, etc) being executed */
	private String listType;
	
	/** PropertyChangeSupport for firing a request to change */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/**
	 * Constructor
	 * @param aL ArrayList of Numbers
	 * @param elementType Type of element to be entered (numbers)
	 * @param listType Type of list being executed (Number)
	 */
	public NumberList(ArrayList<Number> aL, String elementType, String listType) {
		this.aL = aL;
		this.elementType = elementType;
		this.listType = listType;
	}
	
	/**
	 * Adds an element to the specified ArrayList
	 * @param element Element to add to ArrayList
	 */
	@Override
	public void addToList(String element) {
		if (element == null) {
			return;
		}
		
		// try parsing String as Integer and add to list,
		// if this fails, parse as Double and add to list
		try {
			Integer parsedElement = Integer.parseInt(element);
			aL.add(parsedElement);
			
		} catch (NumberFormatException e) {
			Double parsedElement = Double.parseDouble(element);
			aL.add(parsedElement);
		}
	}
	
	/**
	 * Method for HW 32 to add an element to the NumberList
	 * End result is the same as addToList(String), except that the current
	 * project is set up to work with the implemented method addToList
	 * that takes in a String instead of a Number and parses it to a
	 * Number before adding it to the list
	 * @param element Number to add to list
	 */
	public void addNumber(Number element) {
		if (element == null) {
			return;
		}
		ArrayList<Number> oldValue = aL;
		aL.add(element);
		this.pcs.firePropertyChange("addElement", oldValue, aL);
	}

	/**
	 * Prints the elements within the specified ArrayList
	 * @return String of elements from ArrayList
	 */
	@Override
	public String printList() {

		String listString = ""; // initialize variable

		for (int i = 0; i < aL.size(); i++) {
			listString += aL.get(i) + ", ";
		}
		
		// if list is not empty, remove last 2 characters from String
		// last 2 chars would be ", " from adding the last element in for loop
		if (!aL.isEmpty()) {
			listString = listString.substring(0, listString.length() - 2);
		}
		
		this.pcs.firePropertyChange("printList", null, null);
		return listString;
	}

	/**
	 * Clears the elements within the specified ArrayList
	 */
	@Override
	public void clearList() {
		ArrayList<Number> oldValue = aL;
		aL.clear();
		this.pcs.firePropertyChange("clearList", oldValue, aL);
	}
	
	/**
	 * Finds largest element within the specified ArrayList
	 * @return Largest Number within ArrayList
	 */
	public Number getLargestNumber() {
		try {		
			// initialize variable to first element of list
			Number largest = aL.get(0);		
			
			for (int i = 0; i < aL.size(); i++) {
				
				// set element at i and "largest" variable as BigDecimal objects with Double values
			    BigDecimal b1 = new BigDecimal(aL.get(i).doubleValue());
			    BigDecimal b2 = new BigDecimal(largest.doubleValue());
			    
			    // if element at i is larger than current "largest" variable, update variable to new value
			    if (b1.compareTo(b2) == 1) {
			    	largest = aL.get(i);
			    }
			}
			this.pcs.firePropertyChange("largestNum", null, null);
			return largest;
			
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Biggest number does not exist. List is empty.");
		}
	}
	
	/**
	 * Adds PropertyChangeListener to NumberList objects
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
	public ArrayList<Number> getList() {
		return aL;
	}
}