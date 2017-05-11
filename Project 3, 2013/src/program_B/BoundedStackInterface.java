package program_B;


public interface BoundedStackInterface<T> {
	void push(T element); // Places element at the top of this stack.
	void pop(); // Removes top element from this stack.
	T top(); // Returns top element from this stack.
	
	boolean isEmpty(); // true if this stack is empty, otherwise false.
	boolean isFull(); // true if this stack is full, otherwise false.
}
