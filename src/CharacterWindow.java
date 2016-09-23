import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CharacterWindow extends JFrame{
	
	final static boolean shouldFill = true; 
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	final static int EXPMIN = 0;
	
	private static JButton nameB, classB, raceB, saveB;
	private static JLabel nameL, classL, raceL, biographyL, nameFilledL, classFilledL, raceFilledL;
	private static JTextArea biographyTA;
	private static ButtonHandler bHandle;
	private static Character character;
	
	public CharacterWindow(Character c){
		character = c;
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
			bHandle = new ButtonHandler();
			nameB = new JButton("Edit Name");
			classB = new JButton("Edit Class");
			raceB = new JButton("Edit Race");
			saveB = new JButton("Save Character");
			
			nameL = new JLabel("Name: ");
			classL = new JLabel("Class: ");
			raceL = new JLabel("Race: ");
			biographyL = new JLabel("Biography: ");
			nameFilledL = new JLabel("[NAME]");
			classFilledL = new JLabel("[CLASS]");
			raceFilledL = new JLabel("[RACE]");
			
			biographyTA = new JTextArea();
	}
		
	private static void setUpObjects(){
			nameB.addActionListener(bHandle);
			classB.addActionListener(bHandle);
			raceB.addActionListener(bHandle);
			saveB.addActionListener(bHandle);
			
			if(character != null){
				nameFilledL.setText(character.getCharName());
				classFilledL.setText(character.getCharClass());
				raceFilledL.setText(character.getCharRace());
			}
			else{
				character = new Character();
			}
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
	  
	  ////////////////////////////////////////////////Left Column////////////////////////////////////////////////
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 30;
    c.ipadx = 80;
    c.gridheight = 1;
    c.gridwidth = 1;
    
    c.gridx = 0;
    c.gridy = 1;
    pane.add(nameB, c);

    c.gridx = 0;
    c.gridy = 2;
    pane.add(raceB, c);

    c.gridx = 0;
    c.gridy = 3;
    pane.add(classB, c);

    c.gridx = 0;
    c.gridy = 4;
    c.gridwidth = 3;
    pane.add(saveB, c);
    c.gridwidth = 1;
    
////////////////////////////////////////////////Center Column////////////////////////////////////////////////
    c.gridx = 1;
    c.gridy = 1;
    pane.add(nameL, c);

    c.gridx = 1;
    c.gridy = 2;
    pane.add(raceL, c);
    
    c.gridx = 1;
    c.gridy = 3;
    pane.add(classL, c);
    
////////////////////////////////////////////////Right Column////////////////////////////////////////////////
    c.gridx = 2;
    c.gridy = 1;
    pane.add(nameFilledL, c);

    c.gridx = 2;
    c.gridy = 2;
    pane.add(raceFilledL, c);

    c.gridx = 2;
    c.gridy = 3;
    pane.add(classFilledL, c);
	}	
	
	public static class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			if(source == nameB){
				character.setCharName(JOptionPane.showInputDialog("What is the character's name?"));
				nameFilledL.setText(character.getCharName());
			}
			
			if(source == raceB){
				character.setCharName(JOptionPane.showInputDialog("What is the character's race?"));
				raceFilledL.setText(character.getCharName());
			}
			
			if(source == classB){
				character.setCharName(JOptionPane.showInputDialog("What is the character's class?"));
				classFilledL.setText(character.getCharName());
			}
			
			if(source == saveB){
				//find a way to send this information back up the jacobs ladder
			}
		}
	}
	
}
