// This program allow the user to play the trivia
// game using a console interface
// Author: Victor Corsi
// Project 2
import java.io.*;
import java.util.Scanner;

public class TriviaConsole{
	public static void main(String[] args) throws 
	IOException{
		Scanner in = new Scanner(System.in);
		int questNum;
		String answer;
		TriviaGame game;
		TriviaQuestion q;
		// Calls the up the "Trivia Game" file
		game = GetTriviaGame.useTextFile("Trivia_Quiz.txt");
		
		// Informs the user how many tries they have to 
		// answer the questions
		System.out.println("Welcome to the "+ game.getQuizName()
							+ " trivia quiz.");
		System.out.println("You will have " + game.getNumChances()+
							" chances to answer "+ 
							game.getCurrNumQuestions()+" questions.\n");
		questNum = 0;
		
		// Loops through until the game is complete
		while (!game.isOver()){
			do
				if (questNum == game.getCurrNumQuestions())
					questNum = 1;
				else
					questNum++;
			while (game.isAnswered(questNum));
			
			// Calls the question from the file
			q = game.getTriviaQuestion(questNum);
			System.out.println(q.getCategory() + ": " + q.getQuestion());
			answer = in.nextLine();
			
			// Tells the user if a question was answered correctly or not
			if(q.tryAnswer(answer)){
				System.out.println("Correct!\n");
				game.correctAnswer(questNum);	
			}
			else{
				System.out.println("Incorrect\n");
				game.incorrectAnswer();
			}	
		}
		// Prints the results.
		System.out.println("\nGame Over");
		System.out.println("\nResults:");
		System.out.print("   Chances used: " + (game.getNumChances()
							- game.getRemainingTrys()));
		System.out.println("   Number Correct: " + game.getNumCorrect());
		System.out.println("\nThank you.\n");
	}
}