import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashTable_App extends JFrame implements ActionListener{
	Scanner input	= new Scanner(System.in);
	SpellChecker SC	= new SpellChecker ();
	static HashTable HT = new HashTable();
	
	public static String SelfText = "";
	
	JLabel			string			= new JLabel("Enter: ");
	JMenu 			Dictionary		= new JMenu("Full Dictionary");
	JMenuItem 		About			= new JMenuItem("Open A Full Dictionary");
	JTextField		forString		= new JTextField(50);
	JTextArea		displayResults 	= new JTextArea(5,20);
	JLabel			result			= new JLabel("Displayed Results: ");
	private JButton readHashTable	= new JButton("Check HashTable");
	private JButton readFile		= new JButton("Compare File to \nHashTable");
	private JButton readText		= new JButton("Compare Own text\n to HashTable");
	private JButton quit			= new JButton("Exit");
	JScrollPane 	resultScroll	= new JScrollPane(displayResults);
	JMenuBar		MenuBar			= new JMenuBar();
	
	public HashTable_App(){
		// display how many collisions occurred
		// right from the start.
		displayResults.setText(SC.ColCount);
		
		// Setting the arrangement of the GUI
		// with colors, border locations and
		// setting up the action listener. 
		Color water = new Color(146, 182, 204);
		Color sand  = new Color(185, 174, 119);
		Color write = new Color(215, 210, 198);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,2,0,0));
		p1.add(readHashTable);
		p1.add(readFile);
		p1.add(readText);
		p1.setBackground(water);
		add(p1, BorderLayout.WEST);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2,1,-5,0));
		p2.add(string);
		p2.add(forString);
		string.setForeground(Color.WHITE);
		forString.setBackground(write);
		p2.setBackground(water);
		add(p2, BorderLayout.CENTER);
		
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(3,1,0,0));
		p3.add(result);
		p3.add(resultScroll);
		p3.add(quit);
		result.setForeground(Color.WHITE);
		p3.setBackground(sand);
		add(p3, BorderLayout.SOUTH);
		
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(2,0,1/2,0));
		p4.add(MenuBar);
		MenuBar.add(Dictionary);
		Dictionary.add(About);
		p4.setBackground(sand);
		add(p4, BorderLayout.NORTH);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(4,3,2,5));
		p5.setBackground(water);
		add(p5, BorderLayout.EAST);
		
	
		readHashTable.addActionListener(this);
		readFile.addActionListener(this);
		readText.addActionListener(this);
		About.addActionListener(this);
		quit.addActionListener(this);
		
	}
	
	// Declares what each button will do.
	public void actionPerformed(ActionEvent event) {
		// Read in a file and check each string in the HashTable
		if (event.getSource() == readFile) {
			displayResults.removeAll();
			displayResults.setText(SpellChecker.Text);
		}
		if (event.getSource() == readText) {
			// Read in a file and then each entry 
			// will be check to see if it is in the  HashTable
			displayResults.removeAll();
			Scanner File = null;
			try {
				File = new Scanner(new File("Dictionary.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while(File.hasNextLine()){
				HT.Insert(File.nextLine());
			}
			String OwnString = forString.getText();
			StringTokenizer token = new StringTokenizer(OwnString);
			while (token.hasMoreTokens()){
				String str = token.nextToken();
				SelfText += "Hash Table contains "+ str + ": " +
						HT.Contains(str) + "\n";
			}
			displayResults.setText(SelfText);
		}
		if (event.getSource() == readHashTable) {
			// Display the Full HashTable
			displayResults.setText(SpellChecker.Hash);
		}
		if(event.getSource() == About){
			// Opens a new window for spelling
			Window2 gui = new Window2(HashTable_App.this);
			gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			gui.setSize(367,370);
			gui.setLocationRelativeTo(null);
			gui.setVisible(true);
			gui.displayResults2.setText(SpellChecker.Dictionary);
		}
		if (event.getSource() == quit) {
			// Terminates the GUI and program
			SC.quit();	
		}	
	}
}
