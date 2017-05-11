package program_B;

public class CalculatorException extends RuntimeException
{
  public CalculatorException()
  {
	// Default exception message.
    super();
  }

  public CalculatorException(String message)
  {
	// If prompted in the code it will allow the
	// message to be from the coder.
    super(message);
  }
}