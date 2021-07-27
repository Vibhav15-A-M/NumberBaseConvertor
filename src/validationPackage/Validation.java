package validationPackage;


/**
 * Here we validate the number and its base.
 * 
 * Note:
 *  -> For simplicity we have considered base of the number to be less then 36(10+26).
 *  -> Number is invalid if contains any character other than digits and alphabets.
 *  -> Number must not have a digit greater than the base(we can't have 2 as digit for base 2).
 *  -> For Numbers with base more then 10 the letter used must be less then base.
 *     (for base 16 we can only have 'A'-10,'B'-11,'C'-12,'D'-13,'E'-14,'F'-15, any other letter than these
 *        then it is an invalid number).
 */
public class Validation
{
	// This method is to validate base.
	public static void validate(int base)                // ------- Overloading.
	{
		if(base <2 || base >36)
			throw new ArithmeticException();             // ------ throwing an exception.
	}
	
	// This method is to validate the number entered.
	public static Boolean validate(String num)           // ------- Overloading.
	{
		int len = num.length();
	      for (int i = 0; i < len; i++) {
	         // checks whether the character is neither a letter nor a digit
	         // if it is neither a letter nor a digit then it will return false
	         if ((Character.isLetterOrDigit(num.charAt(i)) == false)) {
	            return false;
	         }
	      }
	      return true;
	}
	
	// This is to validate whether the entered number is valid in base or not.
	public static int validate(String num,int base)     // ------- Overloading.
	{ 
		char chrdgt;
		for(int i = 0;i<num.length() ;i++)               // ------ .length() .
		{
			chrdgt = num.toUpperCase().charAt(i);
			
			if( Character.isDigit(chrdgt) && (chrdgt - '0') >= base) {
				System.out.println("Wrong Number!!! Cannot have digit greater than " + (base-1) + " for base "+ base);
			    return -1;}
			
			if( Character.isLetter(chrdgt) && (chrdgt - 'A')+10 >= base) {
				System.out.println("Wrong Number!!! Cannot have letter greater than "+ (char)(base-10+64) + " for Base "+ base);
				return -1;}
			
			if( !Character.isDigit(chrdgt) && !Character.isLetter(chrdgt)) {
				System.out.println("Wrong Number!!! Invalid character");
				return -1;}
		}
		return 0;
	}
	
	
}