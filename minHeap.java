// Written by: Michelle Martinez
// April 29, 2019
// lab 13 - Heaps
// MinHeap class

public class minHeap<E> extends ArraylistStack<E> {
   private ArraylistStack heap;
   
   /*
    * No argument constructor(E[]) new Object[1];
    * @postcondition data is initiated   
    */
   public minHeap() {
      heap = new ArraylistStack();
   } // END constructor
   
   
   
   /*
    * Method to add a new element into the heap
    * @param element to add
    * @postcondition element is added to heap
    */
   public void add( E e ) {
      push(e);
      reheapUp(0); // FIxME!! shuld be int pos
    } // END add method
    
    
    
    /*
     * Method to remove the top element
     * @return the top element
     * @postcondiditon top element is remove, and reheap[ification occurs 
     */
    public E remove() {
      E min = pop();
      reheapDown();
      return min;
     } // END remove method
    
    
    
    /*
     * Method to get top element of stack
     * @return the top element
     */
    public E top() {
      E min = top();
      return min;
    } // END top method
    
    
    /*
     * Method to print the heap
     * @postcondition heap is printed
     */
    public void print() {
      System.out.println(toString());
    } // END toString
    
    
    
    /*
     * Method to reheap the last element up into the correct spot
     * @postcondition last element is reheaped up recursively
     */
    public void reheapUp(int pos) {
      if (pos <= 0) {
         return;
      } // END if
      
      int parentPos = getParentPos(pos);
      E temp;
      
      // is larger than parent, swap
      if (data[pos] > data[parentPos]) {
         temp = data[pos];
         data[pos] = data[parentPos];
         data[parentPos] = temp;
         reheapUp(parentPos);
      } // END if
    } // END reheapUp
    
    
    
    /*
     * Method to reheap the top element down into the correct spot
     * @postcondition last node is made top and then the element
     *    is reheaped down recursively
     */
    public void reheapDown() {
    
    } // END reheapDown
    
    
    /*
     * Method to get position of left child
     * @return position
     */
    public int getLeftPos(int i) {
      if ( i < 0) {
         System.out.println("Position has to be 0 or greater.");
         return -1;
      } // END if
      if ( i > data.length) {
         System.out.println("This position is not in this tree.");
         return -1;
      } // END if
      
      i = 2 * (i+1);
      return i;
    } // END getLeftPos method
    
    
    
    /*
     * Method to get position of right child
     * @return position
     */
    public int getRightPos(int i) {
      if ( i < 0) {
         System.out.println("Position has to be 0 or greater.");
         return -1;
      } // END if
      if ( i > data.length) {
         System.out.println("This position is not in this tree.");
         return -1;
      } // END if
      
      i = 2 * (i+2);
      return i;
    } // END getLeftPos method
    
    
    
    /*
     * Method to get position of parent
     * @return position
     */
    public int getParentPos(int i) {
      if ( i <= 0) {
         return -1;
      } // END if
      if ( i > data.length) {
         System.out.println("This position is not in this tree.");
         return -1;
      } // END if
      
      int floor = getFloor();
      i = floor * ( ( i-1 ) / 2 );
      return i;
    } // END getLeftPos method
    
    
    
    /*
     * Method to get position of largest child
     * @return position
     */
    public int getLargerChildPos(int i) {
      if ( getLeftPos() >= size() ) {
         return -1;
      } // END if
      
      if (getRightPos() >= size() ) {
         return getLeftPos();
      } // END if
      
      if (getLeftPos() > getRightPos() ) {
         return getLeftPos();
      } // END if
      return rightPos;
    } // END getLeftPos method
    
    
    /* 
     * Method to get level of floor
     * @return level number
     */
    public int getFloor() {
      int floor = 0;
      int parent = getParentPos();
            
      for ( int i = 0; i < data.length; i++) {
         
      } // END for
      return -1;
    } // END getFloor
    
} // END class