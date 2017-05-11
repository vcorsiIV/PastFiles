package program_B;
import java.io.*;
import java.util.*;

// Victor Corsi
// 10/15/2013

// The Main code for Program B
// The code sets up a stack that will recognize strings
// Then the user will be able to push as many string on
// The stack, up to 100 since the stack is set to a maximum
// Of 100.  When the user is done pushing strings on the stack 
// The user will then push the string "DONE" the previous string
// On the stack will be the top of the stack.  The program then
// Pops the top of the stack and displays the stings in reversed
// Order, excluding the "DONE" string.  Should the user overflow
// Or underflow the stack an exception should be called.

public class ReverseString {
	public static void main(String[] args){
		Scanner conIn = new Scanner(System.in);
		
		ArrayStack<String> stack;
		stack = new ArrayStack<String>(100);
		
		String word;
		System.out.print("You will enter words into a stack that "
				+ "has a cap value of 100.");
		System.out.println("\nTo end the program enter the"
				+ " word DONE.\n");
		for (int i = 1; i<=100; i++){
			System.out.print("Enter a word: ");
			word = conIn.nextLine();
			if(!word.equals("DONE"))
				stack.push(word);
			else{
				System.out.println("The words in reverse are:\n");
				while(!stack.isEmpty()){
					word = stack.top();
					stack.pop();
					System.out.println(word);
				}
				System.exit(0);
			}	
		}
		System.out.println("The words in reverse are:\n");
		while(!stack.isEmpty()){
			word = stack.top();
			stack.pop();
			System.out.println(word);
		}
	}
}