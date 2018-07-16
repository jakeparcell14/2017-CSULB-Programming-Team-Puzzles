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
	}

}
