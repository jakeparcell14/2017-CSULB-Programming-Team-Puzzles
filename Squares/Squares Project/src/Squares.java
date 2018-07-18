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
			userInput.add(in.nextInt());
		}
				
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
		
		
		
		
		
		return -1;
	}
	
	/**
	 * This program will go through each individual number of the integer and find the largest number
	 * @param num
	 * @return
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
