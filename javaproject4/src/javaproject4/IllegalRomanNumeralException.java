package javaproject4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IllegalRomanNumeralException extends IllegalArgumentException {
	/***
	 * 
	 * @param temp
	 * This is just the initial message being passed through. 
	 */
	public IllegalRomanNumeralException(String temp) {
		super(temp);
	}
	
}
