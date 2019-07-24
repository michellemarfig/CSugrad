// C S 172
// Loops
// Lab Number 3
// Written by: Michelle Martinez-Figueroa
// September 25, 2018

import java.util.Scanner;    // call Scanner

class lab4Loops {

      public static void main (String [] args) {
      
      int i;
      int clear;
      
            // ********************************* #1 - odd #s from 1 - 99
            
            System.out.println( "Output for #1:");
            System.out.println();
            for ( i = 0; i < 100; i++) {
            
                  if ( (i % 2)!= 0) {
                  
                        System.out.print(i + ", ");
                  
                  } //end of if
            
            } // end of for
            
            System.out.println();
            
            
            // ******************************* #2 - Nested Loops (triangle)
            int val;
            int j; // need two counters, i already a variable
            
            System.out.println();
            System.out.println("Problem #2:");
            
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please enter an integer."); //ask for input
            val = scnr.nextInt();                           // Put that into val
            
            System.out.println(" Output for #2:");
            System.out.println();
            
            for (i = 1; i <= val; i++) {     //outside for loop will loop val times then println
            
                  for ( j = 1; (j <= i) && (j > 0) ; j++) { //inside will loop i number of times
                  
                        System.out.print("*");
                  
                  }
                  
                  System.out.println();
            
            }
            
            System.out.println();
            
            
            // ****************************************** #3 - Reverse String
            scnr.nextLine();
            
            String userText;     //create a variable to hold string
            
            System.out.println();
            System.out.println("Problem #3:");
            System.out.println("Please enter a sentence."); //ask for input
            userText = scnr.nextLine();      // put that into variable
            
            System.out.println("Output for #3:");
            System.out.println();
            
            for (i = userText.length() -1; i >= 0; i--) {
            
                  System.out.print(userText.charAt(i));
            
            }
            
            System.out.println();
            
            // ****************************************** #4 - Highest Value
            System.out.println();
            
            int userNum;      //declare variables
            int highVal = -999999999;     // allow for negatives
            
            System.out.println("Problem #4:");
            System.out.println();
            
            for (i = 0; i < 10; i++) {       // loops 10 times and keeps track of highest value
            
                  System.out.println("Please enter an integer."); // ask for input
                  userNum = scnr.nextInt();     // put that into userNum
                  
                  
                  if ( userNum > highVal ) {    // 
                  
                        highVal = userNum;
                  
                  }
                  
            
            }
            
            System.out.println("The highest value is: " + highVal + ".");  // print highest Value
            System.out.println();
            
            
            
            // ********************************************** #5 - Count Vowels
            
            int vA = 0;    //create variable to keep track of counts
            int vE = 0;
            int vI = 0;
            int vO = 0;
            int vU = 0;
            
            scnr.nextLine();     //clean buffer
            
            System.out.println();
            System.out.println("Problem #5:");
            System.out.println();
            
            System.out.println("Please enter a sentence.");    // Ask for input
            userText = scnr.nextLine();      // put that into pocket
            
            for (i = 0; i < userText.length(); i++) {
            
                  if ( (userText.charAt(i) == 'a') || (userText.charAt(i) == 'A') ) {
                  
                        vA++;
                  
                  } // end of if
                  
                  if ( (userText.charAt(i) == 'e') || (userText.charAt(i) == 'E') ) {
                  
                        vE++;
                  
                  } // end of if
                  
                  if ( (userText.charAt(i) == 'i') || (userText.charAt(i) == 'I') ) {
                  
                        vI++;
                  
                  } // end of if
                  
                  if ( (userText.charAt(i) == 'o') || (userText.charAt(i) == 'O') ) {
                  
                        vO++;
                  
                  } // end of if
                  
                  if ( (userText.charAt(i) == 'u') || (userText.charAt(i) == 'U') ) {
                  
                        vA++;
                  
                  } // end of if
            
            } // end of for
            
            System.out.println();
            System.out.println("The string contained:");
            System.out.printf(vA + "A's" );
            System.out.printf(vE + "E's" );
            System.out.printf(vI + "I's" );
            System.out.printf(vO + "O's" );
            System.out.printf(vU + "U's" );
            
            
            
            
      
      } // end of main

} // end of class