import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;


public class SkillsWindow extends JFrame{
	
	final static boolean shouldFill = true; 
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	final static int EXPMIN = 0;
	
	public SkillsWindow(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
	
	private static void createAndShowGUI(){
  	
    //Create and set up the window.
    JFrame frame = new JFrame("GridBagLayoutDemo");
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 
    //Instantiate objects
    instantiate();
       
    //Set Up objects (Add to each other, add action listeners etc etc
    setUpObjects();
        
    //Set up the content pane.
    addComponentsToPane(frame.getContentPane());
 
    //Display the window.
    frame.pack();
    frame.setVisible(true);
	  }
	
		private static void instantiate(){
			
		}
		
		private static void setUpObjects(){
			
		}
		public static void addComponentsToPane(Container pane) {
	    if (RIGHT_TO_LEFT) {
	        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	    }
	
	  pane.setLayout(new GridBagLayout());
	  GridBagConstraints c = new GridBagConstraints();
	  if (shouldFill) {
	    //natural height, maximum width
	    c.fill = GridBagConstraints.HORIZONTAL;
	  }
	  
	  if (shouldWeightX) {
	  	c.weightx = 0.5;
	  }
	  
	  /////////////PUT STUFF IN THE WINDOW HERE
	  
    c.insets = new Insets(10,0,0,0);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    c.ipady = 120;
    c.ipadx = 120;
    c.gridheight = 2;
    c.gridwidth = 1;
    pane.add(new JTextArea("Coming soon"), c);
    c.insets = new Insets(0,0,0,0);
	}
}
