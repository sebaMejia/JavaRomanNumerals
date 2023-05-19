package project1;

/**
 * 
 * Sebastian Mejia
 * 
 * Lab CSCI 212-11D
 * 
 */
import javax.swing.JFrame;
import java.util.*;
import java.io.*;
import java.lang.Math;
public class Project1 {
    // Setting up the variables for the project. 
	public static String line, line2 = "", a, ab = "";
    public static void main(String[] args) {
        // Intialize the GUI 
        RomanANumeralGUI.initialization();
        // Reading the text file and then moving it to the while loop.
        TextFileInput in = new TextFileInput(args[0]);
        line = in.readLine();
        // This is a while loop that reads the whole text file until the very end, otherwise known as reaching null.
        while (line != null) {
            // Taking the string variable and tokenizing it, in other words, separating the string into sub-strings at every comma point.
            StringTokenizer tokenLine = new StringTokenizer(line, ",");
            // Same concept, if there are still more tokens left over, then keep running the while loop.
            while (tokenLine.hasMoreTokens()) {
                // This reads the token and moves onto the next and then transfers it to the line variable to then move to line2 so that it can be added up and printed.
                line = tokenLine.nextToken();
                line2 += line + "\n";
                // This is where the value for the string token is moved over to the method of romanToNumeral to change the string Roman number to the Arabic number. 
                a = String.valueOf(romanToNumeral(line));
                ab += a + "\n";
            }
            line = in.readLine();
        }
        // Once everything is done, the values are moved towards the GUI to be displayed. 
        RomanANumeralGUI.textArea(line2, ab);
    }
    
    public static int romanToNumeral(String s) {
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