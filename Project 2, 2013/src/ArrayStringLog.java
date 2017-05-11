// Implements the the StringLog Interface using
// an array to hold the log of strings.
// Author: Victor Corsi
// Project 2
public class ArrayStringLog implements StringLogInterface{
	
	protected String text;
	protected String[] log;
	protected int lastIndex;

	public ArrayStringLog(String text, int maxSize){
		lastIndex = -1;
		log = new String[maxSize];
		this.text = text;	
	}
	public ArrayStringLog(String text){
		log = new String[100];
		this.text = text;
	}
	public void insert(String element){
		lastIndex++;
		log[lastIndex] = element;
	}
	public boolean isFull(){
		if (lastIndex == (log.length - 1))
			return true;
		else
			return false;
	}
	public int size(){return (lastIndex + 1);}
	public boolean contains(String element){ 
		int location = 0;
		while (location <= lastIndex){
			if (element.equalsIgnoreCase(log[location]))
				return true;
			else
				location++;
		}
		return false;
	}
	public void clear(){ 
		for (int i = 0; i <= lastIndex; i++)
			log[i] = null;
		lastIndex = -1;
	}
	public String getText(){return text;}
	public String toString(){
		String logString = "Log: " + text + "\n\n";
		for (int i = 0; i <= lastIndex; i++)
			logString = logString + (i+1) + ". " + log[i] + "\n";
		return logString;  
	}
}