import java.util.ArrayList;
import java.util.Scanner;

public class Squares 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> userInput = new ArrayList<Integer>();

		// take in user input
		while(in.hasNextInt())
		{
			int entry = in.nextInt();

			if(entry != 0)
			{
				userInput.add(entry);
			}
			else
			{
				break;
			}
		}

		System.out.println(Math.sqrt(9));

		for(int i = 0; i < userInput.size(); i++)
		{
			// find results and print them to the console
			System.out.println(findBase(userInput.get(i)));
		}
	}

	public static int findBase(int userInput)
	{
		// find the lowest possible numerical base
		int lowestPossibleBase = findLargestNumber(userInput) + 1;

		for(int i = lowestPossibleBase; i < 100; i++)
		{
			int inputNewBase = convertBase(userInput, i);

			if(isPerfectSquare(inputNewBase))
			{
				return i;
			}
		}


		return -1;
	}

	/**
	 * This will take in a number and calculate if it is a perfect square
	 * @param num	given number
	 * @return		true if number is a perfect square, false if number is not a perfect square
	 */
	public static boolean isPerfectSquare(int num)
	{
		// square root of num
		double sqrt = Math.sqrt(num);

		// square root of num with no decimal places
		int test = (int) sqrt;

		// check if squares are the same
		if(Math.pow(sqrt, 2) == Math.pow(test, 2))
		{
			// num is a perfect square
			return true;
		}

		return false;
	}

	/**
	 * This method changes a numbers numerical system
	 * @param userInput		given integer to change	
	 * @param base			new base for userInput
	 * @return				the given integer in the different numerical system
	 */
	public static int convertBase(int userInput, int base)
	{
		String num = Integer.toString(userInput);
		int result = 0;

		for(int i = 1; i <= num.length(); i++)
		{
			int multiplier = Integer.parseInt(num.substring(i - 1, i));

			result += ((int) Math.pow(base, num.length() - i)) * multiplier;
		}

		return result;
	}

	/**
	 * This program will go through each individual number of the integer and find the largest number
	 * @param num	given integer
	 * @return		largest individual number in the given integer
	 */
	public static int findLargestNumber(int num)
	{
		String s = Integer.toString(num);
		int max = 0;

		// iterate through each number in the integer
		for(int i = 0; i < s.length(); i++)
		{
			int possibleMax = Integer.parseInt(s.substring(i, i + 1));

			// compare number with max
			if(possibleMax > max)
			{
				// overwrite max
				max = possibleMax;
			}
		}

		return max;		
	}

}
