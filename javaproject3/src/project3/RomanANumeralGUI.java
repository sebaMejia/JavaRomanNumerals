package project3;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RomanANumeralGUI extends JFrame{
	public static JFrame myGUI;
	public static JTextArea originalL, JSortedRomanNumerals, JUnsortedRomanNumerals;
	public static JTextArea JStringTextFile, JInteger;
	static GridLayout gridLayout;
	/***
	 * Intializing the GUI
	 */
	public RomanANumeralGUI() {
		initialize();
	}
	
	/***
	 * Here is where we just set up the GUI so that the user and choose what option they want.
	 */
	
	public void initialize() {
		  myGUI = new JFrame("Project 3");
		  originalL = new JTextArea();
		  JUnsortedRomanNumerals = new JTextArea();
		  JSortedRomanNumerals = new JTextArea();
		  
	      myGUI.setSize(1200, 800);
	      myGUI.setLocation(400, 200);
	      gridLayout = new GridLayout(1, 3);
	      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      myGUI.getContentPane().setLayout(gridLayout);
	      
	      originalL.setEditable(false);
	      originalL.setLineWrap(true);
	      originalL.setWrapStyleWord(true);
	     
	      JUnsortedRomanNumerals.setEditable(false);
	      JUnsortedRomanNumerals.setLineWrap(true);
	      JUnsortedRomanNumerals.setWrapStyleWord(true);
	      
	      JSortedRomanNumerals.setEditable(false);
	      JSortedRomanNumerals.setLineWrap(true);
	      JSortedRomanNumerals.setWrapStyleWord(true);
	      createFileMenuBar();
	      myGUI.setVisible(true);
	   }
	
		/***
		 * After the initial GUI is set up, we have to set up the menu bars and what they do 
		 * specifically. We'll carry those actions to the FileMenuHandler class.
		 */
	   
	   private void createFileMenuBar() {
	      JMenuItem item;
	      JMenuBar menuBar = new JMenuBar();
	      JMenu fileMenu = new JMenu("File");
	      JMenu convertMenu = new JMenu("Convert");
	      FileMenuHandler fmh = new FileMenuHandler(this);
	      item = new JMenuItem("Open");
	      item.addActionListener(fmh);
	      fileMenu.add(item);
	      fileMenu.addSeparator();
	      JMenuItem item2 = new JMenuItem("Quit");
	      item2.addActionListener(fmh);
	      fileMenu.add(item2);
	      JMenuItem item3 = new JMenuItem("Roman To Arabic");
	      item3.addActionListener(fmh);
	      convertMenu.add(item3);
	      myGUI.setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	      menuBar.add(convertMenu);
	   }
	   
	   
	   /***
	    * 
	    * @param original 
	    * This is the original text being displayed on the left side.
	    * @param unsortedRomanNumerals
	    * The unsorted Roman Numerals being displayed on the center.
	    * @param sortedRomanNumerals
	    * The sorted Roman Numerals being displayed on the right side.
	    */

	   public static void printFileToGUI(String original, UnsortedRomanNumeralList unsortedRomanNumerals, SortedRomanNumeralList sortedRomanNumerals) {
	      originalL = new JTextArea(original);
		  JSortedRomanNumerals = new JTextArea(sortedRomanNumerals.toString());
		  JUnsortedRomanNumerals = new JTextArea(unsortedRomanNumerals.toString());
		  originalL.setPreferredSize(new Dimension(400, 400));
		  JSortedRomanNumerals.setPreferredSize(new Dimension(400, 400));
		  JUnsortedRomanNumerals.setPreferredSize(new Dimension(400, 400));
		  myGUI.add(originalL, BorderLayout.WEST);
		  myGUI.add(JUnsortedRomanNumerals, BorderLayout.CENTER);
		  myGUI.add(JSortedRomanNumerals, BorderLayout.EAST);
		  myGUI.setVisible(true);
	   }	
	
}
