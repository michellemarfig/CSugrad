// ************************************************************
// Michelle Martinez-Figueroa
// August 28, 2018
// C S 172 
// Program3.java
// 
// Calculate amount of sales tax and the total purchase price
// of a new refrigerator
// *************************************************************

import java.util.Scanner;     //Call Scanner

public class Program3 {

   public static void main(String[] args) {
   
   Scanner scnr = new Scanner(System.in);
   
   double price;                               //Declare Variable
   double salesTaxPercent;
   double total;
   double salesTaxDecimal;
   double salesTaxValue;
   
   System.out.println( "Please enter the cost of refrigerator, and then press ENTER" );        //Assign values with user input
   price = scnr.nextDouble();
   
   System.out.println( "Please enter the sales tax percentage, and then press ENTER" );
   salesTaxPercent = scnr.nextDouble();
   
   salesTaxDecimal = salesTaxPercent / 100;
   salesTaxValue = price * salesTaxDecimal;
   total = salesTaxValue + price;
   
   System.out.printf( "Refrigerator price \t $ %4.2f\n", price );
   System.out.print( "Sales Tax (" + salesTaxPercent + ")" );
   System.out.printf( "\t\t $ %6.2f\n", salesTaxValue );
   System.out.printf( "Total \t\t\t\t\t $ %4.2f\n", total );
   
                           
         
   } // end of main
   
} // end of class