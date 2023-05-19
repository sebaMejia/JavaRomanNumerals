package project3;

public class UnsortedRomanNumeralList extends RomanNumeralList{
	/**
	 * Super class to refer to the class it was derived from; the RomanNumeralList.
	 */
	public UnsortedRomanNumeralList() {
		super();
	}
	
	/**
	 * When we enter the original roman numeral value we move it onto the append method.
	 * @param romanNumeral
	 */
	public void add(RomanNumeral romanNumeral) {
		append(romanNumeral);
	}
	
}
