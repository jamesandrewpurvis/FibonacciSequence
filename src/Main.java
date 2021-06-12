

import java.util.Scanner;


/**
 * @author James Purvis
 * @apiNote This application solves the fibonacci sequence in both an iterative and recursive fashion.
 * @version 1.0
 * Date: 06/04/2021
 */
public class Main 
{
	
	
	/**
	 * This long contains the start time that a calcuation started.
	 */
	private static long mStartTime;
	
	
	/**
	 * This long contains the end time of a calculation.
	 */
	private static long mElapsedTime; 
	
	
	
	/**
	 * This method contains the starting point of our application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Please enter a number below: ");
		Scanner mScanner = new Scanner(System.in);
		int mUserInput = mScanner.nextInt();
		iterativeFibonacci(mUserInput);
		System.out.println("The recursive nthTerm is: " + recursiveFibonacci(mUserInput));
		mElapsedTime = ElapsedTime(mStartTime, System.nanoTime());
		System.out.println("The recursive fibonacci function took: " + mElapsedTime + " anoseconds!");
	}
	
	
	/**
	 * This function solves the fibonacci sequence in a iterative fashion. It takes in a term, and then solves the sequence for that term.
	 * @param nthTerm
	 */
	public static void iterativeFibonacci(int nthTerm)
	{
		//set the start time of nanoseconds.
		mStartTime = System.nanoTime();
		
		//declare our needed variables, a counter to iterate, our first term, our second term, and our sum.
		int mCounter = 0;
		int mFirstTerm = 0;
		int mSecondTerm = 1;
		int mSumTerm = 0;
		
		System.out.print("Iterative Sequence: " );
		//while our counter is less than our nthTerm, we can print our sequence.
		while(mCounter <= nthTerm)
		{
			//print our first term and a space.
			System.out.print(mFirstTerm + " " );
			
			//calc our third number, our sum term. (Sum of first and second)
			mSumTerm = (mFirstTerm + mSecondTerm);
			
			//we have our sum, let's swap first for second term.
			mFirstTerm = mSecondTerm;
			
			//swap second for our sum term, so we can continue calculating our sequence.
			mSecondTerm = mSumTerm; 
			
			//increase the counter
			mCounter++;
		}
		
		//the test is done, let's calculate the elapsed time and then print it for the end user.
		mElapsedTime = ElapsedTime(mStartTime, System.nanoTime());
		System.out.println("\nThe iterativeFibonacci function took: " + mElapsedTime + " nanoseconds!");
	}
	
	
	/**
	 * This function returns an int. It solves the fibonacci term for the specified term.
	 * @param nthTerm
	 * @return int
	 */
	public static int recursiveFibonacci(int nthTerm)
	{
		//set our start time.
		mStartTime = System.nanoTime();
		
		//if nthTerm is less than or equal to 1
		if (nthTerm <= 1)
		{
			//return our nthterm
			return nthTerm;
		}
		
		//else
		else
		{
			//our sum term is the number returned of this function that passes nthTerm - 1, plus the number returned of this function that passes nthTerm - 2
		   int mSumTerm = recursiveFibonacci(nthTerm - 1) + recursiveFibonacci(nthTerm - 2);
		  
		   //return the sum term
		   return mSumTerm;
		   
		}
		
	}
	
	
	/**
	 * This function returns a long that provides the time elapsed from start to finish.
	 * @param starttime
	 * @param endttime
	 * @return long
	 */
	public static long ElapsedTime(long starttime, long endttime)
	{
		return (endttime - starttime);
	}

}
