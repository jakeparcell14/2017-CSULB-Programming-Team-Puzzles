import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program will take in input from the user and perform a divison or modulus of given integers
 * based on the user input
 * @author Jacob Parcell
 *
 */
public class ModDivCalculator 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);		
		ArrayList<Integer> results = new ArrayList<Integer>();

		while(in.hasNextLine())
		{
			String input = in.nextLine();

			// split input into integers and operation
			String[] line = getLineInfo(input);

			if(line[1].equals("/")) 
			{
				// divide
				results.add(calculate(Integer.parseInt(line[0]), Integer.parseInt(line[2]), 0, true));
			}
			else
			{
				// modulus
				results.add(calculate(Integer.parseInt(line[0]), Integer.parseInt(line[2]), 0, false));
			}

			if(results.size() > 3)
			{
				break;
			}
		}

		// print results
		for(int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i));
		}
	}

	/**
	 * This splits a string into an array with a number, a symbol, and another number
	 * @param input		string to be split up
	 * @return			split up string
	 */
	public static String[] getLineInfo(String input)
	{
		// splits input into two numbers and an operation symbol
		return input.split(" ");
	}

	/**
	 * This will calculate the modulus or quotient of given values
	 * @param divisor		number that is dividing
	 * @param dividend		number being divided
	 * @param counter		number of times the divisor goes into the dividend
	 * @param dividing		true if dividing, false if doing modulus function
	 * @return				quotient of values if dividing is true, modulus of values if dividing is false
	 */
	public static int calculate(int divisor, int dividend, int counter, boolean dividing)
	{
		if(divisor < dividend)
		{
			if(dividing)
			{
				return counter+= 1;
			}
			else
			{
				return divisor;
			}
		}
		else
		{
			return calculate(divisor - dividend, dividend, counter, dividing);
		}
	}
}
