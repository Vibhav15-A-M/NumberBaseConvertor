package loginPackage;

import java.util.Scanner;

 /** 
 *  Login process is done to detect any Bot's .
 *  
 *  This is done to show the use of  :
 *  
 *  Abstraction- Classes.
 *  Scope and Lifetime of variables.
 *  Access control mechanism.
 *  Instance Variables.
 *  'this' keyword.
 *  Inheritance.
 *  Overriding.
 *  
 */

abstract class loginClass {                                           // ------- Abstraction class.
	String name ;                                                     //
	String password = "1234" ;                                        // -------  Instance Variables.
	String pwd;                                                       //
	Scanner in = new Scanner(System.in);
	
	public void login()                                               // ------ Overriding.
	{
		System.out.println("----------------------------------------------");
		System.out.println("Login Process");
		System.out.println();
		System.out.print("Enter your Name : ");
		name = in.nextLine();
		System.out.println("Enter your password");
		System.out.print("(first four Natural number) : ");
		pwd = in.nextLine();
		
	}

}

public class LoginToApp extends loginClass                               // ------ Inheritance.
{
	public void login()                                                  // ------ Overriding.
	{
		super.login();                                                   // ------ Super.
		
		System.out.println();
		if(this.pwd.equals(password)){                                   // ------ 'this' Keyword.
		    System.out.println("Succesfully logged in as " + name +".");
		    System.out.println("----------------------------------------------");
			}
		else {
			System.out.println("Sorry " + name + " !! Incorrect Password.");
			in.close();
			System.exit(1);
		}
	}
}

