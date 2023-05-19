package project3;

public class SortedRomanNumeralList extends RomanNumeralList{
	/**
	 * Same thing as the unsorted roman numeral list where it refers to the class
	 * it was derived from.
	 */
	public SortedRomanNumeralList() {
		super();
	}
	
	/**
	 * Puts the roman numeral value into a RomanNumeralListNode variable and then
	 * sets the pointers for the LinkedLists so that it can be appropriately 
	 * organized and sorted with the if method appending the value of romanNumeral
	 * since first.next is by default null. 
	 * 
	 * Afterwhich, the while statement basically compares the romanNumeral to see
	 * if it's greater than zero and it the one right after isn't null. If those
	 * statements are true, then it will set the first in the LinkedList to the next one
	 * and thereafter as well with the one after that.
	 * 
	 * Once it breaks from that then it goes onto the setting part for the temp variable
	 * from the next pointer and then viceversa.
	 * 
	 * 
	 * @param romanNumeral
	 */
	
	public void add(RomanNumeral romanNumeral) {
		
		RomanNumeralListNode temp = new RomanNumeralListNode(romanNumeral);
		RomanNumeralListNode pointer = first;
		RomanNumeralListNode pointern = first.next;
		
		if(pointern == null) {
			append(romanNumeral);
		}
		
		while(pointer.next.data.compareTo(romanNumeral) > 0 && pointer.next != null) {
			pointer = pointer.next;
			pointern = pointer.next;
		}
		
		pointer.next = temp;
		temp.next = pointern;
	}
	
}
