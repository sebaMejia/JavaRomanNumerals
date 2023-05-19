package project2;

/**
 * 
 * Sebastian Mejia
 * Project 2
 * Lab CSCI 212-11D
 * 
 */
import javax.swing.JFrame;

import java.util.*;
import java.io.*;
import java.lang.Math;
public class Project2 {
    // Setting up the variables for the project. 
	protected static SortedRomanNumeralList sortedList;
	protected static UnsortedRomanNumeralList unsortedList;
	public static String line = "", line2 ="", textInput;
	public static String[] tokens;
	public static int counter = 0;
	
	/**
	 * Basically takes in the file input and then tokenizes it to then
	 * be counted for and read and put into an array so that it can then be sent to 
	 * be added or appended to the respective list. 
	 * 
	 * The initialization of the GUI and the lists are also started here as well.
	 * @param x
	 */
	
    public static void  tokenize(String x) {
        // Intialize the GUI, unsorted and sorted lists
    	unsortedList = new UnsortedRomanNumeralList();
        sortedList = new SortedRomanNumeralList();
        RomanANumeralGUI.initialization();
        TextFileInput in = new TextFileInput(x);
        line = in.readLine();
        int c = 0;
        String s = "";
        while(line != null) {
            s += line + "\n";
            line = in.readLine();
        }
        s = s.replaceAll(",", " ");
        StringTokenizer myTokens = new StringTokenizer(s, "\n ");
        tokens = new String[myTokens.countTokens()];
        while(myTokens.hasMoreTokens()) {
        	tokens[c] = myTokens.nextToken();
            c++;
            }
        for(String numeral : tokens) {
        	RomanNumeral r = new RomanNumeral(numeral);
        	unsortedList.add(r);
        	sortedList.add(r);
        	line2 += numeral + "\n";
        }
        
        RomanANumeralGUI.textArea(line2, unsortedList, sortedList);
    }
    /**
     * Takes in the input.txt file.
     * @param args
     */
    public static void main(String [] args) {
    	tokenize("src/input.txt");
    	
    }
    
   
}