package application;

/**
 * Concrete Command: Biggest Number in List
 * @author Micah Weiberg
 * @version 12-11-19
 * Project 4
 */
public class BiggestNumber implements MenuItem {

	/** NumberList object containing access to largestElement() method */
	private NumberList numberList;
	
	/**
	 * Constructor
	 * @param numberList NumberList object
	 */
	public BiggestNumber(NumberList numberList) {
		
		this.numberList = numberList;
	}
	
	/**
	 * Execute command to return biggest number in specified ArrayList
	 * @return String of information
	 */
	@Override
	public String execute() {
		// if largest element is the negative of Double's max value, list is empty
		try {
			return "Biggest number in List is " + numberList.getLargestNumber();
		} catch (IndexOutOfBoundsException e) {
			return "Biggest number does not exist. List is empty.";
		}
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
		
		return "Return biggest number in List ";
	}
}