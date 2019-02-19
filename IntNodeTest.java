/* Written by: Michelle Martinez-Figueroa
*  Lab 3 
*  CS272
*  January 29, 2019
*  IntNodeTest class - Linked Lists Testing
*/
public class IntNodeTest {
   public static void main(String[] args) {
      int i;
      String s;
      IntNode l;
      boolean b;
      //Testing no argument constructor
      System.out.println("Testing no argument constructor:");
      IntNode t1 = new IntNode();
      System.out.println("Creating an empty linked list named t1.");
      s = t1.toString();
      System.out.println(s);
      System.out.println();
        
      //Testing constructor
      System.out.println("Testing constructor:");
      System.out.println("Creating a new IntNode named t2 with 34 as value.");
      IntNode t2 = new IntNode(34, null);
      System.out.println("Pritning t2:");
      s = t2.toString();
      System.out.println(s);
      System.out.println();
      
      //Testing addNodeAfterthis Method
      System.out.println("Testing addNodeAfterThis method with 14 on t2:");
      t2.addNodeAfterThis(14);
      System.out.println("Pritning t2:");
      s = t2.toString();
      System.out.println(s);
      System.out.println();
       
      //Testing getData Method
      System.out.println("Testing get method to get node value with t2");
      i = t2.getData();
      System.out.println(i);
       
      //Testing getLink Method
      System.out.println("Testing get Link to get node link with t2");
      l = t2.getLink();
      System.out.println(l);
      System.out.println();
       
      //Testing setData Method
      System.out.println("Testing set data method to set node value with 45 on t2");
      t2.setData(45);
      System.out.println("Printing t2:");
      s = t2.toString();
      System.out.println(s);
      System.out.println();
       
      //Testing setLink Method
      System.out.println("Testing set link method to set node value with null on t2");
      t2.setLink(null);
      System.out.println("Printing t2:");
      s = t2.toString();
      System.out.println(s);
      System.out.println();
       
      //Creating new IntNode t3
      System.out.println("Creating a new linked list named t3 with value 02, and link of null");
      IntNode t3 = new IntNode(01, null);
      System.out.println("Printing t3:");
      s = t3.toString();
      System.out.println(s);
      System.out.println("Adding 02, 03, 04, and 05 to t3");
      t3.addNodeAfterThis(02);
      t3.addNodeAfterThis(03);
      t3.addNodeAfterThis(04);
      t3.addNodeAfterThis(05);
      System.out.println("Printing t3:");
      s = t3.toString();
      System.out.println(s);
      System.out.println();
        
      //Testing listLength method
      System.out.println("Testing listLength method on t3");
      i = t3.listLength(t3);
      System.out.println("The number of elements in this linked list is " + i + ".");
      System.out.println();
        
      //Testing search method
      System.out.println("Testing search method:");
      System.out.println("Searching for \"4\" in t3");
      b = t3.search(t3, 4);
      System.out.println(b);
      System.out.println();
       
      System.out.println("Searching for \"32\" in t3");
      b = t3.search(t3, 32);
      System.out.println(b);
      System.out.println();
       
      //Testing removeNodeAfterThis method
      System.out.println("Testing Remove Node After This method:");
      t3.removeNodeAfterThis();
      System.out.println("Printing t3:");
      s = t3.toString();
      System.out.println(s);
      System.out.println();
        
        
   } //END main
   
} // END class