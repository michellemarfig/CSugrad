/* Written by: Michelle Martinez-Figueroa
*  Lab 7 - Generic Programming
*  CS272
*  March 1, 2019
*  LinkStack class
*/
import java.util.EmptyStackException;
public class LinkStack<E> implements StackInterface<E> {
	private SNode<E> head;
	
	/*
	 * Method to push e to the stack
	 * @param element to put in the stack
	 * @ postcondition e is pushed to the stack and head points to it
	 */
	public void push(E e) {
		//Make new node and point to it
		head = new SNode<E>(e, head);
	} // END push method
	
	
	
	/*
	 * Method to pop last element of stack
	 * @ postcondition the last element in the stack is popped
	 * 		off and head points to next node
	 */
	public E pop() {
		E newNode;
		 if ( head == null) {
			 throw new EmptyStackException();
		 } // END if
		 
		 newNode = head.getData();
		 head = head.getLink();
		 return newNode;
	} // END pop method	
			
	
	/*
	 * Method to return the last element of stack
	 * @ postcondition the last element in the stack is popped off
	 */
	public E top() {
		if (head == null);
		return head.getData();
	} // END top
	
	
	/*
	 * Method to get size of the stack
	 * @return integer size of stack
	 */
	public int size() {
		return head.listLength();
	} // END size
			
	
	/*
	 * Method to check if size is empty
	 * @postcondition Message will be printed if stack is empty.
	 */
	public boolean isEmpty() {
		return (head == null);
	}// END isEmpty 
   
	
	
	
	/*
	 * Method to print linked list
	 * @return linked list as a string
	 */
	public String toString() {
		String s = "";
		SNode<E> cursor = head;
		
//		System.out.println(cursor.data);
//		System.out.println(cursor.link);
		
		for (cursor = head; cursor != null; cursor = cursor.link) {
			if ( cursor == head ) {
				s = s + "Top -> " + cursor.getData() + " -> ";
			} else if ( cursor.link == null) {
				s = s + cursor.getData();
			} else {
				s = s + cursor.getData() + " -> ";
			} // END if-else
		} // for
		return s;
	} // END toString 
			
} // END class