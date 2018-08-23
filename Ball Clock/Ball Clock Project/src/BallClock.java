import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BallClock 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		ArrayList<Integer> results = new ArrayList<Integer>();

		while(in.hasNextInt())
		{
			int input = in.nextInt();

			if(input != 0)
			{
				//solve
				int result = simulateClock(input);

				// print result
				System.out.println(input + " balls cycle after " + result + " days.");
			}
			else
			{
				break;
			}
		}
	}

	public static int simulateClock(int numberOfBalls)// TODO do i need the number of balls in this method?
	{
		Queue<Integer> waitingBalls = new LinkedList<Integer>();

		// can hold at most 4 balls
		Stack<Integer> minutes = new Stack<Integer>();

		// can hold at most 11 balls
		Stack<Integer> fiveMinutes = new Stack<Integer>();

		// can hold at most 11 balls
		Stack<Integer> hours = new Stack<Integer>();

		return 0;
	}

	public static void fillInitialWaitingBalls(Queue<Integer> waitingBalls, Stack<Integer> hours, int numberOfBalls)
	{
		// add fixed ball in hours track
		hours.push(0);
		
		for(int i = 1; i <= numberOfBalls; i++)
		{
			waitingBalls.add(i);
		}
		
		
	}

	public static void tilt(Stack<Integer> track, Stack<Integer> nextTrack, Queue<Integer> waiting, boolean hoursTrack)
	{
		// hold ball that caused the track to tilt
		int tilterBall = track.pop();
		
		// empty lower balls back into waiting queue
		while(track.size() >= 1) 
		{
			waiting.add(track.pop());
		}

		if(!hoursTrack)
		{
			// empty last ball in track
			waiting.add(track.pop());
			
			// send tilter ball to next stack
			nextTrack.push(tilterBall);
		}
		else
		{
			// leave last ball in the hours track because it's fixed and send tilter ball to waiting queue
			waiting.add(tilterBall);
		}

	}
}
