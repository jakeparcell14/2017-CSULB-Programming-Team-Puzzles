import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program will take integers between 13 and 100 from the user. For each entry, the program will 
 * create a list of integers between 1 and the given integer. It will then find the lowest integer that,
 * when added to itself, will loop through the entire list of integers and reach the number 13 last. The
 * integer being added to itself will continuously wrap around the list of integers to always create a 
 * number between 1 and the given number that has not been landed on yet.
 * @author Jacob Parcell
 *
 */
public class PowerCrisis 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		ArrayList<Integer> userInput = new ArrayList<Integer>();

		// take in user input
		while(in.hasNext())
		{
			int entry = in.nextInt();

			if(entry != 0)
			{
				// add user input to list of entries
				userInput.add(entry);
			}
			else
			{
				// stop retrieving user input
				break;
			}
		}

		ArrayList<Integer> results = new ArrayList<Integer>();
		
		// iterate through all given integers
		for(int input : userInput)
		{
			int incrementer = 1;

			while(!checkNum(incrementer - 1, input))
			{
				incrementer++;
			}
			
			results.add(incrementer);
		}
		
		printResults(results);
	}

	/**
	 * Create ArrayList with a list of integers between 1 and a given number
	 * @param size	top range of integers
	 * @return 		list of integers between 1 and the given number
	 */
	public static ArrayList<Integer> getIntegerList(int size)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i = 1; i <= size; i++)
		{
			list.add(i);
		}

		return list;
	}

	public static boolean checkNum(int incrementer, int listSize)
	{
		ArrayList<Integer> numberList = getIntegerList(listSize);
				
		// remove number 1 first
		int removedNum = numberList.remove(0);
		
		int index = incrementer;

		while(numberList.size() > 1) 
		{
			removedNum = numberList.remove(index);

			if(removedNum != 13)
			{
				index = (index + incrementer) % numberList.size();
			}
			else
			{
				return false;
			}
		}

		return true;
	}
	
	public static void printResults(ArrayList<Integer> results)
	{
		for(int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i));
		}
	}

}
