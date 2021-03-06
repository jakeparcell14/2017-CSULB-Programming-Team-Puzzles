import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program will take in a user specified amount of numbers. It will then analyze each number for
 * specific cases and return a certain symbol based on the case.
 * @author Jacob Parcell
 *
 */
public class SecretResearch 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		ArrayList<String> results = new ArrayList<String>();
		
		int count = in.nextInt();
		
		while(results.size() < count)
		{
			String answer = processDigits(in.nextLine());
			
			// store results
			results.add(answer);
		}

		// print results on separate lines
		for(int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i));
		}

	}

	/**
	 * This will process given digits and return a corresponding symbol if it fits certain cases
	 * @param digits	number to be analyzed
	 * @return			symbol based on what case the digits satisfy
	 */
	public static String processDigits(String digits)
	{
		int length = digits.length();

		if(digits.equals("1") || digits.equals("4") || digits.equals("78"))
		{
			// positive case
			return "+";
		}
		else if(digits.substring(length - 2, length).equals("35"))
		{
			// negative case
			return "-";
		}
		else if(digits.substring(0, 1).equals("9") && digits.substring(length - 1, length).equals("4"))
		{
			// experiment failed
			return "*";
		}
		else if(digits.substring(0, 3).equals("190"))
		{
			// experiment not completed
			return "?";
		}

		return null;
	}

}
