package mainPackage;

import java.util.Scanner;
import loginPackage.LoginToApp;
import numDetailsPackage.NumberDetails;
import validationPackage.Validation;
import numberConvertionPackage.NumberConversion;

/**
 * @author 4NI19IS112 Vibhav A M
 * 
 *  This is the Main Class of the project.
 *  it is present in package called baseConversionApp
 *  here we import all packages as we make use of them.
 * 
 * -->We first ask the user to login.
 * -->we then ask the number and the base of the number they want to convert.
 * -->later we ask them the base of the new number.
 * -->then we provide them the new number calculated.
 * 
 */

public class MainClass{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("        Number Base Convertor APP");
		LoginToApp obj = new loginPackage.LoginToApp();
		obj.login();                                   
		
		char cont ;
		do {
			NumberDetails num = new NumberDetails();        // ----- Object to store details of Number. -------
			int checkNum = num.readInputs();
			
			if( checkNum == 0)
			{
				cont = ToContinue();
				continue;
			}
			
			try {                                              // ------ Try-Catch. -------
				Validation.validate(num.oldBase);              // ------ Method Overloading. ------
			}
			catch(ArithmeticException e)
			{
				System.out.println("Enter the base of the number should be between 2 and 36.");
				cont = ToContinue();
				continue;
			}
			
			int val = Validation.validate(num.oldNum, num.oldBase);  // ------ Method Overloading. -------
			if(val == -1)
			{
				cont = ToContinue();
				continue;
			}
				
			System.out.println("Enter the base of the new number:");
			num.newBase = in.nextInt();
			
			// ------- Creating new Thread t. -------
			
			NumberConversion t = new NumberConversion(num);       // ------ Object as Parameter.
			t.start(); 
			
			try{
				t.join();                                        // ------ .join() .
			}
			catch (InterruptedException e)                       // ------ Exception Handling.
			{
				System.out.println("Main thread Interrupted.");
			}
			
			cont = ToContinue();
			
			
		}while(cont != '0');
		
		in.close();
		
		System.out.println("----------------------------------------------");
		System.out.println("Thank you for using Number Base Convertor App.");
		System.out.println("                 by: Vibhav A M -- 4NI19IS112");
		System.out.println("----------------------------------------------");
	}
	
	static char ToContinue()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("Press '0': To Exit");
		System.out.println("Press other alphanumeric character: To Continue");
		char cont = in.nextLine().charAt(0);
		return cont;
		// scanner is not closed here because if we close 'System.in' then we can't re-open.
	}
}
