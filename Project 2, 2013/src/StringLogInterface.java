// This is an interface for a class that implements a log of strings
// in the ArrayStringLog class.
// Author: Victor Corsi
// Project 2
public interface StringLogInterface{
	void insert(String element);
	void clear();
	boolean isFull();
	boolean contains(String element);
	int size();
	String getText();
	String toString();
}
