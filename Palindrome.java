/* Written by: Michelle Martinez-Figueroa 
 * Lab 8
 * CS 272
 * March 18, 2019
 * Palindrome
 */
 
 import java.util.Scanner;
 
 public class Palindrome<E>{
   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);
      String line;
      do {
         System.out.println("Your expression (or return to end): ");
         line = scnr.nextLine();
         if ( is_palindrome(line)) {
            System.out.println("That is a palindrome.");
         } else {
            System.out.println("That is not a palindrome.");
         } // END if-else
      } while (line.length() != 0);
   } // END main         
   
   
   public static boolean is_palindrome(String input) {
      QueueInterface<Character> q = new LinkedQueue<Character>();
      StackInterface<Character> s = new LinkStack<Character>();
      Character letter;
      int mismatches = 0;
      int i;
      
      for ( i = 0; i < input.length(); i++) {
         letter = input.charAt(i);
         if ( Character.isLetter(letter)) {
            q.enqueue(letter);
            s.push(letter);
         } // END if
      } // ENd for
      
      while ( !q.isEmpty()) {
         if (q.dequeue() != s.pop()) {
            mismatches++;
         } // END if
      } // END while
      System.out.println(mismatches);
      return(mismatches == 0);
   } // END isPalindrome
   
   
   
   
   
   
 } // END class