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
		// add fixed hours ball
		hours.push(0);
		
		
	}

	public static void tilt(Stack<Integer> track, Stack<Integer> nextTrack, Queue<Integer> waiting, boolean hoursTrack)
	{
		// hold ball that caused the track to tilt
		int tilterBall = track.pop();
		
		// empty lower balls back into waiting queue
		while(track.size() >= 0) 
		{
			waiting.add(track.pop());
		}

		if(!hoursTrack)
		{
			// send final ball to next stack
			nextTrack.push(tilterBall);
		}
		else
		{
			// send final ball to waiting queue
			waiting.add(tilterBall);
		}

	}
}
