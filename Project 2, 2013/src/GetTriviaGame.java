// This provides the method that obtain information from the trivia game file
// by creating and returning TriviaGame objects.  Also implements the ArrayStringLog.
// Author: Victor Corsi
// Project 2
import java.util.*;
import java.io.*;

public class GetTriviaGame{

	public static TriviaGame useTextFile(String textfile)throws 
	IOException{
    
		TriviaGame game;
		String QName, category, Q, ans, skip;
		int numQ, numTrys, numAns;
		TriviaQuestion tq;
		FileReader fin = new FileReader(textfile);
		Scanner triviaIn = new Scanner(fin);
		
		QName = triviaIn.nextLine();
		numQ = triviaIn.nextInt();
		numTrys = triviaIn.nextInt();
		skip = triviaIn.nextLine();
		
		// Reads in the Quiz name, # of questions, tries
		game = new TriviaGame(QName, numQ, numTrys);

		for (int i = 1; i <= numQ; i++){
			category = triviaIn.nextLine();
			Q = triviaIn.nextLine();
			numAns = triviaIn.nextInt();
			skip = triviaIn.nextLine();
			tq = new TriviaQuestion(category, Q, numAns);
			
			for (int j = 1; j <= numAns; j++){
				ans = triviaIn.nextLine();
				tq.storeAnswer(ans);
			}
			game.insertQuestion(tq);
		}
		return game;
	}
}