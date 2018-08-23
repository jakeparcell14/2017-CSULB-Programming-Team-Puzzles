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

		ArrayList<String> results = new ArrayList<String>();

		while(in.hasNextInt())
		{
			int input = in.nextInt();

			if(input != 0)
			{
				// save result
				results.add(input + " balls cycle after " + simulateClock(input) + " days.");
			}
			else
			{
				break;
			}
		}
	}
	
	public static void printResults(ArrayList<String> results)
	{
		for(String s : results)
		{
			System.out.println(s);
		}
	}

	public static int simulateClock(int numberOfBalls)
	{
		// can hold at most 4 balls
		Stack<Integer> minutes = new Stack<Integer>();

		// can hold at most 11 balls
		Stack<Integer> fiveMinutes = new Stack<Integer>();

		// can hold at most 11 balls
		Stack<Integer> hours = new Stack<Integer>();

		// holds all balls that are not currently in a track
		Queue<Integer> waitingBalls = new LinkedList<Integer>();

		// set waiting balls in initial position
		fillInitialWaitingBalls(waitingBalls, hours, numberOfBalls);

		double halfDayCount = 0;

		do
		{
			//increment clock
			minutes.push(waitingBalls.remove());

			if(minutes.size() > 4)
			{
				tilt(minutes, fiveMinutes, waitingBalls, false);
			}

			if(fiveMinutes.size() > 11)
			{
				tilt(fiveMinutes, hours, waitingBalls, false);

			}

			if(hours.size() > 11)
			{
				tilt(hours, null, waitingBalls, true);
				halfDayCount++;
			}
		}
		while(waitingBalls.peek() != 1);

		return (int) halfDayCount / 2;
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

	public static int tilt(Stack<Integer> track, Stack<Integer> nextTrack, Queue<Integer> waiting, boolean hoursTrack)
	{
		// hold ball that caused the track to tilt
		int tilterBall = track.pop();

		// empty lower balls back into waiting queue
		while(track.size() > 1) 
		{
			waiting.add(track.pop());
		}

		if(!hoursTrack)
		{
			// empty last ball in track
			waiting.add(track.pop());

			// send tilter ball to next stack
			nextTrack.push(tilterBall);

			// do not increment half day count
			return 0;
		}
		else
		{
			// leave last ball in the hours track because it's fixed and send tilter ball to waiting queue
			waiting.add(tilterBall);

			// increment half day count
			return 1;
		}

	}
}
