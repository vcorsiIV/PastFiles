// Class function that rolls two dice randomly and return
// the result of each roll, then record the value of that roll.
// Author:	 Victor Corsi, 09/1/2013
// Project 1, Program B

public class CreatePairOfDice {
	int die1, die2;
    int getDie1() {return die1;}
    int getDie2() {return die2;}

    // Randomly generates a number from 1 to 6
	// for the first die.
    public int roll_1() {
    	die1 = (int)(Math.random()*6) + 1;
        return die1;
    }
    
    // Randomly generates a number from 1 to 6
	// for the second die
    public int roll_2() {
        die2 = (int)(Math.random()*6) + 1;
        return die2;
    }
    
    // Returns the value of the first die
    public int lastRoll_1() {
    	return die1;
    }
    
    // Returns the value of the second die
    public int lastRoll_2() {
    	return die2;
    }
}
