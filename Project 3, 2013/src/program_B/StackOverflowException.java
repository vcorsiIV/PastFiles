package program_B;


public class StackOverflowException extends RuntimeException
{
  public StackOverflowException()
  {
	// Default exception message
    super();
  }

  public StackOverflowException(String message)
  {
	// If prompted in the code it will allow the
	// message to be from the coder.
    super(message);
  }
}
