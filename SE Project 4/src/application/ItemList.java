package application;

import java.util.ArrayList;

/**
 * Abstract class to define methods for ArrayLists of specified type
 * @author Micah Weiberg
 * @version 12-11-19
 * @param <T>
 * Project 4
 */
public abstract class ItemList<T> {	
	/**
	 * Adds an element to the specified ArrayList
	 * @param aL ArrayList of Generic type
	 * @param element String to add to ArrayList
	 */
	public abstract void addToList(String element);
	
	/**
	 * Prints the elements within the specified ArrayList
	 * @param aL ArrayList of Generic type
	 * @return String of elements from ArrayList
	 */
	public abstract String printList();
	
	/**
	 * Clears the elements within the specified ArrayList
	 * @param aL ArrayList of Generic type
	 */
	public abstract void clearList();
	
	/**
	 * Getter for specified ArrayList
	 * @return ArrayList being called
	 */
	public abstract ArrayList<T> getList();
	
	/**
	 * Getter for the type of element being added
	 * @return String of element type
	 */
	public abstract String getElementType();
	
	/**
	 * Getter for the type of list
	 * @return String of list type
	 */
	public abstract String getListType();
}