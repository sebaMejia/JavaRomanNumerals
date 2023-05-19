package project2;

public abstract class RomanNumeralList {
	protected RomanNumeralListNode first;
	protected RomanNumeralListNode last;
	
	/**
	 * Constructor that takes in no arguments and sets both values to null.
	 */
	public RomanNumeralList() {
		first = new RomanNumeralListNode(null);
		last = first;
	}
	
	/**
	 * This is where the append method is sent with the roman numeral value being put through the
	 * node and then set to the appropriate positions from the nodes.
	 * @param r
	 */
	
	public void append(RomanNumeral r) {
		RomanNumeralListNode temp = new RomanNumeralListNode(r);
		last.next = temp;
		last = temp;
	}
	
	/**
	 * Basically turns the RomanNumeralList into string representation. 
	 */
	
	public String toString() {
		String result = "";
		RomanNumeralListNode show = first.next;
		while(show != null) {
			result += show.data + "\n";
			show = show.next;
		}
		return result;
	}
	
}
