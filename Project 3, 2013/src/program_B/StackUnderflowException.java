package program_B;


public class StackUnderflowException extends RuntimeException
{
  public StackUnderflowException()
  {
	// Default exception message
    super();
  }

  public StackUnderflowException(String message)
  {
	// If prompted in the code it will allow the
	// message to be from the coder.
    super(message);
  }
}