import java.util.ArrayList;
import java.util.Scanner;

public class ModDivCalculator {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		while(in.hasNextLine())
		{
			String input = in.nextLine();
			
			String[] line = getLineInfo(input);
			
			if(results.size() > 3)
			{
				break;
			}
		}
		
	}
	
	public static String[] getLineInfo(String input)
	{
		return input.split(" ");
	}
	
	public static int divide(int divisor, int dividend, int counter)
	{
		if(divisor < dividend)
		{
			return counter;
		}
		else
		{
			divide(divisor - dividend, dividend, counter++);
		}
		
		return 0;
	}

}
