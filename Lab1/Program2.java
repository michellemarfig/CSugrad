// ************************************************************
// Michelle Martinez-Figueroa
// August 28, 2018
// C S 172 
// Program2.java
// 
// Print the volume of a cylinder with a given height
// and diameter
// *************************************************************

public class Program2 {

   public static void main(String[] args) {
   
      double height;         // Declare the variables
      double diameter;
      double volume;
      double radius;
      
      height = 8.2;          // Initialize variables
      diameter = 5.0;
      
      radius = diameter/2;   // Calculate the radius
      
      volume = Math.PI * ( radius * radius ) * height;
      
      System.out.println( "The height is " + height );
      System.out.println( "The diameter is " + diameter );
      System.out.println( "The volume is " + volume );
      
      
                           
         
   } // end of main
   
} // end of class