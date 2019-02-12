/* Written by: Michelle Martinez-Figueroa
*  Lab 1
*  CS272
*  January 29, 2019
*  Book class and testing
*/

import java.util.Arrays;
public class StringSet { 
	private int capacity;
	private int numItems;
	private String[] data;
	private int index;
	private int i;
   
	/*
   * No-Argument constructor
   */
	public StringSet() {
		capacity = 2;
		data = new String[capacity];
	} // END no-argument constructor.
	
	/* Constructor
    * @author
    * Michelle Martinez-Figueroa
	 * @precondition
	 * Capacity is non-negative.
    * @param
    * capacity type integer
	 */
	public StringSet(int _capacity) {
		if (_capacity > 0) {
			capacity = _capacity;
			data = new String[capacity];
		} // END if
	} // END constructor
	
	/*Copy Constructor
    * @author
    * Michelle Martinez-Figueroa
	 * @precondition
	 * Obj is not null and instance of StringSet.
    * @param
    * Object
	 */
	public StringSet(Object obj) {
		if ( (obj != null) && (obj instanceof StringSet) ) {
			StringSet answer;
			answer = (StringSet)obj;
			answer.numItems = numItems;
			answer.capacity = capacity;
			answer.data = new String[capacity];
			for (i = 0; i < capacity; i++) {
				answer.data[i] = data[i];
			} //END for	
		} // END if statement
	} // END Copy Constructor
	
	/* 
    * @autor
    * Michelle Martinez-Figueroa
    * Method to return number of elements in array 
    */
	public int size() {
		return numItems;
	} // END size function
	
	/*Method to get capacity
    * @author
    * Michelle Martinez-Figueroa
    */
	public int capacity() {
		return data.length;
	} // END capacity function
	
	/*Method to add element to array
    * @author
    * Michelle Martinez-Figueroa
	 * @precondition
	 * a is not null
    * @param String to add
	 */
	public void add(String a) {
		//Ensure there is twice as much space as needed & copy contents
      if (a != null) {
			if (capacity == data.length) {
				ensureCapacity(capacity * 2 + 1);
			} // END if statement
		} // END if statement
      
      for (i = 0; i < capacity; i++) {
         if (data[i] == null ) {
            data[i] = a;
            numItems++;
            i = capacity + 1;
         } // END if
      } // END for
   }//END add method
   
   /*Method to remove element to array
    * @author
    * Michelle Martinez-Figueroa
	 * @precondition
	 * a is not null
    * @param String to remove
	 */
   public boolean remove(String a) {
      if ( a == null ) {
         return false;
      } else {
         for( i = 0; i < capacity; i++) {
            if (data[i].equals(a)) {
               data[i] = null;
               return true;
            } // END if
         } // END for
      } // END if-else
      return false;
   } // END remove method
	
	/* Method to check if input is already in collection
    * @autor
    * Michelle Martinez-Figueroa
	 * @param
    / String to compare
	 */
	public boolean contains( String a ) {
		if ( a == null ) {
			return false;
		} else {
			for (i = 0; i < capacity; i++) {
				if(data[i].equals(a)) {
					return true;
				}// END if
			} // END for
			if ( index == -1 ) {
				return false;
			} // END inside if
      } // END if-else
      return false;
	} // END contains method
	
	/* Method to  guarantee capacity of collection
    * @autor
    * Michelle Martinez-Figueroa
	 * @precondition
	 * input parameter must be positive
    * @param
    * integer type of minimum capacity needed
	 */
	private void ensureCapacity( int minimumCapacity ) {
		if ( minimumCapacity > 0 ) {
			String[] biggerArray;
			
			if ( data.length < minimumCapacity) {
				biggerArray = new String[minimumCapacity];
				System.arraycopy(data, 0, biggerArray, 0, numItems);
				data = biggerArray;
			} else {
				return;
			} //  END if-else 
		} // END if
	} // END ensureCapacity method
	
   /* Method to  guarantee capacity of collection
    * @autor
    * Michelle Martinez-Figueroa
	 * @precondition
	 * input parameter must not be null
    * @param
    * String to add
	 */
	public void addOrdered( String a ) {
		if ( a != null) {
			ensureCapacity((data.length + 1) * 2);
			Arrays.sort( data );
		} // END if
	} // END addOrdered method
	
   /* Method to print
    * @autor
    * Michelle Martinez-Figueroa
	 */
	public void print() {
		String s = "";
		for (i = 0; i < data.length; i++) {
			//if ( data[i] != null) {
            System.out.print(data[i] + " ");
         //} // END if
 		} // END for
      System.out.println();
	} // END toString method
	
   /* Main to Test StringSet class
    * @autor
    * Michelle Martinez-Figueroa
	 */
	public static void main(String[] args) {
		//Testinf no-argument constructor & constructor
		StringSet t1 = new StringSet(3);
		StringSet t2 = new StringSet();
		StringSet t3 = new StringSet();
		
		//Testing add method
		System.out.println("Testing add method");
		t1.add("Hello");
		t1.add("Hi");
		t1.add("Hola");
      t2.add("abcdef");
      t2.add("CS");
      t2.add("012345");
      System.out.println("This is t1:");
		t1.print();
      System.out.println("This is t2:");
      t2.print();
      //System.out.println("Testing copy constructor");
      //StringSet t3 =  new StringSet(t2);
      //t3.print();
      
      System.out.println("Testing size method");
		int i = t1.size();
      System.out.println("t1: " +i);
      i = t2.size();
      System.out.println("t2: " +i);
		
      //Testing capacity method
      System.out.println("Testing capacity method");
		i = t1.capacity();
      System.out.println("t1: " +i);
      i = t2.capacity();
      System.out.println("t2: " +i);
      
      // Testing contains method
      System.out.println("Testing contains method");
      System.out.println("Testing t1 with \"Hello\": " + t1.contains("Hello") );
      System.out.println("Testing t2 with \"Hello\": " + t2.contains("Hello") );
      
      // Testing remove method
      System.out.println("Testing remove method:");
      System.out.println("Removing \"Hello\" from t1: " + t1.remove("Hello"));
      t1.print();
      System.out.println("Removing \"CS\" from t2: " + t2.remove("CS"));
      t2.print();
      
      //Testing ensure Capacity method
      System.out.println("ensure Capacity worls because add function works!");
      
      //Testing ddOrderedmethod
      t1.add("Blue");
      t1.add("Red");
      t1.addOrdered("Green");
      System.out.println("Testing addOrdered method:");
      t1.print();
      
	}// END Main
	
   
} // END StringSet class