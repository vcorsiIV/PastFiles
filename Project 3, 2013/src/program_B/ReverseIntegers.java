package program_B;

//Victor Corsi
//10/15/2013

// The Main code for Program A
// The code sets up a stack that will recognize integers
// Then the user inputs how many integers the stack can hold
// The stack at most can hold 100 integers.  Once the user
// Has decided on how many integers the user will enter 
// The user will then push that number of integers into the
// Stack.  Once the stack has been filled the program will then
// Pop the top of the stack and display the integers that were
// pushed in reversed order. 

import java.io.*;
import java.util.*;

public class ReverseIntegers {
	ArrayStack<Integer> stack;
	String str;
	int num, n;
	
	public static void main(String[] args){
		ReverseIntegers q = new ReverseIntegers();
	}
	
	public ReverseIntegers(){
		try{
			stack = new ArrayStack<Integer>();
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(isr);
			System.out.print("Enter the number of integers to be entered: ");
			str = bf.readLine();
			num = Integer.parseInt(str);
			while(num > 100){
				System.out.println("Enter a number smaller than 100: ");
				str = bf.readLine();
				num = Integer.parseInt(str);
			}
			int numleft = num;
			for(int i =1; i <= num; i++){
				if(numleft > 1)
					System.out.println("Enter "+ numleft +" integers: ");
				else
					System.out.println("Enter the last integer: ");
				str = bf.readLine();
				n = Integer.parseInt(str);
				stack.push(n);
				numleft= numleft - 1;
			}
		}
		catch(IOException e){}
		System.out.println("Integers from the stack in reverse: ");
		while(!stack.isEmpty()){
			n = stack.top();
			stack.pop();
			System.out.println(n);
		}
	}
}

