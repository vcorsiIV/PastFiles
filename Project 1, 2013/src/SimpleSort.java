// A program that read the name of a file
// stores the integers into a 100 element array
// sort the file by Insertion Sort and
// Print out the number of comparisons made
// Author: Victor Corsi
// Project 1, Program D

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleSort extends File{
	// Set up the 100 element array
	int[] sortvalues = new int[100];
	int comparison;
	
	public SimpleSort(String pathname) {
		// Load the integers into the array
		super(pathname);
		try{
			Scanner in = new Scanner(this);
			for (int i=0;i<50;i++)
				sortvalues[i]= in.nextInt();
		}
		
		catch (FileNotFoundException e) {
			// Should the user enter a file name that is
			// not one of the three it will give this error message.
			System.out.println("error: " + e.getMessage());
		}
	}
	
	void sort(){
		// Set the comparisons to 0.
		comparison = 0;
		for (int i=1;i<50;i++){
			int a =sortvalues[i];
			int j = i;
			
			// Checks to see if the value needs to be rearranged
			// and if it does count the number of times 
			// it compares other numbers.
			while (j>0 && a<sortvalues[j-1]){
				comparison++;
				sortvalues[j]=sortvalues[j-1];
				j--;
			}
			// If the value is in the correct location 
			// then have it compare only one time
			sortvalues[j] = a;
			comparison ++;
		}
	}
	
	// State how many comparisons are made
	void printvalues(){
		System.out.println("The number of comparisons is: "
						   + comparison);
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		// Strings that will call the file
		String File1 = "1-50";
		String File2 = "50-1";
		String File3 = "Random";
		
		// Prompt the user to enter one of the three files available.
		System.out.println("Enter file name, 1-50, 50-1 or Random to" +
						   " sort.");
		String title = input.next();
		
		// If the file is a match then load the file
		// The sort and count the number of times it is compared
		// Then print the number of comparisons made when sorting
		
		if (title.equals(File1)){
			SimpleSort sortingfile;
			sortingfile = new SimpleSort("1-50.txt");
			sortingfile.sort();
			sortingfile.printvalues();
		}		
		
		else if (title.equals(File2)){
			SimpleSort sortingfile;
			sortingfile = new SimpleSort("50-1.txt");
			sortingfile.sort();
			sortingfile.printvalues();
		}
		
		else if (title.equals(File3)){
			SimpleSort sortingfile;
			sortingfile = new SimpleSort("Random.txt");
			sortingfile.sort();
			sortingfile.printvalues();
		}
		
		else
			// If the string does not match the file
			// this message will appear
			System.out.print("There is no files with name " + title);
	}
}