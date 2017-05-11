// Prints out the value of each dice and their number using
// * as the dot on the die.
// Author:	 Victor Corsi, 09/1/2013
// Project 1, Program B
 
import java.util.*;
public class Die {
	public static void main(String[] args){
		CreatePairOfDice dice;
		Scanner in;
		int rollCount, twelveCounter;
		in 		= new Scanner(System.in);
		dice	= new CreatePairOfDice();
		
		twelveCounter = 0; 
		
		// Enter a set number of dice to roll
		System.out.println("Enter the total number of rolls: ");
		rollCount = in .nextInt();
		
		// Should the dice value be less than or equal to zero
		// The programs ends if it is an invalid number.
		if(rollCount <= 0)
			System.out.println("Invalid number of dice.");
		
		// Print the set number of dice
		for (int i=1;i<=rollCount;i++){
			// State which dice set the program runs
			System.out.print("Roll set " + i +": \n");
			// States the value of the first dice:
			System.out.printf("%1$5d", dice.roll_1());
			System.out.println(" for the first die: ");
			if (i%10 == 0)
            	System.out.print("\n");
			if (dice.lastRoll_1() == 1)
            	System.out.println("\n\n  *\n");
			if (dice.lastRoll_1() == 2)
            	System.out.println("\n   *\n\n *");
			if (dice.lastRoll_1() == 3)
            	System.out.println("\n   *\n  *\n *");
			if (dice.lastRoll_1() == 4)
            	System.out.println("\n *  *\n\n *  *");
			if (dice.lastRoll_1() == 5)
            	System.out.println("\n *  *\n  *\n *  *");
            if (dice.lastRoll_1() == 6)
            	System.out.println("\n *  *\n *  *\n *  *");
            
            // States the value of the second dice; 
            System.out.printf("%1$5d", dice.roll_2());
			System.out.println(" for the second die: ");
			if (i%10 == 0)
            	System.out.print("\n");
			if (dice.lastRoll_2() == 1)
            	System.out.println("\n\n  *\n");
			if (dice.lastRoll_2() == 2)
            	System.out.println("\n   *\n\n *");
			if (dice.lastRoll_2() == 3)
            	System.out.println("\n   *\n  *\n *");
			if (dice.lastRoll_2() == 4)
            	System.out.println("\n *  *\n\n *  *");
			if (dice.lastRoll_2() == 5)
            	System.out.println("\n *  *\n  *\n *  *");
            if (dice.lastRoll_2() == 6)
            	System.out.println("\n *  *\n *  *\n *  *");
        }       
	}
}