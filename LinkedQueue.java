/* Written by: Michelle Martinez-Figueroa 
 * Lab 8
 * CS 272
 * March 15, 2019
 * Linked Queue
 */

public class LinkedQueue<E> implements QueueInterface<E>{
	private SNode<E> frontNode;
	private SNode<E> backNode;
	private int numItems;
	
	
	
	/*
	 * No-argument constructor
	 * @postcondition frontNode, and backNode is set to 
	 */
	public LinkedQueue() {
		frontNode = null;
		backNode = null;
	} // END no-argument constructor
	/*
	 * Method to add an item to queue
	 * return item to add
	 * postcondition item is added to the rear of stack
	 */
	public void enqueue(E item) {
		if (isEmpty()) {
			frontNode = new SNode(item, null);
			backNode = frontNode;
		} else {
			backNode.addEnd(item);
		} // END if-else
		numItems++;
	} // END enqueue
	
	
	
	/*
	 * Method to remove the next element from queue
	 * @return element
	 * @postcondition element is removed from queue
	 */
	public E dequeue() {
		if (isEmpty()) {
			System.out.println("The queue is already empty.");
		} // END if
		
		E answer = frontNode.getData();
		frontNode = frontNode.getLink();
		numItems--;
		if (numItems == 0) {
			backNode = null;
		} // END if
      return answer;
	} // END dequeue
	


	/*
	 * Method to return front node
	 * @return the front element
	 */
	public E front() {
		if (isEmpty()) {
			System.out.println("The queue is already empty.");
		} // END if
		
		E answer = frontNode.getData();
      return answer;
	} // END front
	
	
	
	/*
	 * Method to get size of queue
	 * @return size of queue
	 */
	public int size() {
		return numItems;
	} // END size
	
	
	
	/*
	 * Method to check if queue isEmpty
	 * @return true if empty, false if not empty
	 */
	public boolean isEmpty() {
		if (numItems == 0) { return true; }
		else { return false; }
	} // END isEmpty
	
	
	
	/*
	 * Method to print list
	 * @return string of list
	 */
	public String toString() {
		String s = "Queue: ";
		SNode cursor;
		for (cursor = frontNode; cursor != null; cursor = cursor.getLink()) {
			if (cursor.link == null) {
            s = s + cursor.getData(); 
         } else {
            s = s + cursor.getData() + " -> ";
         } // END if-else
		} // END for
		return s;
	} // END toString
} // END class