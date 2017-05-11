package Program_C;


public class ArrayStack<T> implements BoundedStackInterface<T>{
	protected final int DEFCAP = 100;
	protected T[] stack;
	protected int topIndex = -1;
	
	public ArrayStack(){
		stack = (T[]) new Object[DEFCAP];
	}
	public ArrayStack(int maxSize){
		stack = (T[]) new Object[maxSize];
	}

	public void push(T element){
		if (!isFull()){
			topIndex++;
			stack[topIndex] = element;
		}
		else
			throw new StackOverflowException("Push attempted on a full stack.");
	}
  
	public void pop(){
		if (!isEmpty()){
			stack[topIndex] = null;
			topIndex--;
		}
		else
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}
  
	public T top(){
		T topOfStack = null;
	  
		if (!isEmpty())
			topOfStack = stack[topIndex];
		return topOfStack;
	}
  
	public boolean isEmpty(){
		if (topIndex == -1) 
			return true;
		else
			return false;
	}

	public boolean isFull(){              
		if (topIndex == (stack.length - 1)) 
			return true;
		else
			return false;
	}
}