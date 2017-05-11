import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

// Opens a new window that contains all words in the
// English dictionary.
public class Window2 extends JDialog{
	JTextArea		displayResults2 	= new JTextArea(20,30);
	JScrollPane 	resultScroll	= new JScrollPane(displayResults2);
	
	public Window2(JFrame frame){
		super(frame, "Full Dictionary", true);
		setLayout(new FlowLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,1,0,0));
		p1.add(resultScroll);
		displayResults2.setText(SpellChecker.Dictionary);
		add(p1, BorderLayout.CENTER);
	}
}
