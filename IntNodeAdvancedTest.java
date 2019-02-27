/* Written by: Michelle Martinez-Figueroa
*  Lab 4
*  CS272
*  February 15, 2019
*  IntNode class - Singly Linked Lists ( advanced )
*/
import java.util.Collections;
import java.util.LinkedList;

public class IntNodeAdvancedTest {
   public static void main(String[] args) {
      //Variables to test output
      int i;
      String s;
      
      boolean b;
      
      //Create sample nodes
      System.out.println("Creating IntNodes:");
      IntNode ta = new IntNode();
      IntNode tb = new IntNode(20, null);
      IntNode tc = new IntNode(111, null);
      IntNode td = new IntNode(6, null);
      IntNode te = new IntNode(42, null);
      IntNode tg = null;
      
      ta.addNodeAfterThis(7);
      ta.addNodeAfterThis(16);
      ta.addNodeAfterThis(58);
      ta.addNodeAfterThis(106);
      ta.addNodeAfterThis(2);
      tb.addNodeAfterThis(86);
      tb.addNodeAfterThis(45);
      tb.addNodeAfterThis(42);
      tb.addNodeAfterThis(11);
      tb.addNodeAfterThis(55);
      tb.addNodeAfterThis(63);
      td.addNodeAfterThis(10);
      td.addNodeAfterThis(3);
      td.addNodeAfterThis(6);
      td.addNodeAfterThis(8);
      td.addNodeAfterThis(46);
      td.addNodeAfterThis(6);
      td.addNodeAfterThis(6);
      te.addNodeAfterThis(42);
      te.addNodeAfterThis(42);
      te.addNodeAfterThis(47);
      te.addNodeAfterThis(40);
      te.addNodeAfterThis(42);
      te.addNodeAfterThis(48);
      te.addNodeAfterThis(45);
      System.out.println();
      
      System.out.println("Printing ta:");
      System.out.println(ta.toString());
      System.out.println();
      
      System.out.println("Printing tb:");
      System.out.println(tb.toString());
      System.out.println();
      
      System.out.println("Printing tc:");
      System.out.println(tc.toString());
      System.out.println();
      
      System.out.println("Printing td:");
      System.out.println(td.toString());
      System.out.println();
      
      System.out.println("Printing te:");
      System.out.println(te.toString());
      System.out.println();
      
      //Testing list even Number method
      System.out.println("Testing listEvenNumber method:");
      i = ta.listEvenNumber(ta);
      System.out.println("There are " + i + " even numbers in ta");
      System.out.println();
      
      
      System.out.println("Testing listEvenNumber method:");
      i = tb.listEvenNumber(tb);
      System.out.println("There are " + i + " even numbers in tb");
      System.out.println();
      
      
      System.out.println("Testing listEvenNumber method:");
      i = tc.listEvenNumber(tc);
      System.out.println("There are " + i + " even numbers in tc");
      System.out.println();
      
      
      System.out.println("Testing listEvenNumber method with null head:");
      i = tc.listEvenNumber(null);
      System.out.println("There are " + i + " even numbers in null");
      System.out.println();
      
      //Testing addTo End Method
      System.out.println("Testing addToEnd method:");
      System.out.println("Testing addToEnd method on td with \"100\":");
      td.addToEnd(32);
      System.out.println("Printing td:");
      System.out.println(td.toString());
      System.out.println();
      
      
      System.out.println("Testing addToEnd method:");
      System.out.println("Testing addToEnd method on td with \"75\":");
      td.addToEnd(75);
      System.out.println("Printing td:");
      System.out.println(td.toString());
      System.out.println();
      
      //Testing sumLast method
      System.out.println("Testing sumLast method:");
      System.out.println("Testing sumLast 3 numbers in ta:");
      i = ta.sumLast(ta, 3);
      System.out.println("The sum of the last 3 numbers is: " + i + ".");
      System.out.println();
      
      System.out.println("Testing sumLast 13 numbers in tb:");
      i = tb.sumLast(tb, 13);
      System.out.println("The sum of the last 13 numbers is: " + i + ".");
      System.out.println();
      
      System.out.println("Testing sumLast 2 numbers in tc:");
      i = tc.sumLast(tc, 2);
      System.out.println("The sum of the last 2 numbers is: " + i + ".");
      System.out.println();
      
      //Testing copyOdd Method
      System.out.println("Testing copyOdd method:");
      System.out.println("Testing copyOdd method on ta:");
      IntNode sNode = (IntNode) ta.copyOdd(ta);
      System.out.println("Printing ta:");
      System.out.println(sNode);
      System.out.println();
      
      
      System.out.println("Testing copyOdd method:");
      System.out.println("Testing copyOdd method on tb:");
      sNode = (IntNode) tb.copyOdd(tb);
      System.out.println("Printing tb:");
      System.out.println(sNode);
      System.out.println();
      
      
      //Testing removeAll method
      System.out.println("Testing removeAll method:");
      System.out.println("Testing removeAll method on td with \"6\":");
      td.removeAll(td, 6);
      System.out.println(td.toString());
      System.out.println();
      
      System.out.println("Testing removeAll method:");
      System.out.println("Testing removeAll method on te with \"42\":");
      td.removeAll(te, 42);
      System.out.println(te.toString());
      System.out.println();
      
      //Testing reverse method
      System.out.println("Testing reverse method:");
      System.out.println("Testing reverse method on te:");
      sNode = te.reverse(te);
      System.out.println("Printing te:");
      System.out.println(sNode);
      System.out.println();
      
      System.out.println("Testing addToEnd method:");
      System.out.println("Testing addToEnd method on td:");
      td.addToEnd(100);
      System.out.println("Printing td:");
      System.out.println(td.toString());
      System.out.println();
      
      //Testing hasCycle method
      //Creating a cyclic linked list tf
      IntNode tf= new IntNode(40, null);
      IntNode cursor;
      tf.addToEnd(0);
      tf.addToEnd(74);
      tf.addToEnd(54);
      i = 0;
      for (cursor = tf; cursor != null; cursor = cursor.getLink() ) {
         i++;
         if( i == tf.listLength(tf) ) {
            cursor.setLink(tf);
            break;
         } // END if
      } // END for
      
      System.out.println("Testing hasCycle method:");
      System.out.println("Testing hasCycle method on tf:");
      b = tf.hasCycle(tf);
      System.out.println(b);
      System.out.println();
      
      System.out.println("Testing hasCycle method:");
      System.out.println("Testing hasCycle method on tb:");
      b = tb.hasCycle(tb);
      System.out.println(b);
      System.out.println();
      
   } // END main
} // END class