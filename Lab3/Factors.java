// C S 172
// Factors
// Lab Number 3
// Written by: Michelle Martinez-Figueroa
// September 18, 2018
// Input: User enters an integer
// Output: The factors of that integer


import java.util.Scanner;     // call Scanner
public class Factors {
   public static void main (String args[]) {
   
      int num;    //declare variables
      Scanner scan = new Scanner(System.in); 
      System.out.println("Enter an integer");      //Ask user for input
      num = scan.nextInt();                        // Assign input to variable num
      System.out.println("The factors of " + num + " are:");  
                         
      for (int x = 1; x <= num; x++)      // for loop to increment by one if x is equal or greater than num
         if (num % x == 0)                // if the remainder of x is 0
            System.out.print(x + " ");    // then print out the factor and a space
            
         
         } // end main
} // end class