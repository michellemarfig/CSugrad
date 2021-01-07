/* Written by: Michelle Martinez-Figueroa
*  Lab 7 - Generic Programming
*  CS272
*  March 1, 2019
*  ArraylistStack class
*/

import java.util.EmptyStackException;
import java.lang.IllegalArgumentException;


public class ArraylistStack<E> implements StackInterface<E> {
	private E[] data;
		
	/*
	 * No argument constructor
	 * @postcondition 10 spaces are reserved to ArraylistStack 
	 */
	@SuppressWarnings("unchecked")
	public ArraylistStack() {
		data = (E[]) new Object[1];
	} // END no-argument constructor
	
	
	
	/*
	 * Constructor
	 * @postcondition an inputed number of spaces are reserved
	 */
	@SuppressWarnings("unchecked")
	public ArraylistStack(int i) {
		if ( i < 0) {
			throw new IllegalArgumentException ("initial capacity is too small" + i);
		} //END if
      data = (E[]) new Object[i];
	} // END Constructor 
	
	/*
	 * Method to ensure capacity of inputed number
	 * @param minimum capacity needed
	 * @postcondition checks if enough space, if not, the array size made to minimum capacity needed
	 */
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minimumCapacity) {
		E[] bigArray;
		
		if ( data.length < minimumCapacity) {
			bigArray = (E[]) new Object[minimumCapacity];
			System.arraycopy(data, 0, bigArray, 0, data.length);
			data = bigArray;
		}// END if
	} // END ensureCapacity
	
	
	
	/*
	 *  Method to get capacity of data
	 * @return the number of elements in data
	 */
	public int getCapacity() {
		return data.length;
	}// END getgCapacity
	
	
	/*
	 * Method to check if data is Empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty() {
		return (size() == 0);
	} // END isEmpty
	
	/*
	 * MEthod to get top element of stack
	 * @return the top element of stack
	 * @postcondition the top element of stack is returned
	 */
	public E top() {
		if (size() == 0) {
			System.out.println("The stack is empty");
         return null;
		} // END if
		return (E) data[getCapacity() - 1];
	} // END top
	
	
	/*
	 * Method to get pop the top element
	 * @return the top element of stack
	 * @postcondition the top element is returned and the erases that element from stack
	 */
    @SuppressWarnings("unchecked")
	public E pop() {
		E answer;
      E[] bigArray;
		if (getCapacity() == 0) {
			throw new EmptyStackException();
		} // END if
      answer = (E) data[data.length - 1];
      bigArray = (E[]) new Object[data.length - 1];
		System.arraycopy(data, 0, bigArray, 0, data.length - 1);
		data = bigArray;
      
      return answer;
	} // END pop
	
	
	/*
	 * Method to get push an element to the stack
	 * @return the top element of stack
	 * @postcondition the inputed element is push to the top of stack
	 */
	public void push(E e) {
		ensureCapacity(getCapacity() + 1);
      data[data.length - 1] = e;
	} // END push
	
	/*
	 * Method to get size of stack
	 * @return the size of stack
	 */
	public int size() {
		int answer = 0;
      for ( int i = 0; i < data.length; i++ ) {
         if ( data[i] != null ) {
            answer++;
         } // END if
      } // END for
      return answer;
	}// END size
	
	public String toString() {
		String s = "";
		for (int i = data.length - 1; i >= 0; i--) {
         if ( i == data.length - 1) {
            s = "Top -> " + data[i];
         } else  if ( i == 0 ){
            ;
         } else {
            s = s + " -> "+ data[i];
         } // END if -else         
		}// END for
      return s;
	}// END toString
   
   
} // END class