package program_B;

//Victor Corsi
//10/15/2013

//The code for Program C
//This code sets up 2 stack one for the operands and one for
//The operators.  The use has entered a string line that will
//Be evaluated as an integer or a string.  The program is designed
//To run like a calculator so it will recognize if the placement
//of the integers and operators is off.  The program is set so
//it will solve for division and multiplication first. It does
//This by monitoring the Operator stack to see if it calls for
//"*" or "/" then waits till the next integer is pushed onto 
//It's stack then solves the equation by popping the integer stack
//Twice and solving it, then pushing the result back on the
//Integer stack.  Once all the stacks have been set, the program
//Runs all the final equation types similar to "*" and "/"
//Until the final result is left which is then pushed to the
//Main program to be read.

import java.util.Scanner;

public class CalculatorEvaluator
{
	public static int evaluate(String expression){
		BoundedStackInterface<Integer> IntStack = new ArrayStack<Integer>(50); 
		BoundedStackInterface<String>	OpStack = new ArrayStack<String>(50);
		
		int value, ValueCount, result, Pcounter;
		String thisOp;
		int operand1, operand2;
		
		ValueCount	= 0;
		result		= 0;
		Pcounter	= 0;

		Scanner tokenizer = new Scanner(expression);

		while (tokenizer.hasNext()){
			if (tokenizer.hasNextInt()){
				if(Pcounter == 0){
					// Process operand.
					value = tokenizer.nextInt();
					if (IntStack.isFull())
						throw new CalculatorException("Too many operands - stack overflow");
					IntStack.push(value);
					ValueCount++;
					if(ValueCount >= 2){
						thisOp = OpStack.top();
						if(thisOp.equals("*")){
							OpStack.pop();
							// Obtain second operand from IntStack.
							if (IntStack.isEmpty())
								throw new CalculatorException("Not enough operands - IntStack underflow");
							operand2 = IntStack.top();
							IntStack.pop();

							// Obtain first operand from IntStack.
							if (IntStack.isEmpty())
								throw new CalculatorException("Not enough operands - IntStack underflow");
							operand1 = IntStack.top();
							IntStack.pop();
							
							// Perform operation.
							result = operand1 * operand2;
							IntStack.push(result);
						}
						else if(thisOp.equals("/")){
							OpStack.pop();
							// Obtain second operand from IntStack.
							if (IntStack.isEmpty())
								throw new CalculatorException("Not enough operands - IntStack underflow");
							operand2 = IntStack.top();
							IntStack.pop();

							// Obtain first operand from IntStack.
							if (IntStack.isEmpty())
								throw new CalculatorException("Not enough operands - IntStack underflow");
							operand1 = IntStack.top();
							IntStack.pop();
							
							// Perform operation.
							result = operand1 / operand2;
							IntStack.push(result);
						}
					}
					Pcounter = 1;
				}
				// Should the user enter in an equation the wrong way
				// This error exception will appear
				else
					throw new CalculatorException("operator placement is wrong");
			}
			else{
				if(Pcounter == 1){
					// Process thisOp.
					thisOp = tokenizer.next();
					OpStack.push(thisOp);
					Pcounter = 0;
				}
				// Should the user enter in an equation the wrong way
				// This error exception will appear
				else
					throw new CalculatorException("operand placement is wrong");
			}
		}
		
		while(!OpStack.isEmpty()){
			thisOp = OpStack.top();
			if(thisOp.equals("+")){
				OpStack.pop();
				// Obtain second operand from IntStack.
				if (IntStack.isEmpty())
					throw new CalculatorException("Not enough operands - IntStack underflow");
				operand2 = IntStack.top();
				IntStack.pop();

				// Obtain first operand from IntStack.
				if (IntStack.isEmpty())
					throw new CalculatorException("Not enough operands - IntStack underflow");
				operand1 = IntStack.top();
				IntStack.pop();
				
				// Perform operation.
				result = operand1 + operand2;
				// Push result of operation onto IntStack.
				IntStack.push(result);
			}
			else if(thisOp.equals("-")){
				OpStack.pop();
				// Obtain second operand from IntStack.
				if (IntStack.isEmpty())
					throw new CalculatorException("Not enough operands - IntStack underflow");
				operand2 = IntStack.top();
				IntStack.pop();

				// Obtain first operand from IntStack.
				if (IntStack.isEmpty())
					throw new CalculatorException("Not enough operands - IntStack underflow");
				operand1 = IntStack.top();
				IntStack.pop();
				
				// Perform operation.
				result = operand1 - operand2;
				// Push result of operation onto IntStack.
				IntStack.push(result);
			}
			else
				throw new CalculatorException("Illegal symbol: " + thisOp);
		}
		
		// Obtain final result from IntStack. 
		if (IntStack.isEmpty())
			throw new CalculatorException("Not enough operands - IntStack underflow");
		result = IntStack.top();
		IntStack.pop();
		
		// IntStack should now be empty.
		if (!IntStack.isEmpty())
			throw new CalculatorException("Too many operands - operands left over");
		
		// Return the final.
		return result;
	}
}