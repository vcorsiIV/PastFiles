import javax.swing.JFrame;

public class Main {
	static HashTable HT;
	public static void main(String[] args) throws Exception{
		// Requires to run SpellChecker before the
		// GUI to Allow the HashTable_APP class
		// to run.
		HT = new HashTable();
		SpellChecker.readInDictionary();
		SpellChecker.readOutDictionary();
		SpellChecker.readDictionary2();
		SpellChecker.readFile();
		SpellChecker.readOwnText();
		SpellChecker.countCol();
		
		HT.NumEntries();
		
		
		// The window info the GUI
		HashTable_App Window = new HashTable_App();
		Window.setTitle("Hash Table Project");
		Window.setSize(578,470);
		Window.setLocationRelativeTo(null);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setVisible(true);
		
	}
}
