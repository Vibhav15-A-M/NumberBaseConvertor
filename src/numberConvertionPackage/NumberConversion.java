package numberConvertionPackage;
import numDetailsPackage.NumberDetails;
import java.lang.Long;

/**
 *  This is done to show the concepts of threads.
 *  and Constructor.
 *  
 */

public class NumberConversion extends Thread {          // ----------- Threads.
		
    static String newNum; 
    static int newBase;
    static int checkException = 1;
    
    /**
	 * 
	 * parseInt(number,Base) == this is used to convert the 'number' from base 'Base' to a Decimal number.
	 * toString(number,Base) == this is used to convert Decimal number to a number of base 'Base'.
	 * 
	 */
	public NumberConversion(NumberDetails num)  // ----- Constructor.
	{
		newBase = num.newBase;
		
		try {                        // ----- Exception Handling.
		newNum = Long.toString(Long.parseLong(num.oldNum, num.oldBase), newBase).toUpperCase();
		}
		catch(NumberFormatException n)
		{
			System.out.println(n);
			System.out.println("The Value obtained is Out_of_Bound for type Long.");
			checkException = 0;
		}
		
	}
	
	public void run()
	{
		if(checkException == 1)
			System.out.println("The given Number in base "+ newBase + " is: "+ newNum);
		checkException = 1;
	}
}
