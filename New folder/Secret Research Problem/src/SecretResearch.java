import java.util.ArrayList;
import java.util.Scanner;

public class SecretResearch 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		ArrayList<String> results = new ArrayList<String>();
		
		int count = in.nextInt();
		
		while(results.size() < count)
		{
			String answer = processDigits(in.nextInt());
			
			// store results
			results.add(answer);
		}

		// print results on separate lines
		for(int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i));
		}

	}

	public static String processDigits(int digits)
	{
		String numbers = Integer.toString(digits);
		int length = numbers.length();

		if(numbers.equals("1") || numbers.equals("4") || numbers.equals("78"))
		{
			// positive case
			return "+";
		}
		else if(numbers.substring(length - 2, length).equals("35"))
		{
			// negative case
			return "-";
		}
		else if(numbers.substring(0, 1).equals("9") && numbers.substring(length - 1, length).equals("4"))
		{
			// experiment failed
			return "*";
		}
		else if(numbers.substring(0, 3).equals("190"))
		{
			// experiment not completed
			return "?";
		}

		return null;
	}

}
