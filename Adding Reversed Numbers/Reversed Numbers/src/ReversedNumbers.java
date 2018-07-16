import java.util.Scanner;

public class ReversedNumbers 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int cases = 0;
		
		//take in amount of cases
		if(in.hasNextInt())
		{
			cases = in.nextInt();
		}
		
		int sums[] = new int[cases];
		int index = 0;
		
		//perform the amount of given cases
		while(index < cases)
		{
			String entry1 = "";
			String entry2 = "";

			// take in entries from user
			if(in.hasNext())
			{
				entry1 = in.next();
				entry2 = in.next();
			}
			
			//reverse entries
			int num1 = Integer.parseInt(reverseNumber(entry1));
			int num2 = Integer.parseInt(reverseNumber(entry2));
			
			// add reversed numbers
			String sum = Integer.toString(num1 + num2);
			
			// reverse sum
			sum = reverseNumber(sum);
			
			// save sum in an array to be printed later
			sums[index] = Integer.parseInt(sum);

			index++;
		}
		
		// print results
		for(int i = 0; i < sums.length; i++)
		{
			System.out.println(sums[i]);
		}
	}
	
	/**
	 * takes a string and returns the string backwards
	 * @param num 	string to be reversed
	 * @return		given string but backwards
	 */
	public static String reverseNumber(String num)
	{
		String reversed = "";
		for(int i = num.length() - 1; i >= 0; i--) 
		{
			reversed = reversed + num.charAt(i);
		}
		
		return reversed;
	}
	

}
