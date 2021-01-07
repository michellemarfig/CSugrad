/* Written by: Michelle Martinez-Figueroa
*  Lab 7 - Generic Programming
*  CS272
*  March 1, 2019
*  SNode class
*/

public class SNode<E> extends LinkedQueue<E> {
	E data;
	SNode<E> link;
	
	/*
	 * No-argument constructor
	 * @ postcondition set data to 0 and link to null
	 */
	public SNode() {
		data = null;
		link = null;
	} // END no-argument constructor
	
	
	/*
	 * Constructor
	 * @param data to be added, and link
	 * @postcondition data is set to _data and link is set to _link
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SNode(E _data, SNode _link ) {
		data = _data;
		link = _link;
	} // END constructor
	
	
	//SNode<E> newHead = new SNode<E> (e, head);
	
	/*
	 * Accessor method to get data
	 * @return data
	 */
	public E getData() {
		return data;
	} // END getData
	
	
	/* 
	 * Accessor method to get link
	 * @return link
	 */
	public SNode<E> getLink() {
		return link;
	} // END getLink
	
	/*
	 * Mutator method to set data
	 * @param data to be set
	 * @postcondition parameter is set to data
	 */
	public void setData(E _data) {
		data = _data;
	} // END setData
	
	/*
	 * Mutator method to set link
	 * @param link to be set
	 * @postcondition parameter is set to link
	 */
	public void setLink(SNode _link) {
		link = _link;
	} // END setData
	
	
	/*
	 * Method to get length of list
	 * @param head
	 * @return length of list
	 */
	public int listLength() {
		SNode<E> cursor;
		int count = 0;
		
		for ( cursor = this; cursor != null; cursor = cursor.link) {
			count++;
		} //END for
		return count;
	}// END listLength method
		
	
	
	/*
	 * Method to add element to queue
	 * @param element to add
	 * @postcondition element will be places on top of stack
	 */
	public void addEnd(E newData) {
		SNode newBackNode = new SNode(newData, null);
      SNode cursor = this;
      
      for(; cursor.link != null; cursor = cursor.getLink()) {;} // END for
      cursor.setLink(newBackNode);
	} // END add method
	
	
	
	
} // END class