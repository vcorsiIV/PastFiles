package program_B;

// Victor Corsi
// 10/15/2013

// The Main code for Program C
// The code sets up 2 stack one for the operands and one for
// The operators.  The use enters a string line that will be
// evaluated by another program.  Once that program is done
// The result will be sent back here the main program, which
// will either state the result or state that an error has
// Occurred.  The user will then be prompted to enter another
// Expression to be calculated.

import java.util.Scanner;

public class Calculator 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    String line = null;          // string to be evaluated
    String more = null;          // used to stop or continue processing
    int result;                  // result of evaluation

    do
    {
      // Get next expression to be processed.
      System.out.println("Enter a infix expression to be evaluated: ");
      line = conIn.nextLine();
      
      // Obtain and output result of expression evaluation.
      try
      {
        result = CalculatorEvaluator.evaluate(line);

        // Output result.
        System.out.println();
        System.out.println("Result of " + line +" = " + result);
      }
      catch (CalculatorException error)
      {        
        // Output error message.
        System.out.println();
        System.out.println("Error in expression - " + error.getMessage());
      }

      // Determine if there is another expression to process.
      System.out.println();
      System.out.print("Evaluate another expression? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }
}