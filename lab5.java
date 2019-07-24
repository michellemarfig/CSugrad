// C S 172
// Reading input from file
// Lab Number 5
// Written by: Michelle Martinez-Figueroa
// September 25, 2018
// Input: file name
// Output: player's average scores, highest scores, and highest average

import java.util.*;
import java.io.*;

class lab5 {

   public static void main(String[] args) throws IOException { 
   
      String fileName;
      int score1 = 0;
      int score2 = 0;
      int score3 = 0;
      String playerName = "";
      int index = 0;
      String inputLine = "";
      double average = 0.0;
      int highestGame = 0;
      String topPlayer;
      double highestAvg = 0.0;
      String highestAvgPlayer = "";
      int topGame = 0;
      String topGamePlayer = "";
      String text1 = "Player with the highest average:";
      String text2 = "Player with the highet game:";
   
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("Please enter filename."); //Ask user for file name
      fileName = scnr.nextLine();
      
      Scanner fileScan = new Scanner(new File(fileName)); // Scan the file
      
      while (fileScan.hasNext()) {
      
         inputLine = fileScan.nextLine();
         
         //Read the file, get 3 scores
         index = inputLine.lastIndexOf(' ');
         score3 = Integer.parseInt(inputLine.substring(index + 1));
         
         inputLine = inputLine.substring(0, index);
         
         index = inputLine.lastIndexOf(' ');
         score2 = Integer.parseInt(inputLine.substring(index + 1));
         
         inputLine = inputLine.substring(0, index);
         
         index = inputLine.lastIndexOf(' ');
         score1 = Integer.parseInt(inputLine.substring(index + 1));
         
         inputLine = inputLine.substring(0, index);
         
         // Get player's name
         playerName = inputLine.substring(0, index);
         
         //Calculate average
         average = ( (score1 + score2 + score3) / 3.0);
         
         //calculate highest score and player
          if ( score1 > highestGame) {
               highestGame = score1;
               topPlayer = playerName;
          } else if ( score2 > highestGame) {
             highestGame = score2;
               topPlayer = playerName;
          } else if (score3 > highestGame) {
               highestGame = score3;
               topPlayer = playerName;
          }
         
         
         // Print player's averages and highestGame
         System.out.printf( "%20s", playerName);
         System.out.printf( "     Average: %6.3f", average);
         System.out.printf( "     Highest Game: %3d", highestGame);
         System.out.println();
         
         //Get highest average and player name
         if ( average > highestAvg) {
               highestAvg = average;
               highestAvgPlayer = playerName;
         }
         
         //Get all time highest Game and player
         if ( highestGame > topGame) {
               topGame = highestGame;
               topGamePlayer = playerName;
         }
         
       
      
      } // end of while
      
      System.out.println();
      
      //Print overall highest average and game
      System.out.printf("%-33s",text1);
      System.out.printf("  %10s", highestAvgPlayer);
      System.out.printf("    Average: %6.3f", highestAvg);
      System.out.println();
      System.out.printf("%-33s", text2);
      System.out.printf("  %15s", topGamePlayer); 
      System.out.printf("    Game: %6d",topGame);
      
      
      
      
      
      
   
   } // end of main

} // end of class