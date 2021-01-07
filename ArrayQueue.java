/* Written by: Michelle Martinez-Figueroa 
 * Lab 8
 * CS 272
 * March 15, 2019
 * ArrayQueue for QueueInterface
 */

public class ArrayQueue<E> implements QueueInterface<E> {
	private int frnt;
	private int back;
	private E[] data;
	private int numItems;
	
	
	
	/*
	 * No-argument Constructor
	 * @postcondition data is initialized with 1 item,
	 * 		frnt and back is set to data[0], data[0] is 0; 
	 */
	public ArrayQueue() {
		data = (E[]) new Object[1];
		frnt = 0;
		back = 0;
		numItems = 0;
	} // END no-argument contructor
	
   
	
	public void enqueue(E _data) {
		if (numItems == data.length) {
			ensureCapacity(numItems + 1);
		} // END if
		
		if (numItems == 0) {
			frnt = 0;
			back = 0;
		} else {
			back = nextIndex(back);
		} // END if- else
		
		data[back] = _data;
		numItems++;
	} // END enqueue
	
	
	
	/*
	 * 
	 */
	private int nextIndex(int i) {
		if ( ++i == data.length) { return 0; }
      else { return i; }
	} // END nextIndex
	
	
	
	/*
	 * Method to remove item from queue
	 * @return dequeued item
	 * @postcondition item is dequeued and numItems is dec by 1 
	 */
	public E dequeue() {
		if (numItems == 0) {
			System.out.println("The queue is already empty.");
		} // ENd if
		
		E answer = (E) data[frnt];
		frnt = nextIndex(frnt);
		numItems--;
		return answer;
	} // END dequeue
	
	
	
	/*
	 * Method to return the front of queue
	 * @return item at front of queue
	 */
	public E front() {
		if (numItems == 0) {
			System.out.println("The queue is already empty.");
		} // ENd if
		
		E answer = (E) data[frnt];
		return answer;
	} // END front method
	
	
	
	/*
	 * Method to get size of queue
	 * @return size of queue
	 */
	public int size() {
		return numItems;
	} // END size
	
	
	
	/*
	 * Method to check if queue is empty
	 * @return true if empty, flase if not empty
	 */
	public boolean isEmpty() {
		if (numItems == 0) { return true; }
		else { return true; }
      
	} // END isEmpty
   
   
   public void ensureCapacity(int minimumCapacity) {
		E[] bigArray;
		
		if ( data.length < minimumCapacity) {
			bigArray = (E[]) new Object[minimumCapacity];
			System.arraycopy(data, 0, bigArray, 0, data.length);
			data = bigArray;
		}// END if
	} // END ensureCapacity
   
   
   
   
   public String toString() {
		String s = "";
		for (int i = 0; i < data.length; i++) {
         if ( i == 0) {
            s = "Queue: " + data[i];
         } else  if ( i == data.length ){
            s = s + data[i];
         } else {
            s = s + " -> "+ data[i];
         } // END if -else         
		}// END for
      return s;
	}// END toString
	
	
	
} // END class