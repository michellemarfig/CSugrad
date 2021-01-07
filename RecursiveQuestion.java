/*
 * Written by: Michelle Martinez-Figueroa
 * May 7, 2018
 * Lab 9 - Recursive Thinking
 */

public class RecursiveQuestion {
	
	/*
	 * Method to show Fibonacci's sequence
	 * @param number to start sequence
	 * @return Answer to Fibonacci's sequence
	 */
	public static int FibBinaryRecursive( int k ) {
		// Error Case
		if ( k < 0 ) {
			return;
		}  // END if
		
		//Base Case
		if ( k == 0 ) {
			return 0;
		} // END if 
		
		if ( k == 1) {
			return 1;
		} // END
		
		//Recursive Case
		return k + FibBinaryRecursive(k -1);
	} // END FibBinaryRecursive method
	
	
	
	/*
	 * Method to solve Towers of Hanoi game
	 * FIX ME!!!!!!!!!!!
	 */
	 
	
	
	
	/*
	 * Method to  show call level
	 * @param level and curl
	 * @ return a String
	 */
	public static String showCallLevel( int L, int curl ) {
		String tab = "";
		for ( int i = 0; i < level - 1; i++) {
			tab += "	";
		} // END for
		
		if ( s == 1 ) {
			System.out.println(s);
		} else {
			s = tab + "This was written by call number "
							+ level + "x\n" + showCallLevel(L-1, curl);
		} // END if-else
	} // END showCallLevel method
	
	
	/*
	 * Method to print any number in binary
	 * @param number to convert to binary
	 * @postcondition binary number is printed
	 */
	public static int BinaryPrint( int n ) {
		int s;
		if (n == 0) {
			return 0;
		} else {
			return (n % 2 +10 * BinaryPrint(n/2));
		}
	} // END BinaryPrint method
} // END class