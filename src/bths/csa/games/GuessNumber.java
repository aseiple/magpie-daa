package bths.csa.games;

import java.util.Scanner;

public class GuessNumber {
	private int Range;
	
	/**
	 * 
	 * @param Range - The range of numbers being guessed from
	 */
	public GuessNumber(int Range)
	{
		this.Range = Range;
	}
	
	//Getters and Setters
	public void setRange(int Range)
	{
		this.Range = Range;
	}
	
	public int getRange()
	{
		return Range;
	}
    
	/**
	 * Starts Guess Number
	 */
	public void play() {
    	Scanner input = new Scanner(System.in);
    	int low = 0;
    	int high = Range;
    	Boolean isNumber = false;

    	while (!isNumber) //Runs until finds the number
    	{
    		int mid = (low + high)/2; //divides the range in two
			int midVal = mid; 
			
			System.out.println("Is it " + mid + "(true/false): ");
				
			if(input.nextBoolean()) //Checks isNum
			{
				isNumber = true;
			}
			else
			{
				/*
				 * If too high:
				 * 	work with the lower range
				 * else:
				 * 	work with the upper range
				 */
				System.out.println("Too high?");
				if (input.nextBoolean())
				{
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}		
    	}
    }
}