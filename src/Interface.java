import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class Interface extends JFrame{
	private static JButton expB, statsB, moneyB, addInvB, removeInvB, skillsB, healthB, stats2B, equipB, moreB, battleB, diceB, charInfoB, useB, deathSaveB, deathFailB;
	private static JMenuBar menu;
	private static JMenu fileM, editM, viewM, toolsM, helpM;
	private static JMenuItem newCharMI, openCharMI, saveCharMI, exitMI, settingsMI, helpMI, aboutMI;
	private static MenuHandler mHandle;
	private static ButtonHandler bHandle;
	private static Character character;
	private static JLabel nameL, raceL, classL, expL, nameFilledL, raceFilledL, classFilled1L;
	private static JTable statsT, healthT, stats2T, moneyT, inventoryT, deathT;
	private static DefaultTableModel statsTM, healthTM, stats2TM, moneyTM, inventoryTM, deathTM;
	private static JProgressBar expPB;
	private static JScrollPane statsSP, stats2SP, moneySP, healthSP, inventorySP, deathSP;
	private static JPanel charInfoP;
	private static Vector<Item> inventory;
	
	final static boolean shouldFill = true; 
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	final static int EXPMIN = 0;
	
	public static void instantiate(){
		character = new Character();
		inventory = new Vector<Item>();
		//BUTTONS
		expB = new JButton("Add Experience");
		statsB = new JButton("Modify Base Stats");
		moneyB = new JButton("Modify Money");
		addInvB = new JButton("Add Item");
		removeInvB = new JButton("Trash Item");
		skillsB = new JButton("View Skills");
		healthB = new JButton("Modify HP");
		stats2B = new JButton("Modify Stats");
		equipB = new JButton("Equip/Unequip");
		moreB = new JButton("More Menu");
		battleB = new JButton("Battle Menu");
		diceB = new JButton("ROLL DICE!");
		charInfoB = new JButton("Character Info");
		useB = new JButton("Use Item");
		deathSaveB = new JButton("Success");
		deathFailB = new JButton("Failure");
		
		//MENU STUFF
		menu = new JMenuBar();
		fileM = new JMenu("File");
		editM = new JMenu("Edit");
		viewM = new JMenu("View");
		toolsM = new JMenu("Tools");
		helpM = new JMenu("Help");
		newCharMI = new JMenuItem("New Character");
		openCharMI = new JMenuItem("Load Character");
		saveCharMI = new JMenuItem("Save Character");
		exitMI = new JMenuItem("Exit");
		settingsMI = new JMenuItem("Settings");
		helpMI = new JMenuItem("Help");
		aboutMI = new JMenuItem("About");
		
		//HANDLERS
		bHandle = new ButtonHandler();
		mHandle = new MenuHandler();
		
		//LABELS
		nameL = new JLabel("Name: ");
		raceL = new JLabel("Race: ");
		classL = new JLabel("Class: ");
		expL = new JLabel("Exp: ");
		nameFilledL = new JLabel(character.getCharName());
		raceFilledL = new JLabel(character.getCharRace());
		classFilled1L = new JLabel(character.getCharClass());
		
		//TABLE MODELS FIRST
		statsTM = new DefaultTableModel(new Object[] {"Name", "Base", "Modifier"},6);
		healthTM = new DefaultTableModel(new Object[] {"Current HP", "Temporary HP", "Max HP"}, 1);
		stats2TM = new DefaultTableModel(new Object[] {"Name", "Base", "Modifier"}, 6);
		moneyTM = new DefaultTableModel(new Object[] {"Copper", "Silver", "Gold", "Platinum", "Electrum"}, 1);
		inventoryTM = new DefaultTableModel(new Object[] {"Item Name", "Item Type", "Equipped", "Amount"}, 0);
		deathTM = new DefaultTableModel(new Object[] {"Success", "Failure"}, 1);
		
		//TABLES WITH MODELS
		statsT = new JTable(statsTM);
		healthT = new JTable(healthTM);
		stats2T = new JTable(stats2TM);
		moneyT = new JTable(moneyTM);
		inventoryT = new JTable(inventoryTM);
		deathT = new JTable(deathTM);
		
		//PANELS
		statsSP = new JScrollPane(statsT);
		stats2SP = new JScrollPane(stats2T);
		moneySP = new JScrollPane(moneyT);
		healthSP = new JScrollPane(healthT);
		inventorySP = new JScrollPane(inventoryT);
		charInfoP = new JPanel(new GridBagLayout());
		deathSP = new JScrollPane(deathT);
		
		//OTHER
		expPB = new JProgressBar();
	}

	public static void setUpObjects(){
		//BUTTONS
		expB.addActionListener(bHandle);
		statsB.addActionListener(bHandle);
		moneyB.addActionListener(bHandle);
		addInvB.addActionListener(bHandle);
		removeInvB.addActionListener(bHandle);
		skillsB.addActionListener(bHandle);
		healthB.addActionListener(bHandle);
		stats2B.addActionListener(bHandle);
		equipB.addActionListener(bHandle);
		moreB.addActionListener(bHandle);
		battleB.addActionListener(bHandle);
		diceB.addActionListener(bHandle);
		charInfoB.addActionListener(bHandle);
		useB.addActionListener(bHandle);
		deathSaveB.addActionListener(bHandle);
		deathFailB.addActionListener(bHandle);
		
		//TABLE MODELS
		statsT.setEnabled(false);
		stats2T.setEnabled(false);
		moneyT.setEnabled(false);
		healthT.setEnabled(false);
		
		statsTM.setValueAt("STR (Strength)", 0, 0); 
		statsTM.setValueAt("WIS (Wisdom)", 1, 0); 
		statsTM.setValueAt("CHA (Charisma)", 2, 0); 
		statsTM.setValueAt("DEX (Dexterity)", 3, 0); 
		statsTM.setValueAt("INT (Intelligence)", 4, 0); 
		statsTM.setValueAt("CON (Constitution)", 5, 0); 
		statsTM.setValueAt(character.getCharStr(), 0, 1); 
		statsTM.setValueAt(character.getCharWis(), 1, 1); 
		statsTM.setValueAt(character.getCharCha(), 2, 1); 
		statsTM.setValueAt(character.getCharDex(), 3, 1); 
		statsTM.setValueAt(character.getCharInt(), 4, 1); 
		statsTM.setValueAt(character.getCharCon(), 5, 1);
		
		stats2TM.setValueAt("AC (Armor Class)", 0, 0);
		stats2TM.setValueAt("Speed (Feet)", 1, 0);
		stats2TM.setValueAt("Initiative", 2, 0);
		stats2TM.setValueAt(character.getCharAC(), 0, 1);
		stats2TM.setValueAt(character.getCharSpeed(), 1, 1);
		stats2TM.setValueAt(character.getCharInit(), 2, 1);

		moneyTM.setValueAt(character.getCharCopper(), 0, 0);
		moneyTM.setValueAt(character.getCharSilver(), 0, 1);
		moneyTM.setValueAt(character.getCharGold(), 0, 2);
		moneyTM.setValueAt(character.getCharPlatinum(), 0, 3);
		moneyTM.setValueAt(character.getCharElectrum(), 0, 4);
		
		//MENU STUFF
		newCharMI.addActionListener(mHandle);
		openCharMI.addActionListener(mHandle);
		saveCharMI.addActionListener(mHandle);
		exitMI.addActionListener(mHandle);
		settingsMI.addActionListener(mHandle);
		helpMI.addActionListener(mHandle);
		aboutMI.addActionListener(mHandle);
		menu.add(fileM);
		menu.add(editM);
		menu.add(viewM);
		menu.add(toolsM);
		menu.add(helpM);
		fileM.add(newCharMI);
		fileM.add(openCharMI);
		fileM.add(saveCharMI);
		fileM.add(exitMI);
		editM.add(settingsMI);
		helpM.add(helpMI);
		helpM.add(aboutMI);
		
		//PANELS
		TitledBorder stats2Title, healthTitle, equipmentTitle, deathTitle;
		stats2Title = BorderFactory.createTitledBorder("Stats 2");
		stats2Title.setTitleJustification(TitledBorder.RIGHT);
		healthTitle = BorderFactory.createTitledBorder("Health");
		healthTitle.setTitleJustification(TitledBorder.RIGHT);
		equipmentTitle = BorderFactory.createTitledBorder("Equipment");
		equipmentTitle.setTitleJustification(TitledBorder.RIGHT);
		deathTitle = BorderFactory.createTitledBorder("Death Saves/Fails");
		deathTitle.setTitleJustification(TitledBorder.RIGHT);
		
		statsSP.setBorder(BorderFactory.createTitledBorder("Stats"));
		stats2SP.setBorder(stats2Title);
		moneySP.setBorder(BorderFactory.createTitledBorder("Money"));
		healthSP.setBorder(healthTitle);
		inventorySP.setBorder(BorderFactory.createTitledBorder("Inventory"));
		charInfoP.setBorder(BorderFactory.createTitledBorder("Character Info"));
		deathSP.setBorder(deathTitle);
		
		
		statsSP.setPreferredSize(new Dimension(320, 140));
		healthSP.setPreferredSize(new Dimension(320,60));
		stats2SP.setPreferredSize(new Dimension(320, 140));
		moneySP.setPreferredSize(new Dimension(640,60));
		inventorySP.setPreferredSize(new Dimension(320, 140));
		charInfoP.setPreferredSize(new Dimension(320,140));
		deathSP.setPreferredSize(new Dimension(200,60));
		
		
		//OTHER
		expPB.setMinimum(EXPMIN);
		expPB.setMaximum(100);
		expPB.setValue(0);
		expPB.setStringPainted(true);
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
	    
	    //LEFT BUTTONS///////////////////////////////////////////////////////////////////////////
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    c.gridwidth = 6;
	    pane.add(menu, c);

	    c.insets = new Insets(10,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 1;
	    c.ipady = 30;
	    c.gridheight = 2;
	    c.gridwidth = 1;
	    pane.add(charInfoB, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 3;
	    c.ipady = 20;
	    c.gridheight = 1;
	    c.gridwidth = 1;
	    pane.add(skillsB, c);
	    
	    c.insets = new Insets(0,0,30,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 4;
	    c.gridheight = 1;
	    c.ipady = 10;
	    pane.add(expB, c);
	    c.insets = new Insets(0,0,0,0);

	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 5;
	    c.gridheight = 3;
	    c.ipady = 105;
	    pane.add(statsB, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 8;
	    c.gridheight = 1;
	    c.ipady = 25;
	    pane.add(moneyB, c);
	    
	    c.insets = new Insets(15,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 9;
	    c.gridheight = 2;
	    c.ipady = 60;
	    pane.add(addInvB,c);
	    c.insets = new Insets(0,0,0,0);
	    
//	    c.fill = GridBagConstraints.HORIZONTAL;
//	    c.gridx = 0;
//	    c.gridy = 10;
//	    c.ipady = 15;
//	    c.gridheight = 1;
//	    pane.add(removeInvB,c);
	    
	    c.insets = new Insets(0,0,10,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 11;
	    c.gridheight = 1;
	    c.ipady = 20;
	    pane.add(removeInvB,c);
	    c.insets = new Insets(0,0,0,0);
	    
	    //CENTER TOP INFO/////////////////////////////////////////////////////////////////////////////////
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 1;
	    c.gridheight = 1;
	    c.ipady = 15;
	    charInfoP.add(nameL, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 2;
	    c.gridheight = 1;
	    charInfoP.add(raceL, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 3;
	    c.gridheight = 1;
	    charInfoP.add(classL, c);

	    c.insets = new Insets(0,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 4;
	    c.gridheight = 1;
	    charInfoP.add(expL, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.gridy = 1;
	    c.gridheight = 1;
	    charInfoP.add(nameFilledL, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.gridy = 2;
	    c.gridheight = 1;
	    charInfoP.add(raceFilledL, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.gridy = 3;
	    c.gridheight = 1;
	    charInfoP.add(classFilled1L, c);
	    
	    c.insets = new Insets(0,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.gridy = 4;
	    c.ipady = 0;
	    c.gridheight = 1;
	    charInfoP.add(expPB, c);
	    c.insets = new Insets(0,0,0,0);

	    
	    c.insets = new Insets(0,0,20,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 1;
	    c.gridheight = 4;
	    c.gridwidth = 2;
	    c.ipady = 0;
	    pane.add(charInfoP, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    //CENTER TABLES/////////////////////////////////////////////////////////////////////////////////
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 5;
	    c.gridheight = 3;
	    c.gridwidth = 2;
	    pane.add(statsSP, c);
	    
	    c.insets = new Insets(5,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 3;
	    c.gridy = 1;
	    c.gridheight = 2;
	    c.gridwidth = 2;
	    pane.add(healthSP, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 3;
	    c.gridy = 3;
	    c.gridheight = 2;
	    c.gridwidth = 1;
	    pane.add(deathSP, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 3;
	    c.gridy = 5;
	    c.gridheight = 3;
	    c.gridwidth = 2;
	    pane.add(stats2SP, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 8;
	    c.gridheight = 1;
	    c.gridwidth = 4;
	    pane.add(moneySP, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 9;
	    c.gridheight = 3;
	    c.gridwidth = 4;
	    pane.add(inventorySP, c);
	    
	    //RIGHT BUTTONS////////////////////////////////////////////////////////////////////////////////////
	    c.insets = new Insets(10,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 1;
	    c.gridheight = 2;
	    c.gridwidth = 1;
	    c.ipady = 25;
	    pane.add(healthB, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 5;
	    c.gridheight = 3;
	    c.ipady = 105;
	    pane.add(stats2B, c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 8;
	    c.gridheight = 1;
	    c.ipady = 25;
	    pane.add(diceB, c);
	    
	    c.insets = new Insets(15,0,0,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 9;
	    c.gridheight = 2;
	    c.ipady = 60;
	    pane.add(equipB,c);
	    
	    c.insets = new Insets(0,0,10,0);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 11;
	    c.gridheight = 1;
	    c.ipady = 20;
	    pane.add(useB,c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 4;
	    c.gridy = 3;
	    c.gridheight = 2;
	    c.gridwidth = 1;
	    pane.add(deathSaveB, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 3;
	    c.gridheight = 2;
	    c.gridwidth = 1;
	    pane.add(deathFailB, c);
	    c.insets = new Insets(0,0,0,0);
	    
	    //BOTTOM SPACE////////////////////////////////////////////////////////////////////////////
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 12;
	    c.gridheight = 1;
	    c.gridwidth = 3;
	    c.ipady = 20;
	    pane.add(moreB,c);
	    
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 3;
	    c.gridy = 12;
	    c.gridheight = 1;
	    c.gridwidth = 3;
	    c.ipady = 20;
	    pane.add(battleB,c);
    }
	
  private static void createAndShowGUI() {
  	
    //Create and set up the window.
    JFrame frame = new JFrame("GridBagLayoutDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
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
	
  public static class MenuHandler implements ActionListener{
  	public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem) e.getSource();

			if(source == newCharMI)
				newCharacter();
				
			if(source == openCharMI){
				try {
					openCharacter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			if(source == saveCharMI){
				try {
					saveCharacter();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(source == exitMI)
				exitApp();
				
			if(source == settingsMI)
				settingsMenu();
				
			if(source == helpMI)
				displayHelp();
				
			if(source == aboutMI)
				displayAbout();
  	}	
		
		/*
		 * BIG BLOCK OF METHODS FOR WHAT THE MENUS DO             ///////////////////////////////////////////
		 * JUST PUTTING A BIG COMMENT HERE TO SHOW THAT IT'S HERE /////////////////////////////////////////// 
		 * DOO BA DOOOO NOTHING GOING ON HERE HOW ARE YOU?        ///////////////////////////////////////////
		 */
			
  	public void newCharacter(){
			
			Character newCharacter = new Character();
			newCharacter.setCharName(JOptionPane.showInputDialog("What is the character's name: "));
			nameFilledL.setText(newCharacter.getCharName());
			newCharacter.setCharRace(JOptionPane.showInputDialog("What is the character's race: "));
			raceFilledL.setText(newCharacter.getCharRace());
			newCharacter.setCharClass(JOptionPane.showInputDialog("What is the character's class: "));
			classFilled1L.setText(newCharacter.getCharClass());
			newCharacter.setCharStr(Integer.parseInt(JOptionPane.showInputDialog("What is the character's strength: ")));
			statsTM.setValueAt(newCharacter.getCharStr(), 0, 1);
			newCharacter.setCharDex(Integer.parseInt(JOptionPane.showInputDialog("What is the character's dexterity: ")));
			statsTM.setValueAt(newCharacter.getCharDex(), 3, 1);
			newCharacter.setCharCon(Integer.parseInt(JOptionPane.showInputDialog("What is the character's constitution: ")));
			statsTM.setValueAt(newCharacter.getCharCon(), 5, 1);
			newCharacter.setCharInt(Integer.parseInt(JOptionPane.showInputDialog("What is the character's intelligence: ")));
			statsTM.setValueAt(newCharacter.getCharInt(), 4, 1);
			newCharacter.setCharWis(Integer.parseInt(JOptionPane.showInputDialog("What is the character's wisdom: ")));
			statsTM.setValueAt(newCharacter.getCharWis(), 1, 1);
			newCharacter.setCharCha(Integer.parseInt(JOptionPane.showInputDialog("What is the character's charisma: ")));
			statsTM.setValueAt(newCharacter.getCharCha(), 2, 1);
			newCharacter.setCharAC(Integer.parseInt(JOptionPane.showInputDialog("What is the character's armor class: ")));
			stats2TM.setValueAt(newCharacter.getCharAC(), 0, 1);
			newCharacter.setCharSpeed(Integer.parseInt(JOptionPane.showInputDialog("What is the character's speed: ")));
			stats2TM.setValueAt(newCharacter.getCharSpeed(), 1, 1);
			newCharacter.setCharInit(Integer.parseInt(JOptionPane.showInputDialog("What is the character's initiative: ")));
			stats2TM.setValueAt(newCharacter.getCharInit(), 2, 1);
			newCharacter.setCharInitMod(Integer.parseInt(JOptionPane.showInputDialog("What is the character's initiative modifier: ")));
			stats2TM.setValueAt(newCharacter.getCharInitMod(), 2, 2);
			newCharacter.setCharCopper(Integer.parseInt(JOptionPane.showInputDialog("How much copper does character have: ")));
			moneyTM.setValueAt(newCharacter.getCharCopper(), 0, 0);
			newCharacter.setCharSilver(Integer.parseInt(JOptionPane.showInputDialog("How much silver does character have: ")));
			moneyTM.setValueAt(newCharacter.getCharSilver(), 0, 1);
			newCharacter.setCharGold(Integer.parseInt(JOptionPane.showInputDialog("How much gold does character have: ")));
			moneyTM.setValueAt(newCharacter.getCharGold(), 0, 2);
			newCharacter.setCharPlatinum(Integer.parseInt(JOptionPane.showInputDialog("How much platinum does character have: ")));
			moneyTM.setValueAt(newCharacter.getCharPlatinum(), 0, 3);
			newCharacter.setCharElectrum(Integer.parseInt(JOptionPane.showInputDialog("How much electrum does character have: ")));
			moneyTM.setValueAt(newCharacter.getCharElectrum(), 0, 4);
			newCharacter.setCharExp(Integer.parseInt(JOptionPane.showInputDialog("How much experience does character have: ")));
			expPB.setValue(newCharacter.getCharExp());
			newCharacter.setCharMaxHP(Integer.parseInt(JOptionPane.showInputDialog("What is character's max HP: ")));
			healthTM.setValueAt(newCharacter.getCharMaxHP(), 0, 2);
			newCharacter.setCharTempHP(Integer.parseInt(JOptionPane.showInputDialog("What is character's temporary HP: ")));
			healthTM.setValueAt(newCharacter.getCharTempHP(), 0, 1);
			newCharacter.setCharCurHP(Integer.parseInt(JOptionPane.showInputDialog("What is character's current HP: ")));
			healthTM.setValueAt(newCharacter.getCharCurHP(), 0, 0);
			character = newCharacter;
		}
			
		public void openCharacter() throws IOException{
			
			String fileName = (JOptionPane.showInputDialog("What is the character's file name: "));
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			int count = 0;
			String[] characterinformation = new String[22];
			while ((line = br.readLine()) != null) {
			   characterinformation[count] = line;
			   count = count + 1;
			}
			br.close();
		
		
		
			Character newCharacter = new Character();
			newCharacter.setCharName(characterinformation[0]);
			newCharacter.setCharRace(characterinformation[1]);
			newCharacter.setCharClass(characterinformation[2]);
			newCharacter.setCharStr(Integer.parseInt(characterinformation[3]));
			newCharacter.setCharDex(Integer.parseInt(characterinformation[4]));
			newCharacter.setCharCon(Integer.parseInt(characterinformation[5]));
			newCharacter.setCharInt(Integer.parseInt(characterinformation[6]));
			newCharacter.setCharWis(Integer.parseInt(characterinformation[7]));
			newCharacter.setCharCha(Integer.parseInt(characterinformation[8]));
			newCharacter.setCharAC(Integer.parseInt(characterinformation[9]));
			newCharacter.setCharSpeed(Integer.parseInt(characterinformation[10]));
			newCharacter.setCharInit(Integer.parseInt(characterinformation[11]));
			newCharacter.setCharInitMod(Integer.parseInt(characterinformation[12]));
			newCharacter.setCharCopper(Integer.parseInt(characterinformation[13]));
			newCharacter.setCharSilver(Integer.parseInt(characterinformation[14]));
			newCharacter.setCharGold(Integer.parseInt(characterinformation[15]));
			newCharacter.setCharPlatinum(Integer.parseInt(characterinformation[16]));
			newCharacter.setCharElectrum(Integer.parseInt(characterinformation[17]));
			newCharacter.setCharExp(Integer.parseInt(characterinformation[18]));
			newCharacter.setCharMaxHP(Integer.parseInt(characterinformation[19]));
			newCharacter.setCharTempHP(Integer.parseInt(characterinformation[20]));
			newCharacter.setCharCurHP(Integer.parseInt(characterinformation[21]));
			
			nameFilledL = new JLabel(newCharacter.getCharName());
			raceFilledL = new JLabel(newCharacter.getCharRace());
			classFilled1L = new JLabel(newCharacter.getCharClass());
			statsTM.setValueAt(newCharacter.getCharStr(), 0, 1);
			statsTM.setValueAt(newCharacter.getCharDex(), 3, 1);
			statsTM.setValueAt(newCharacter.getCharCon(), 5, 1);
			statsTM.setValueAt(newCharacter.getCharInt(), 4, 1);
			statsTM.setValueAt(newCharacter.getCharWis(), 1, 1);
			statsTM.setValueAt(newCharacter.getCharCha(), 2, 1);
			stats2TM.setValueAt(newCharacter.getCharAC(), 0, 1);
			stats2TM.setValueAt(newCharacter.getCharSpeed(), 1, 1);
			stats2TM.setValueAt(newCharacter.getCharInit(), 2, 1);
			stats2TM.setValueAt(newCharacter.getCharInitMod(), 2, 3);
			moneyTM.setValueAt(newCharacter.getCharCopper(), 0, 0);
			moneyTM.setValueAt(newCharacter.getCharSilver(), 0, 1);
			moneyTM.setValueAt(newCharacter.getCharGold(), 0, 2);
			moneyTM.setValueAt(newCharacter.getCharPlatinum(), 0, 3);
			moneyTM.setValueAt(newCharacter.getCharElectrum(), 0, 4);
			expPB.setValue(newCharacter.getCharExp());
			healthTM.setValueAt(newCharacter.getCharMaxHP(), 0, 2);
			healthTM.setValueAt(newCharacter.getCharTempHP(), 0, 1);
			healthTM.setValueAt(newCharacter.getCharCurHP(), 0, 0);
			
			character = newCharacter;
			
			}
			

			
		public void saveCharacter() throws IOException{
			PrintWriter writer = new PrintWriter(character.getCharName() + ".txt", "UTF-8");
			writer.println(character.getCharName());
			writer.println(character.getCharRace());
			writer.println(character.getCharClass());
			writer.println(character.getCharStr());
			writer.println(character.getCharDex());
			writer.println(character.getCharCon());
			writer.println(character.getCharInt());
			writer.println(character.getCharWis());
			writer.println(character.getCharCha());
			writer.println(character.getCharAC());
			writer.println(character.getCharSpeed());
			writer.println(character.getCharInit());
			writer.println(character.getCharInitMod());
			writer.println(character.getCharCopper());
			writer.println(character.getCharSilver());
			writer.println(character.getCharGold());
			writer.println(character.getCharPlatinum());
			writer.println(character.getCharElectrum());
			writer.println(character.getCharExp());
			writer.println(character.getCharMaxHP());
			writer.println(character.getCharTempHP());
			writer.println(character.getCharCurHP());
			writer.close();
				
		}
			
		public void exitApp(){
			System.exit(0);
		}
			
		public void settingsMenu(){
			JOptionPane.showMessageDialog(null, "Settings are not available at this time.");
		}
			
		public void displayHelp(){
			int helpNum;
			helpNum =(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of what you need help with: \n1.How do I create a character?\n2.  How do I modify my character's stats?\n3. How do I add or modify an item?")));
			if(helpNum == 1)
			{
				JOptionPane.showMessageDialog(null, "Click file to either create, load, or save your character.\n If creating a character input all the stats\nit asks for in the input boxes that appear.\n");
			}
			else if(helpNum == 2)
			{
				JOptionPane.showMessageDialog(null, "Select the button that lists the stat you want to edit.\nFollow the input and message box prompts to\nedit the specified stat.");
			}
			else if(helpNum == 3)
			{
				JOptionPane.showMessageDialog(null, "Click the add item button and follow the input prompts.\nTo use or equip the item select\nitem to be modified and click the buttons that\nread Equip item and use item.\nTo delete an item select item to\nbe deleted and click the trash item button.");
			}
			
		}
			
		public void displayAbout(){
			JOptionPane.showMessageDialog(null, "Role Pile\nBy Grayson Lorenz and Kristin Engberg");
		}
  }
    
    
  public static class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
				
			if(source == expB)
				addExp();
				
			if(source == addInvB)
				addItem();
				
			if(source == removeInvB)
				trashItem();
				
			if(source == equipB)
				equipItem();
				
			if(source == moneyB)
				modifyMoney();
				
			if(source == statsB)
				modifyBaseStats();
				
			if(source == stats2B)
				modifyOtherStats();
				
			
				
			if(source == diceB)
				rollDice();
				
			if(source == charInfoB)
				characterInfo();
				
			if(source == useB)
				useItem();
				
			if(source == skillsB)
				viewSkills();
				
			if(source == battleB)
				battleMenu();
				
			if(source == moreB)
				moreMenu();
			
			if(source == healthB)
				modifyHP();
			if(source == deathSaveB)
				deathSave();
			
			if(source == deathFailB)
				deathFail();
			}
			
		
			
			/*
			 * BIG BLOCK OF METHODS FOR WHAT THE BUTTONS DO           ///////////////////////////////////////////
			 * JUST PUTTING A BIG COMMENT HERE TO SHOW THAT IT'S HERE /////////////////////////////////////////// 
			 * DOO BA DOOOO NOTHING GOING ON HERE HOW ARE YOU?        ///////////////////////////////////////////
			 */
		
	    /**
	     * 
	     */
	    public void addExp(){
	    	expPB.setValue(Integer.parseInt(JOptionPane.showInputDialog("How much experience do you want to add?")) + expPB.getValue());
	    }
	    
	    /**
	     * Asks for the item name, asks for the item type, asks for how many of that item.
	     * Checks to see if that item already exists in the array, if it does, add the given number to existing amount.
	     * If it doesn't exist, it adds the item to the array.
	     * Updates the table.
	     */
	    public void addItem(){
	    	String iType;
	    	String iName;
	    	String iAmount;
	    	iName = JOptionPane.showInputDialog("What is the item called?");
	    	iType = JOptionPane.showInputDialog("What type of item is it? (Ex: Weapon, Potion, Tool, etc.");
	    	iAmount = JOptionPane.showInputDialog("How many do you have?");
	    	Item newItem;
	    	int i = 0;
	    	boolean itemFound = false;

	    	if(isInteger(iAmount)){
	    		newItem = new Item(iName, iType, Integer.parseInt(iAmount), false);
	    	}
	    	else{
	    		newItem = new Item(iName, iType, 1, false);
	    	}
	    	
		  	for(Item temp: inventory){
		  		if(temp.getItemName().compareToIgnoreCase(newItem.getItemName()) == 0 &&
		  			 temp.getItemType().compareToIgnoreCase(newItem.getItemType()) == 0){
		  			inventory.get(i).setItemAmount(inventory.get(i).getItemAmount() + newItem.getItemAmount());
		  			itemFound = true;
		  		}
		  		i++;
		  	}
	    
	    	if(!itemFound){
	    		inventory.add(newItem);
	    	}
	    	updateInventory();
	    }
	    
	    /**
	     * Checks if an row is selected.
	     * Finds the item in the row, in the actual inventory array.
	     * Removes the item from the array.
	     * Updates the table.
	     */
	    public void trashItem(){
		   	if(inventoryT.getSelectedRow() != -1){
		   		inventory.remove(inventoryT.getSelectedRow());
		   		updateInventory();
		   	}
	    }
	    
	    /**
	     * Checks if a row is selected.
	     * Checks if there is more than one of said item and removes one.
	     * If there is only one it trashes the item.
	     * Updates the table.
	     */
	    public void useItem(){
	    	if(inventoryT.getSelectedRow() != -1){
		    	if(inventory.get(inventoryT.getSelectedRow()).getItemAmount() > 1){
		    		inventory.get(inventoryT.getSelectedRow()).setItemAmount(inventory.get(inventoryT.getSelectedRow()).getItemAmount() - 1);
		    	}
		    	else{
		    		trashItem();
		    	}
		    	updateInventory();
	    	}
	    }
	    
	    /**
	     * Checks if a row is selected.
	     * Checks if item is equipped or not.
	     * Switches equipped to opposite state.
	     */
	    public void equipItem(){
	    	if(inventoryT.getSelectedRow() != -1){
	    		if(inventory.get(inventoryT.getSelectedRow()).getIsEquipped()){
	    			inventory.get(inventoryT.getSelectedRow()).setIsEquipped(false);
	    		}
	    		else{
	    			inventory.get(inventoryT.getSelectedRow()).setIsEquipped(true);
	    		}
	    		updateInventory();
	    	}
	    }
	    
	    /**
	     * 
	     */
	    public void modifyHP(){
	    	character.setCharMaxHP(Integer.parseInt(JOptionPane.showInputDialog("How much HP would you like to add or subtract(Ex. -1) to the max HP: ")) + character.getCharMaxHP());
				healthTM.setValueAt(character.getCharMaxHP(), 0, 2);
				character.setCharTempHP(Integer.parseInt(JOptionPane.showInputDialog("How much HP would you like to add or subtract(Ex. -1) to the temporary HP: ")) + character.getCharTempHP());
				healthTM.setValueAt(character.getCharTempHP(), 0, 1);
				character.setCharCurHP(Integer.parseInt(JOptionPane.showInputDialog("How much HP would you like to add or subtract(Ex. -1) to the current HP: ")) + character.getCharCurHP());
				healthTM.setValueAt(character.getCharCurHP(), 0, 0);
	    }
	    
	    /**
	     * 
	     */
	    public void modifyMoney(){
	    	character.setCharCopper(Integer.parseInt(JOptionPane.showInputDialog("How much copper do you want to add or subtract(Ex. -1): ")) + character.getCharCopper());
				moneyTM.setValueAt(character.getCharCopper(), 0, 0);
				character.setCharSilver(Integer.parseInt(JOptionPane.showInputDialog("How much silver do you want to add or subtract(Ex. -1): ")) + character.getCharSilver());
				moneyTM.setValueAt(character.getCharSilver(), 0, 1);
				character.setCharGold(Integer.parseInt(JOptionPane.showInputDialog("How much gold do you want to add or subtract(Ex. -1): ")) + character.getCharGold());
				moneyTM.setValueAt(character.getCharGold(), 0, 2);
				character.setCharPlatinum(Integer.parseInt(JOptionPane.showInputDialog("How much platinum do you want to add or subtract(Ex. -1): ")) + character.getCharPlatinum());
				moneyTM.setValueAt(character.getCharPlatinum(), 0, 3);
				character.setCharElectrum(Integer.parseInt(JOptionPane.showInputDialog("How much electrum do you want to add or subtract(Ex. -1): ")) + character.getCharElectrum());
				moneyTM.setValueAt(character.getCharElectrum(), 0, 4);
	    	
	    }
	    
	    /**
	     * 
	     */
	    public void modifyBaseStats(){
	    	character.setCharStr(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters strength: ")) + character.getCharStr());
				statsTM.setValueAt(character.getCharStr(), 0, 1);
				character.setCharDex(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters dexterity: ")) + character.getCharDex());
				statsTM.setValueAt(character.getCharDex(), 3, 1);
				character.setCharCon(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters constitution: ")) + character.getCharCon());
				statsTM.setValueAt(character.getCharCon(), 5, 1);
				character.setCharInt(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters intelligence: ")) + character.getCharInt());
				statsTM.setValueAt(character.getCharInt(), 4, 1);
				character.setCharWis(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters wisdom: ")) + character.getCharWis());
				statsTM.setValueAt(character.getCharWis(), 1, 1);
				character.setCharCha(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters charisma: ")) + character.getCharCha());
				statsTM.setValueAt(character.getCharCha(), 2, 1);	
	    }
	    
	    /**
	     * 
	     */
	    public void modifyOtherStats(){
	    	character.setCharAC(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters armor class: ")) + character.getCharAC());
	    	stats2TM.setValueAt(character.getCharAC(), 0, 1);
				character.setCharSpeed(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters speed: ")) + character.getCharSpeed());
				stats2TM.setValueAt(character.getCharSpeed(), 1, 1);
				character.setCharInit(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters initiative: ")) + character.getCharInit());
				stats2TM.setValueAt(character.getCharInit(), 2, 1);
				character.setCharInitMod(Integer.parseInt(JOptionPane.showInputDialog("How much do you want to add or substract from characters initiative modifier: ")) + character.getCharInitMod());
				stats2TM.setValueAt(character.getCharInitMod(), 2, 2);
	    }
	    
	    public void deathFail(){
	    	character.setCharDeathFail(character.getCharDeathFail() + 1);
	    	deathTM.setValueAt(character.getCharDeathFail(), 0, 1);
	    }
	    
	    public void deathSave(){
	    	character.setCharDeathSuccess(character.getCharDeathSuccess() + 1);
	    	deathTM.setValueAt(character.getCharDeathSuccess(), 0, 0);
	    }
	    
	    /**
	     * Rolls a die
	     * Will ask the user for how many sides on a die, and how much to modify the result by.
	     * It will roll, and do math, and display the result.
	     */
	    public void rollDice(){
	    	int sides = 0;
	    	int roll = 0;
	    	String temp = null;
	    	int mod = 0;
	    	int result = 0;
	    	Random rand = new Random();
	    	
	    	//get how many sides, check if int, set to either the number or 0
	    	temp = JOptionPane.showInputDialog("How many sides on the die?");
	    	if(isInteger(temp))
	    		sides = Integer.parseInt(temp);
	    	else
	    		sides = 0;
	    	
	    	//get how much to mod by, check if int, set to either the number or 0
	    	temp = JOptionPane.showInputDialog("How much is the roll modified by?");
	    	if(isInteger(temp))
	    		mod = Integer.parseInt(temp);
	    	else
	    		mod = 0;
	    	
	    	//check that there are more than 0 sides, or set roll to 0
	    	if(sides > 0)
	    		roll = rand.nextInt(sides) + 1;
	    	else
	    		roll = 0;
	    	
	    	//do some math, display the result
	    	result = roll + mod;
	    	JOptionPane.showMessageDialog(null, "Roll: " + roll + " Modifier: " + mod + " Result: " + result);
	    	
	    }
	    
	    /**
	     * Opens the Character Info Window
	     */
	    public void characterInfo(){
	    	CharacterWindow newWindow = new CharacterWindow(character);
	    }
	    
	    /**
	     * Opens a new Skills Window
	     */
	    public void viewSkills(){
	    	SkillsWindow newWindow = new SkillsWindow();
	    }
	    
	    /**
	     * Opens a new Battle Window
	     */
	    public void battleMenu(){
	    	BattleWindow newWindow = new BattleWindow();
	    }
	    
	    /**
	     * Place holder for new stuff
	     */
	    public void moreMenu(){
	    	JOptionPane.showMessageDialog(null, "This menu is empty until new tools are added.");
	    }	 
	    
	    // PRIVATE FUNCTIONS USED BY BUTTONS CAN GO RIGHT HERE THANK YOU VERY MUCH
	    /**
	     * Checks to see if the string is an integer
	     * @param s the string to check
	     * @return true if the string is an integer, false if the string isn't an integer
	     */
	    private static boolean isInteger(String s) {
	    	try { 
	    		Integer.parseInt(s); 
	      } catch(NumberFormatException e) { 
	          return false; 
	      }
	      // only got here if we didn't return false
	      return true;
	    }
	    
	    /**
	     * Clears the table given to it to populate correctly.
	     * @param thisTM the table model to clear
	     */
	    private static void clearTable(DefaultTableModel thisTM){
	    	while(thisTM.getRowCount() > 0){
	    		thisTM.removeRow(0);
	    	}
	    }
	    
	    /**
	     * Calls clearTable()
	     * then runs through the inventory array and adds each item to the empty table
	     */
	    private static void updateInventory(){
	    	clearTable(inventoryTM);
		    for(Item item: inventory){
		    	inventoryTM.addRow(new Object[] {item.getItemName(), item.getItemType(), item.getIsEquipped(), item.getItemAmount()});
		    }
	    }
	    
    }
     

  public static void main(String[] args) {
  	//Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
