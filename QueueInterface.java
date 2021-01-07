/* Written by: Michelle Martinez-Figueroa 
 * Lab 8
 * CS 272
 * March 15, 2019
 * Queue Interface
 */

public interface QueueInterface<E> {
	public void enqueue(E item);
	
	public E dequeue();
	
	public E front();
	
	public int size();
	
	public boolean isEmpty();
} // ENd class