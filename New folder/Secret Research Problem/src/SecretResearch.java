import java.util.ArrayList;
import java.util.Scanner;

public class SecretResearch 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> results = new ArrayList<String>();
		
		while(in.hasNextInt())
		{
			String answer = processDigits(in.nextInt());
			results.add(answer);
		}
		
		for(int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i));
		}

	}
	
	public static String processDigits(int digits)
	{
		String numbers = Integer.toString(digits);
		
		if(numbers.length() == 1)
		{
			if(numbers.equals("1") || numbers.equals("4"))
			{
				return "+";
			}
		}
		else if(numbers.length() == 2)
		{
			if(numbers.equals("78"))
			{
				return "+";
			}
		}
		
		return null;
	}

}
