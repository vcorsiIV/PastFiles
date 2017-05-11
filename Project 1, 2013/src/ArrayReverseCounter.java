// A program that reads a series of positive integers
// terminated by a negative integer and prints the
// integers in reverse order of entry.
// Author: Victor Corsi
// Project 1, Program A
import java.util.Scanner;

public class ArrayReverseCounter {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Enter the array values
		int[] array = new int [200];
		// the int count will be used to count the number of arrays
		int count = 0;
		// Prompt the user to enter positive values into the array
		System.out.println("Enter positive values into an array: ");
		for(int i=0; i<array.length; i++){
			array[i] = input.nextInt();
			
			// If the integer is a negative value the system will
			// print the array in reverse order they were entered.
			if(array[i]<0){
				for(int j=0; j<count; j++){
					System.out.print(array[(i-1)-j] + " ");
				}
				// Ends the program
				System.exit(0);
			}
			else{
				// Counts the array
				count++;
			}
		}
	}
}
