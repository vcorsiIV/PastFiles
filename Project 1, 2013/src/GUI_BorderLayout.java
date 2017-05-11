// A program that displays a screen using BorderLayout and several
// placed buttons
// Author: Victor Corsi
// Project 1, Program C
import java.awt.*;
import javax.swing.*;

public class GUI_BorderLayout extends JFrame{
	public GUI_BorderLayout(){
		// Set up the first button set that has a set space apart from 
		// one another
		JPanel jpButtons1 = new JPanel();
		jpButtons1.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		jpButtons1.add(new JButton("Java"),BorderLayout.WEST);
		jpButtons1.add(new JButton("Programming"),BorderLayout.EAST);
		jpButtons1.setBackground(Color.red);
		
		// Set up the second button set so that it appears in the
		// NORTH location
		JPanel jpButtons2 = new JPanel();
		jpButtons2.setLayout(new BorderLayout());
		jpButtons2.add(new JButton("Is Not So " +
								   "Easy."),BorderLayout.NORTH);
		
		// Set up the last button set so that it appears in the
		// CENTER location
		JPanel jpButtons3 = new JPanel();
		jpButtons3.setLayout(new BorderLayout());
		jpButtons3.add(new JButton("Linear Data " +
								   "Structures!"),BorderLayout.CENTER);
		
		// Setup the first layout to have the button set 1
		// and place it in the layout's NORTH section
		JPanel Layout1 = new JPanel();
		Layout1.setBackground(Color.red);
		Layout1.add(jpButtons1, BorderLayout.NORTH);
		
		// Setup the first layout to have the button set 2
		// and place it in the layout's NORTH section
		JPanel Layout2 = new JPanel();
		Layout2.setBackground(Color.yellow);
		Layout2.add(jpButtons2, BorderLayout.NORTH);
		
		// Setup the first layout to have the last button set
		// and place it in the layout's CENTER section
		JPanel Layout3 = new JPanel();
		Layout3.setBackground(Color.blue);
		Layout3.add(jpButtons3, BorderLayout.CENTER);
		
		//Place the Layout in the correct location
		add(Layout1, BorderLayout.WEST);
		add(Layout2, BorderLayout.CENTER);
		add(Layout3, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		// Set the program to display a GUI of a set size and name
		// Sets what happens when the program is closed.
		GUI_BorderLayout frame = new GUI_BorderLayout();
		frame.setTitle("EECS 1570");
		frame.setSize(500,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
