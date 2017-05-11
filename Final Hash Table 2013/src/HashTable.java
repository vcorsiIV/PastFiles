import java.io.File;
import java.util.Scanner;

// set parameters:

public class HashTable {
	public static String Result, Collisions;
	static int Num  = 0;
	static int size = 3000;
	static int ColCount = 0;
	static String[] HashTable;
	HashTable(){
		HashTable = new String[size]; 
	}
	// IF a new size is needed:
	HashTable(int i){
		size = i;
		HashTable = new String[size]; 
	}

	public static int ValueOfString (String s){
		// Convert the string to characters,
		// Give the characters a set value:
		// 	a=1, b=2, c=3, ... , z=26
		// for the length of string of first 4 letters
		// t*32^3 + a*32^2 + b*32^1 + l*32^0 + e*32^3
		// to do this use:
		//	for(i=0; i<string.length; i+=4)
		// Solve for value then:
		//	if i, i+1, i+2, or i+3 is empty
		//	then that char value is 0
		//	WordValue += i*32^3 + (i+1)*32^2 + (i+2)*32^1 
		//			     + (i+3)*32^0
		int WordValue = 0;

		for(int i=0; i<s.length(); i++){
			WordValue += s.charAt(i)*Math.pow(31, 3-(i%4));
		}
		return WordValue % size;
	}

	public void Insert(String S){
		// Inserts the words for the dictionary
		// into the hash table and takes into
		// account for collisions in the array
		S=S.toLowerCase();
		int loc = ValueOfString(S);
		int newLoc;

		if(HashTable[loc] == null){
			HashTable[loc] = S;
			Num++;
			return;
		}
		else{
			ColCount++;
			newLoc = (loc + 1) % size;
			while(newLoc != loc){
				if(HashTable[newLoc] == null){
					HashTable[newLoc] = S;
					Num++;
					return;
				}
				else{
					ColCount++;
					newLoc = (newLoc + 1) % size;
				}
			}
			System.out.println("array full");
		}
	}

	public boolean Contains (String S){
		// Checks to to see if the word
		// is in the array if it is then
		// it returns true,  if not it 
		// returns false

		S=S.toLowerCase();
		int loc = ValueOfString(S);
		int newLoc;

		if(HashTable[loc] == null){
			System.out.println(S+" is not in the HashTable");
			return false;
		}
		else if(HashTable[loc].equals(S)){
			System.out.println(S+" is in the HashTable");
			return true;
		}
		else{
			newLoc = (loc + 1) % size;
			while(newLoc != loc){

				if(HashTable[newLoc]==(null)){
					System.out.println(S+" is not in the HashTable");
					return false;
				}
				else if(HashTable[newLoc].equals(S)){
					System.out.println(S+" is in the HashTable");
					return true;
				}
				else{
					newLoc = (newLoc + 1) % size;
				}
			}
			System.out.println(S+" is not in the HashTable");
			return false;
		}
	}

	public static int NumEntries(){
		// Records the number of collisions
		System.out.println("The number of collisions are: " + Num);
		return Num;
	}
}