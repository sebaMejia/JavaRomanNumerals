package javaproject4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class RomanANumeralGUI extends JFrame{
	public static JFrame myGUI;
	public static JTextArea originalL, JSortedRomanNumerals;
	public static JTextArea JStringTextFile, JInteger;
	static GridLayout gridLayout;
	
	
	/***
	 * Calling the initialization method.
	 */
	
	public RomanANumeralGUI() {
		initialize();
	}
	
	/***
	 * This is where the GUI is starting to set up its properties before moving onto the menu bars.
	 */
	
	public void initialize() {
		  myGUI = new JFrame("Project 4");
		  originalL = new JTextArea();
		  JSortedRomanNumerals = new JTextArea();
		  
	      myGUI.setSize(1200, 800);
	      myGUI.setLocation(400, 200);
	      gridLayout = new GridLayout(1, 2);
	      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      myGUI.getContentPane().setLayout(gridLayout);
	      
	      originalL.setEditable(false);
	      originalL.setLineWrap(true);
	      originalL.setWrapStyleWord(true);
	      
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
	    * @param aNum
	    * This is where the converted roman numeral to arabic number is being sent to.
	    */

	   public static void printFileToGUI(String original, String aNum) {
	      originalL = new JTextArea(original);
		  JSortedRomanNumerals = new JTextArea(String.valueOf(aNum));
		  originalL.setPreferredSize(new Dimension(400, 400));
		  JSortedRomanNumerals.setPreferredSize(new Dimension(400, 400));
		  myGUI.add(originalL, BorderLayout.WEST);
		  myGUI.add(JSortedRomanNumerals, BorderLayout.EAST);
		  myGUI.setVisible(true);
	   }	
	
}
