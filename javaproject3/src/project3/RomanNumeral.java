package project3;

public class RomanNumeral implements Comparable<RomanNumeral>{
	private String RomanNumeral;
	private int ArabicNum;
	/**
	 * Takes the string of the roman numeral to then be put into the constructor 
	 * so that it can then be turned into the Arabic Num.
	 * @param RomanNumeral
	 */
	public RomanNumeral(String RomanNumeral){
		this.RomanNumeral = RomanNumeral;
		this.ArabicNum = romanToNumeral(RomanNumeral);
		this.RomanNumeral = String.valueOf(ArabicNum);	
	}
	
	/**
	 * Get method to return the roman numeral.
	 * @return
	 */
	
	public String getRomanNumeral() {
		return RomanNumeral;
	}
	
	/**
	 * String that we took for the roman numeral but we set it into the 
	 * method.
	 * @param romanNumeral
	 */
	
	public void setRomanNumeral(String romanNumeral) {
		this.RomanNumeral = romanNumeral;
		this.ArabicNum = romanToNumeral(romanNumeral);
		this.RomanNumeral = String.valueOf(ArabicNum);
	}
	/**
	 * Get method to return the Arabic Num.
	 * @return
	 */
	public int getArabicNum() {
		return ArabicNum;
	}
	
	public boolean equals(RomanNumeral other) {
		return this.ArabicNum == other.ArabicNum;
	}
	
	public String toString() {
		return RomanNumeral;
	}
	/**
	 * This is where we compare the arabic num to input that we receive from the 
	 * sorted method.
	 */
	public int compareTo(RomanNumeral other) {
		return ArabicNum - other.ArabicNum;
	}
	/**
	 * Previously used on Project 1; to convert the Roman Numeral string and case switching
	 * to get the equivalent in arabic numbers.
	 * @param s
	 * @return
	 */
	private int romanToNumeral(String s) {
        // Makes an array integer value that looks for new 
    	int n[] = new int[s.length()];
    	// For loop that runs until the end of the string value's length.
        for (int i = 0; i < s.length(); i++) {
        	// This is where the respective character of the string is switched with the value of the number corresponding to the roman and arabic number.
            switch (s.charAt(i)) {
                case 'M':
                    n[i] = 1000;
                    break;
                case 'D':
                    n[i] = 500;
                    break;
                case 'C':
                    n[i] = 100;
                    break;
                case 'L':
                    n[i] = 50;
                    break;
                case 'X':
                    n[i] = 10;
                    break;
                case 'V':
                    n[i] = 5;
                    break;
                case 'I':
                    n[i] = 1;
                    break;
            }
        }
        // After the for loop, this is where we check, the whole value of the string. 
        int sum = 0;
        // This is where the roman numerals are check to see if they're applicable in regards to the rules of how it works.
        for (int i = 0; i < n.length - 1; i++) {
        	// If the Roman character before is less than the one right after it then the code block below will be executed.
            if (n[i] < n[i + 1])
                sum -= n[i];
            else
                sum += n[i];
        }
        return sum + n[n.length - 1];
    }
	

}
