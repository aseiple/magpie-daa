package bths.csa.games;

import java.util.Scanner;

public class GuessNumber {
	private int Range;
	
	public GuessNumber(int Range)
	{
		this.Range = Range;
	}
	
	public void setRange(int Range)
	{
		this.Range = Range;
	}
	
	public int getRange()
	{
		return Range;
	}
    
	public void play() {
    	Scanner input = new Scanner(System.in);
    	int low = 0;
    	int high = Range;
    	Boolean isNumber = false;

    	while (!isNumber) 
    	{
    		int mid = (low + high)/2;
			int midVal = mid;
			
			System.out.println("Is it " + mid);
				
			if(input.nextBoolean()) //Checks isNum
			{
				isNumber = true;
			}
			else
			{
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