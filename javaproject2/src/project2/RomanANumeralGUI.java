package project2;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
   
   

public class RomanANumeralGUI extends JFrame{

   public static JFrame myFrame;
   public static TextArea JStringTextFile, JSortedRomanNumerals, JUnsortedRomanNumerals;
   public static TextArea JInteger;
   /**
    * Basic initialization as previously of the GUI.
    */
   public static void initialization() {
      myFrame = new JFrame();
      myFrame.setVisible(true);
      myFrame.setSize(600,600);
      myFrame.setLocation(200,200);
      myFrame.setTitle("Project 2 ");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setLayout(new GridLayout(1,3));
   }

   /**
    * 
    * Takes the results of all the things that we have done and put them into the GUI to be displayed.
    * BUT THERE IS AN ERROR!
    * The list is sorted but it's displaying it from highest to lowest.
    * 
    * 
    * @param textInput
    * @param unsortedRomanNumerals
    * @param sortedRomanNumerals
    */
   public static void textArea(String textInput, UnsortedRomanNumeralList unsortedRomanNumerals, SortedRomanNumeralList sortedRomanNumerals) {
      // These are basically the results we've determined in the main function in the Project1.java into a text area. 
      JStringTextFile = new TextArea(textInput);
      JSortedRomanNumerals = new TextArea(sortedRomanNumerals.toString());
      JUnsortedRomanNumerals = new TextArea(unsortedRomanNumerals.toString());
      JStringTextFile.setPreferredSize(new Dimension(400,400));
      JSortedRomanNumerals.setPreferredSize(new Dimension(400, 400));
      JUnsortedRomanNumerals.setPreferredSize(new Dimension(400,400)); 
      myFrame.add(JStringTextFile, BorderLayout.WEST);
      myFrame.add(JUnsortedRomanNumerals, BorderLayout.CENTER);
      myFrame.add(JSortedRomanNumerals, BorderLayout.EAST);
   }
}