import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

// This class Uses the HashTable class to
// give the results that will be used on
// the GUI

public class SpellChecker{
	static HashTable HT = new HashTable();
	
	public static String OwnString;
	public static String Text = "";
	public static String OwnText = "";
	public static String Hash = "";
	public static String Dictionary = "";
	public static String ColCount = "";
	public static String SelfText = "";
	
	public static void countCol(){
		ColCount = "The number of collisions are: " + HT.Num;
	}
	
	public static void readInDictionary() throws Exception{
		Scanner File = new Scanner(new File("Dictionary.txt"));
		while(File.hasNextLine()){
			HT.Insert(File.nextLine());
		}
	}
	
	public static void readOutDictionary() throws Exception{
		Scanner File = new Scanner(new File("Dictionary.txt"));
		while(File.hasNextLine()){
			String words = File.nextLine();
			Hash += "Hash Table contains "+ words + ": " +
					HT.Contains(words) + "\n";
		}
	}
	
	public static void readDictionary2() throws Exception{
		File f = new File("Dictionary2.txt");
		Scanner fileIn = new Scanner(f);
		while(fileIn.hasNextLine()){
			String spell = fileIn.nextLine();
			Dictionary += spell +"\n";
		}
	}

	public static void readFile() throws Exception{
		File f = new File("Document.txt");
		Scanner fileIn = new Scanner(f);
		while (fileIn.hasNext()){
			String word = fileIn.next();
			Text += "Hash Table contains "+ word + ": " +
					HT.Contains(word) + "\n";
		}
	}
	
	public static void readOwnText() throws Exception{
		Scanner input = new Scanner(System.in);
		String OwnString = input.nextLine();
		StringTokenizer token = new StringTokenizer(OwnString);
		while (token.hasMoreTokens()){
			String str = token.nextToken();
			SelfText += "Hash Table contains "+ str + ": " +
					HT.Contains(str) + "\n";
		}
	}
	
	
	
	public static void quit(){
	    System.exit(0);
	}

}
