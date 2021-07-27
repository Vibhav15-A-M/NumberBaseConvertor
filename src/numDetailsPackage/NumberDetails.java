package numDetailsPackage;

import java.util.Scanner;
import validationPackage.Validation;

/**
 * This is used to store the details of number.
 * @oldNum = Number user want to convert.
 * @oldBase = Base of the Number which user want to convert.
 * @newBase = Base to the new number user which user wants.
 * 
 */

public class NumberDetails {

	 public String oldNum = null ;
	 public int oldBase ;
	 public int newBase ;
		
		public int readInputs()
		{
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter the Number you want to convert:");
			oldNum = in.nextLine();
			if( !Validation.validate(oldNum) )  //---- Method Overloading
			{
				System.out.println("Wrong Number !! Invalid characters.");
				return 0;
			}
			System.out.println("Enter the Base of the number:");
			oldBase = in.nextInt();
				
			return 1;
			// scanner is not closed here because if we close 'System.in' then we can't re-open.
		}
}
