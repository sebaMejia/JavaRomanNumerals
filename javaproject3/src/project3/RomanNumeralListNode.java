package project3;

public class RomanNumeralListNode{

	protected RomanNumeral data;
	protected RomanNumeralListNode next;
	
	/**
	 * Sets the node constructor which sets the data value to the data that is entered
	 * and then the next value is set to null. 
	 * @param data
	 */
	
	public RomanNumeralListNode(RomanNumeral data) {
		this.data = data;
		next = null;
	}
	
}
