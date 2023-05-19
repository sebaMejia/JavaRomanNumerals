package project3;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FileMenuHandler implements ActionListener{
	protected static SortedRomanNumeralList sortedList;
	protected static SortedRomanNumeralList sortedList2;
	protected static UnsortedRomanNumeralList unsortedList;
	protected static UnsortedRomanNumeralList unsortedList2;
	public static String[] tokens;
	public static String pattern = "(^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$)";
	public static Pattern p = Pattern.compile(pattern);
	
	RomanANumeralGUI romanGUI;
	JFrame jframe;
	public static String tester, line, line2 = "", a, ab = "", temp2;
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
			unsortedList = new UnsortedRomanNumeralList();
			sortedList = new SortedRomanNumeralList();
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
	
	public static void readFile(String file) {
		
		try {
		TextFileInput in = new TextFileInput(file);
        line = in.readLine();
        int c = 0;
        String s = "";
        String [] test;
        while(line != null) {
            s += line + "\n";
            tester = line;
            test = tester.split("\\s*,\\s*");
            checker(test);
            line = in.readLine(); 
        }
        s = s.replaceAll(",", " ");
        StringTokenizer myTokens = new StringTokenizer(s, "\n ");
        /*s = s.replaceAll(" ", "");
        Matcher m2 = p.matcher(s);
        if(!m2.find())
        	throw new IllegalRomanNumeralException(s);*/
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
        RomanANumeralGUI.printFileToGUI(line2, unsortedList, sortedList);
		}
		catch(IllegalRomanNumeralException ex) {
			System.out.println("The following are not Roman Numerals: " + ex);
		}
		
		
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
