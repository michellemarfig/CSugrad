/* Written by: Michelle Martinez-Figueroa
*  Lab 7 - Generic Programming
*  CS272
*  March 1, 2019
*  Stack Interface
*/

public interface StackInterface<E>{
		
	//push an element to the stack
	public void push(E e);
	
	//return the last item on the stack and set head to next Item
	public E pop();
	
	//return the last item on the stack
	public E top();
	
	//return size of stack
	public int size();
	
	//check if empty
	public boolean isEmpty();
	
} // END StackInterface