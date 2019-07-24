// C S 172
// lab2Program
// Lab Number 2
// Written by: Michelle Martinez-Figueroa
// September 11, 2018
// Input: User enters a tring
// Output: Length and first word of string

import java.util.Scanner;      //call scanner

class ManyStrings {
   
   public static void main(String[] args) {
      
      Scanner scnr = new Scanner(System.in);
      
      String userText;         //create variables
      int fWordIndex;
      int halfIndex;
      int lastCharIndex;
      int lastChar;
      int i =0;
   
      //*********************************************************************************** length
      
      System.out.println("Please enter a sentence.");   // ask user for input
      userText = scnr.nextLine();          //assign input to String variable
      userText = userText.trim();          //trim off leading and ending spaces
      
      System.out.println("The number of characters in this sentence is " + userText.length() + ".");    // output length of string
      
      
      // ********************************************************************************** first word  
          
      fWordIndex = userText.indexOf(' ');       // Find out index of the first word
      
      if (fWordIndex != -1) {       // if space exists, print out first word
      
         System.out.println("The first word is \"" + userText.substring(0, fWordIndex) + "\".");
      
      } else {                   //else, let user know.print out the only word
      
            System.out.println("\"" + userText + "\".");
      
      } // end of if-else loop
      
      
      // *********************************************************************************** to UpperCase
      
      System.out.println("The upper case version of your text is: \"" + userText.toUpperCase() + "\"."); // print string in UpperCase
      
      
      // ************************************************************************************ New input
       
       System.out.println("Enter another sentence.");      //ask user for new input
       userText = scnr.nextLine();        // put text to variable
       userText = userText.trim();        // trim off leading and ending spaces
       
       // ************************************************************************************* Half of string
       
       halfIndex = userText.length() / 2;    //get half of index of text
       
       System.out.println("The first half of your text is :\"" + userText.substring(0, halfIndex) + "''.");    // print hald of string
       
       // *************************************************************************************** Replace e to a
       
       System.out.println("This is your text with all 'e' changed to 'a': \"" + userText.replace('e','a') + "\".");     //REplace e to a of userText
       
       
       // ************************************************************************************** Last character
       
       
       lastCharIndex = (userText.length());    // get length of input
       lastChar = lastCharIndex - 1;            //get index of input
       
       System.out.println("The last character in the text is \"" + userText.substring(lastChar) + "\"."); // print last character
       
       
       // ****************************************************************************************** Search for M
       
       
   
   } // end of main
   
} // end of class