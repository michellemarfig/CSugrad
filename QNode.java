/* Written by: Michelle Martinez-Figueroa 
 * Lab 8
 * CS 272
 * March 15, 2019
 * Linked Queue for Linked Queue
 */

public class QNode<E> extends LinkQueue<E> {
	private E data;
	private QNode link;
	
	
	/*
	 * No-argument constructor
	 * @postcondition data is set to 0, and link is set to null
	 */
	public QNode() {
		data = 0;
		link = null;
	} // END QNode
	
	
	
	/*
	 * Mutator to set data value
	 * @param item 
	 * @postcondition data is set to item
	 */
	public void setData(E _data {
		data = _data;
	} // END setData
	
	
	
	/*
	 * Mutator to set link value
	 * @param link
	 * @postcondition link is set to item
	 */
	public void setLink(QNode _link) {
		link = _link;
	} // END getLink
	
	

	/*
	 * Accessor to get data value
	 * @return data
	 */
	public SNode getLink() {
		return data;
	} // END getLink
	
	
	
	/*
	 * Accessor to get link value
	 * @return link
	 */
	public SNode getLink() {
		return link;
	} // END getLink
	
	
	/*
	 * Method to add node after head
	 * @param item to add
	 * @postcondition item is addded after head
	 */
	public void addNodeAfterThis(E _data) {
		link = new SNode(_data, link);
	} // addNodeAfterThis
	
	
	
	/*
	 * Method to get length of list
	 * @return the size of list
	 */
	public int listLength() {
		int length;
		SNode cursor = 0;
		
		for ( cursor = this; cursor != null; cursor = cursot.getLink()) {
			length++;
		} // END for
		return length;
	}// END listLength
	
	
	
} // END QNode