package project1;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.JFrame;
   
   

public class RomanANumeralGUI extends JFrame{

   public static JFrame myFrame;
   public static TextArea JStringTextFile;
   public static TextArea JInteger;
   // The initialization process of getting everything to work for the JFrame and how we'd want it to look
   public static void initialization() {
      myFrame = new JFrame();
      myFrame.setVisible(true);
      myFrame.setSize(600,600);
      myFrame.setLocation(200,200);
      myFrame.setTitle("Project 1 ");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setLayout(new GridLayout(1,2));
   }

   public static void textArea(String textInput, String romanN) {
      // These are basically the results we've determined in the main function in the Project1.java into a text area. 
      JStringTextFile = new TextArea(textInput);
      JInteger = new TextArea(romanN);
      // This is setting the properties of how the text area should look.
      JStringTextFile.setPreferredSize(new Dimension(400,400));
      JInteger.setPreferredSize(new Dimension(400,400));
      // This is where the text area will go with the text string going on the left and the vowel counter going to the right. 
      myFrame.add(JStringTextFile, BorderLayout.WEST);
      myFrame.add(JInteger, BorderLayout.EAST);
   }
}