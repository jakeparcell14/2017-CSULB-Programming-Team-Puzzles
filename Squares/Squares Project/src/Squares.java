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
		
		int[] results = new int[userInput.size()];
		
		for(int i = 0; i < userInput.size(); i++)
		{
			results[i] = findBase(userInput.get(i));
		}
	}
	
	public static int findBase(int userInput)
	{
		
		
		
		
		
		return -1;
	}
	
	public static int findLargestNumber(int num)
	{
		String s = Integer.toString(num);
		int max = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			int possibleMax = Integer.parseInt(s.substring(i, i + 1));
			
			if(possibleMax > max)
			{
				max = possibleMax;
			}
		}
		
		return max;		
	}

}
