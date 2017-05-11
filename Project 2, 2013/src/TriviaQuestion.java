// This provides the trivia question objects.
// Author: Victor Corsi
// Project 2
public class TriviaQuestion{
	private String category;
	private String question;
	private StringLogInterface answers;
	
	public TriviaQuestion(String category, String question,
						  int NumAnswers){
		this.category = category;
		this.question = question;
		answers 	  = new ArrayStringLog("trivia", NumAnswers);
	}
	// Sorts the file into category, question,
	// number of answers, and the answers.
	public String getCategory(){return category;}
	public String getQuestion(){return question;}
	public boolean tryAnswer(String answer){return answers.contains(answer);}	 
	public void storeAnswer(String answer){answers.insert(answer);}
}