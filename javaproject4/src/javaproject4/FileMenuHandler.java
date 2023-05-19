package javaproject4;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FileMenuHandler implements ActionListener{
	
	// Regex for Roman Numerals only
	public static String pattern = "(^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$)";
	public static Pattern p = Pattern.compile(pattern);
	public static String num, testHolder ="", sum = "";
	public static String[] arrayHolder, tokens;
	public static String tester, line, line2 = "";
	RomanANumeralGUI romanGUI;
	JFrame jframe;
	
	/***
	 * 
	 * @param jf
	 * Setting up the JFrame for it. 
	 * 
	 */
	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}
	/***
	 * This is where the event that's pressed goes to and the option decides on how to exactly
	 * execute the task.
	 */
	
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		/**
		 * When the option open is clicked, the unsorted and sorted classes are initalized 
		 * and then the romanGUI is then passed to the openFile class.
		 */
		if(menuName.equals("Open")) {
			openFile(romanGUI);
		}
		/**
		 * Self-explanatory, once the user clicks Quit the program executes System.exit(0)
		 */
		
		else if(menuName.equals("Quit")) {
			System.exit(0);
		}
		/**
		 * The user is prompted to enter a Roman Numeral first and there's a checker
		 * to actually see if it even is a Roman Numeral and if it isn't, it's printed
		 * in a JPane and the console. 
		 */
		else if(menuName.equals("Roman To Arabic")) {
			while(true) {	
				try {
					String temp = JOptionPane.showInputDialog("Please enter a Roman Character: ");
					Matcher m = p.matcher(temp);
					if(m.find() && temp != null) 
						JOptionPane.showMessageDialog(null, (romanToNumeral(temp)));
					else 
						throw new IllegalRomanNumeralException(temp);
				}
				catch (IllegalRomanNumeralException ex) {
					System.out.println("The following are not Roman Numerals: " + ex);
					JOptionPane.showMessageDialog(null, "The following are not Roman Numerals: " + ex);
					
				}
			}
		}
		
	}
	/**
	 * 
	 * @param rG
	 * 
	 * The Roman GUI is passed through and it prompts a window to select a file to read
	 * the input and then pass it on to the readFile class. 
	 * 
	 */
	public void openFile(RomanANumeralGUI rG) {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		String filename = (chooser.getSelectedFile()).getAbsolutePath();
		readFile(filename);
	}	
	
	/***
	 * 
	 * @param test
	 * Gets the initial array value and then checks through every one of them to just get solely
	 * roman numerals.
	 * 
	 */
	
	public static void checker(String[] test) {
		String holder;
		for(int i = 0; i < test.length; i++) {
			holder = test[i]; 
			Matcher m2 = p.matcher(holder);
			if(!m2.matches()) {
				throw new IllegalRomanNumeralException(holder);
        	}
		}
	}
	
	/***
	 * 
	 * @param file
	 * Gets the initial file being thrown into the class and then reads it to then do two things.
	 * First: Reads the file and converts it into a string to then be displayed on the GUI.
	 * Second: Goes through a checker to see if it's a valid file to begin with that contains only
	 * valid Roman Numerals and then tokenizes it to get the length and then goes through
	 * the TreeMap sorting process. 
	 * 
	 */
	
	public static void readFile(String file) {
		try {
		TextFileInput in = new TextFileInput(file);
        line = in.readLine();
        int length = 0;
        String s = "";
        String [] test;
        arrayHolder = new String[100];
        while(line != null) {
            s += line.replaceAll(",", "\n") + "\n";
            line2 += line.replaceAll(",", "\n") + "\n";
            tester = line;
            testHolder += tester + "\n";
            test = tester.split("\\s*,\\s*");
            checker(test);
            line = in.readLine(); 
        }
        
        StringTokenizer myTokens = new StringTokenizer(s, "\n");
        tokens = new String[myTokens.countTokens()];
        while(myTokens.hasMoreTokens()) {
        	tokens[length] = myTokens.nextToken();
        	length++;
        }
        
        testHolder = testHolder.replaceAll("\n", ",");
        Map<String, Integer> treemap = new TreeMap<>(new RomanComparator());
        for(int i = 0; i < length; i++) {
        	String [] array = testHolder.split(",");	
        	String romanNum = array[i];
        	int arabicNum = romanToNumeral(String.valueOf(array[i]));
        	treemap.put(romanNum, arabicNum);
        }

        for(Map.Entry<String, Integer> entry : treemap.entrySet()) {
        	String rNum = entry.getKey();
        	int aNum = entry.getValue();
        	
        	sum += aNum + "\n";
        }
        RomanANumeralGUI.printFileToGUI(line2, sum);
		}
		catch(IllegalRomanNumeralException ex) {
			System.out.println("The following are not Roman Numerals: " + ex);
		}
	}
	
	/**
	 * 
	 * Comparator for the TreeMap where it has the same checking method as the 
	 * romanToNumeral class, except this intends to sort it through a series of
	 * for loops and if loops. 
	 *
	 */
	
	public static class RomanComparator implements Comparator<String>{
		public int compare(String RomanNum, String ArabicNum) {
			Map<Character, Integer> map = new HashMap<>();
			map.put('I', 1);
	        map.put('V', 5);
	        map.put('X', 10);
	        map.put('L', 50);
	        map.put('C', 100);
	        map.put('D', 500);
	        map.put('M', 1000);
	        
	        int result = 0;
	        
	        for(int i = 0; i < RomanNum.length(); i++) {
	        	// Takes in the roman numeral at the respective position to the string and makes it a new char variable.
	        	char c = RomanNum.charAt(i);
	        	// Grabs the value and the respective character digit for char c. 
	        	int value = map.get(c);
	        	// The value digit will get tallied into the result integer.
	        	result += value;
	        	
	        	if(i > 0 && value > map.get(RomanNum.charAt(i-1))) {
	        		result -= 2 * map.get(RomanNum.charAt(i-1));
	        	}
	        }
	        
	        int result2 = 0;
	        
	        for(int i = 0; i < ArabicNum.length(); i++) {
	        	char c = ArabicNum.charAt(i);
	        	int value = map.get(c);
	        	result2 += value;
	        	if(i > 0 && value > map.get(ArabicNum.charAt(i-1))) {
	        		result2 -= 2*map.get(ArabicNum.charAt(i-1));
	        	}
	        	
	        }
	        return Integer.compare(result, result2);
		}
		
	}
	
	/***
	 * 
	 * @param s
	 * String s is basically the roman numeral being put in to then go through the hashmap 
	 * to find what number it is equivalent to.
	 * @return
	 * It returns the arabic numeral. 
	 */
	
	public static int romanToNumeral(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
	}
	
}