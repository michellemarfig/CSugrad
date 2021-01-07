/* Written by: Michelle Martinez-Figueroa 
 * Lab 8
 * CS 272
 * March 15, 2019
 * QueueTest for QueueInterface
 */

public class QueueTest {
	public static void main(String[] args) {
		//Testing integer type linkedQueue
		System.out.println("Testing LinkedQueue with integer type");
		System.out.println("Creating iLinkedQueue:");
		QueueInterface<Integer> iLQueue = new LinkedQueue<Integer>();
      System.out.println();
      
      //Testing enqueue
      System.out.println("Adding 0 to queue:");
      iLQueue.enqueue(0);
      System.out.println();
      
      //Testing toString
      System.out.println("Testing toString:");
      System.out.println(iLQueue.toString());
      System.out.println();
		
		//Adding items to queue
		System.out.println("Adding 1, 2, 3, 4, and 5 to queue:");
      iLQueue.enqueue(1);
      iLQueue.enqueue(2);
      iLQueue.enqueue(3);
      iLQueue.enqueue(4);
      iLQueue.enqueue(5);
      System.out.println("Printing iLQueue:");
      System.out.println(iLQueue.toString());
      System.out.println();
		
      //Testing dequeue
		System.out.println("Testing deque method:");
      iLQueue.dequeue();
      System.out.println("Printing iLQueue:");
      System.out.println(iLQueue.toString());
      System.out.println();
      
      //Testing front method
      System.out.println("Testing front method:");
      System.out.println(iLQueue.front());
      System.out.println();
      
      //Testing size method
      System.out.println("Testing size method:");
      System.out.println(iLQueue.size());
      System.out.println();
      
      //Testing isEmpty method
      System.out.println("Testing isEmpty method:");
      System.out.println(iLQueue.isEmpty());
      System.out.println();
		
      
      
      //Testing String type LinkedQueue
      System.out.println("Testing LinkedQueue with String type:");
      QueueInterface<String> sLQueue = new LinkedQueue<String>();
      System.out.println();
      
      //Testing push
      System.out.println("Pushing elements to sLQueue:");
      sLQueue.enqueue("I");
      sLQueue.enqueue("Love");
      sLQueue.enqueue("Computer");
      sLQueue.enqueue("Science");
      sLQueue.enqueue("!!!!");
      System.out.println();
      
      //Testing toString
      System.out.println("Printing sLQueue:");
      System.out.println(sLQueue.toString());
      System.out.println();
      
      //Testing dequeue
      System.out.println("Testing dequeue on sLQueue:");
      sLQueue.dequeue();
      System.out.println("Printing sLQueue:");
      System.out.println(sLQueue.toString());
      System.out.println();
      
      //Testing front
      System.out.println("Testing front method:");
      System.out.println(sLQueue.front());
      System.out.println();
      
      //Testing size
      System.out.println("Testing size:");
      System.out.println(sLQueue.size());
      System.out.println();
      
      //Testing isEmpty
      System.out.println("Testing isEmpty:");
      System.out.println(sLQueue.isEmpty());
      System.out.println();
      
      //Testing Array Queue
      System.out.println("Creating new double type Array Queue:");
      QueueInterface<Double> dAQueue = new ArrayQueue<Double>();
      System.out.println();
      
      //Testing size
      System.out.println("Testing size:");
      System.out.println(dAQueue.size());
      System.out.println();
      
      
      //Testing isEmpty
      System.out.println("Testing isEmpty:");
      System.out.println(dAQueue.isEmpty());
      System.out.println();
      
      //Testing enque
      System.out.println("Adding elements to queue:");
      dAQueue.enqueue(3.14);
      dAQueue.enqueue(6.5);
      dAQueue.enqueue(0.6514);
      dAQueue.enqueue(321.541);
      dAQueue.enqueue(0.00001);
      System.out.println();
      
      //Printing
      System.out.println("Printing dAQueue:");
      System.out.println(dAQueue.toString());
      System.out.println();
      
      //front
      System.out.println("Testing front:");
      System.out.println(dAQueue.front());
      System.out.println();
      
      //dequeue
      System.out.println("Testing dequeue:");
      System.out.println("Printing dAQueue:");
      System.out.println(dAQueue.toString());
      System.out.println();
      
      
      
      
      
	} // END main
} // END class