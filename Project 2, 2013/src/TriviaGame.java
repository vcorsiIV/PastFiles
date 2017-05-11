// This provides the trivia game objects.
// Author: Victor Corsi
// Project 2
public class TriviaGame{
	private String QName;
	private int QNum, numTrys, remainingTrys;
	private TriviaQuestion[] questions;
	private boolean[] correct;
	
	private int numCorrect	 = 0;
	private int numIncorrect = 0;
	private int currNumQ	 = 0;

	public TriviaGame(String quizName, int NumQuestions, int numTrys){	  
		this.QName		= quizName;
		this.QNum		= NumQuestions;
		this.numTrys	= numTrys;
		remainingTrys	= numTrys;
		questions		= new TriviaQuestion[NumQuestions];
		correct			= new boolean[NumQuestions];	  
	}
	
	// Loads in the information about the quiz
	public String getQuizName(){return QName;}
	public int getNumChances(){return numTrys;}
	public int getRemainingTrys(){return remainingTrys;}
	public int getNumCorrect(){return numCorrect;}
	public int getNumIncorrect(){return numIncorrect;}
	public int getCurrNumQuestions(){return currNumQ;}
	
	// Calls the question from the file
	public TriviaQuestion getTriviaQuestion(int questionNumber){
		return questions[questionNumber - 1];  
	}
	// If the user got one wrong the program checks
	// for an incorrect answered question
	public boolean isAnswered(int questionNumber){
		return correct[questionNumber - 1];  
	}
	
	// Ends the quiz when the user uses up all their chances
	// or when all the questions are answered correctly.
	public boolean isOver(){
		return ((numCorrect == currNumQ)||(remainingTrys <= 0));  
	}
	
	// Inserts the question into an array, and keep track of when
	// the user is answering the quiz
	public void insertQuestion(TriviaQuestion question){
		questions[currNumQ] = question;
		correct[currNumQ]	= false;
		currNumQ 			= currNumQ + 1;  
	}
	// Records the correct number of questions answered.
	public void correctAnswer(int questionNumber){
		correct[questionNumber - 1] = true;
		numCorrect 					= numCorrect + 1;
		remainingTrys 				= remainingTrys - 1;
	}
	// Record the incorrect number of questions answered.
	public void incorrectAnswer(){
		numIncorrect 	= numIncorrect + 1;
		remainingTrys 	= remainingTrys - 1;	  
	} 
}