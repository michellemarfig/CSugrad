/* Written by: Michelle Martinez-Figueroa
*  Lab 7 - Generic Programming
*  CS272
*  March 1, 2019
*  StackInteface Testing
*/

public class StackTest {
	public static void main(String[] args) {
	  System.out.println("Creating an Integer type ArrayStack:");
	  StackInterface<Integer> iArrayStack = new ArraylistStack<Integer>();
      System.out.println();
      
      System.out.println("Testing push method with 3:");
      iArrayStack.push(3);
      System.out.println("Printing iArrayStack:");
      System.out.println(iArrayStack.toString());
      System.out.println();
      
      
      System.out.println("Pushing, 6, 8, 2, and 0 to iArrayStack");
      iArrayStack.push(3);
      iArrayStack.push(8);
      iArrayStack.push(2);
      iArrayStack.push(0);
      System.out.println();
      
      System.out.println("Testing to String method:");
      System.out.println(iArrayStack.toString());
      System.out.println();
      
      System.out.println("Testing pop method:");
      iArrayStack.pop();
      System.out.println("Printing iArrayStack:");
      System.out.println(iArrayStack.toString());
      System.out.println();
      
      
      System.out.println("Testing top method:");
      System.out.println(iArrayStack.top());
      System.out.println();
      
      System.out.println("Testing size method:");
      System.out.println(iArrayStack.size());
      System.out.println();
      
      System.out.println("Testing isEmpty method:");
      System.out.println(iArrayStack.isEmpty());
      System.out.println();
      
      System.out.println("Popping iArrayStack 4 times:");
      iArrayStack.pop();
      iArrayStack.pop();
      iArrayStack.pop();
      iArrayStack.pop();
      
      System.out.println("Testing isEmpty method:");
      System.out.println(iArrayStack.isEmpty());
      System.out.println();
      
      System.out.println("Testing top method:");
      System.out.println(iArrayStack.top());
      System.out.println();
      
      System.out.println("Testing size method:");
      System.out.println(iArrayStack.size());
      System.out.println();
      
      System.out.println("Testing pop method:");
      iArrayStack.pop();
      System.out.println("Printing iArrayStack:");
      System.out.println(iArrayStack.toString());
      System.out.println();
      
      System.out.println("*************************************************");
      
      System.out.println("Creating an String type ArrayStack:");
		StackInterface<String> sArrayStack = new ArraylistStack<String>();
      System.out.println();
      
      System.out.println("Pushing, Hello, I, luv, and CS to sArrayStack");
      sArrayStack.push("Hello");
      sArrayStack.push("I");
      sArrayStack.push("luv");
      sArrayStack.push("CS");
      System.out.println("Printing sArrayStack:");
      System.out.println(sArrayStack.toString());
      System.out.println();      
      
      System.out.println("Testing pop method:");
      sArrayStack.pop();
      System.out.println("Printing sArrayStack:");
      System.out.println(sArrayStack.toString());
      System.out.println();
      
      System.out.println("Testing top method:");
      System.out.println(sArrayStack.top());
      System.out.println();
      
      System.out.println("Testing size method:");
      System.out.println(sArrayStack.size());
      System.out.println();
      
      System.out.println("Testing isEmpty method:");
      System.out.println(sArrayStack.isEmpty());
      System.out.println();
      
      System.out.println("*************************************************");
      
      System.out.println("Testing LinkStack with Integer type:");
      StackInterface<Integer> iLinkStack = new LinkStack<Integer>();
      System.out.println();
      
      System.out.println("Pushing 9, 5, 7, 2, and 3 to iLinkStack:");
      iLinkStack.push(9);
      iLinkStack.push(5);
      iLinkStack.push(7);
      iLinkStack.push(2);
      iLinkStack.push(3);
      System.out.println("Printing iLinkStack:");
      System.out.println(iLinkStack.toString());
      System.out.println();
      
      System.out.println("Testing pop method:");
      System.out.println(iLinkStack.pop());
      System.out.println("Printing iLinkStack:");
      System.out.println(iLinkStack.toString());
      System.out.println();
      
      System.out.println("Testing top method:");
      System.out.println(iLinkStack.top());
      System.out.println();
      
      System.out.println("Testing isEmpty method:");
      System.out.println(iLinkStack.isEmpty());
      System.out.println();
      
      System.out.println("Testing size method:");
      System.out.println(iLinkStack.size());
      System.out.println();
      
      System.out.println("*************************************************");
      
      System.out.println("Testing LinkStack with Double type:");
      StackInterface<Double> dLinkStack = new LinkStack<Double>();
      System.out.println("Printing dLinkStack:");
      System.out.println(dLinkStack.toString());
      System.out.println();
      
      System.out.println("Pushing 3.5, 6.8, 13.1, 0.99, and 3.14 to iLinkStack:");
      dLinkStack.push(3.5);
      dLinkStack.push(6.8);
      dLinkStack.push(13.1);
      dLinkStack.push(0.99);
      dLinkStack.push(3.14);
      System.out.println("Printing dLinkStack:");
      System.out.println(dLinkStack.toString());
      System.out.println();
      
      System.out.println("Testing pop method:");
      System.out.println(dLinkStack.pop());
      System.out.println("Printing iLinkStack:");
      System.out.println(dLinkStack.toString());
      System.out.println();
      
      System.out.println("Testing top method:");
      System.out.println(dLinkStack.top());
      System.out.println();
      
      System.out.println("Testing isEmpty method:");
      System.out.println(dLinkStack.isEmpty());
      System.out.println();
      
      System.out.println("Testing size method:");
      System.out.println(dLinkStack.size());
      System.out.println();
      
      System.out.println("Popping sLinkStack 4 times:");
      dLinkStack.pop();
      dLinkStack.pop();
      dLinkStack.pop();
      dLinkStack.pop();
      System.out.println("Printing iLinkStack:");
      System.out.println(dLinkStack.toString());
      System.out.println();

      System.out.println("Testing isEmpty method:");
      System.out.println(dLinkStack.isEmpty());
      System.out.println();
      		
	} // END main
} // END class