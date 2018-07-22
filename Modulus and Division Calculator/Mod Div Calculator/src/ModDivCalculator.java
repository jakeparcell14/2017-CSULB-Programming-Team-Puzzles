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
			
			if(line[1].equals("/")) 
			{
				results.add(calculate(Integer.parseInt(line[0]), Integer.parseInt(line[2]), 0, true));
			}
			else
			{
				results.add(calculate(Integer.parseInt(line[0]), Integer.parseInt(line[2]), 0, false));
			}
			
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
	
	public static int calculate(int divisor, int dividend, int counter, boolean dividing)
	{
		if(divisor < dividend)
		{
			if(dividing)
			{
				return counter;
			}
			else
			{
				return divisor;
			}
		}
		else
		{
			calculate(divisor - dividend, dividend, counter++, dividing);
		}
		
		return 0;
	}

}
