/* Written by: Michelle Martinez-Figueroa
*  Lab 3
*  CS272
*  January 29, 2019
*  IntNode class - Linked Lists
*/
import java.util.Collections;
import java.util.LinkedList;

public class IntNode{
   private int data;
   private IntNode link;
   
   // No-argument constructor
   // No parameters
   // No return values
   // No preconditions
   public IntNode() {
      data = 0;
      link = null;
   } // END no-argument constructor
   
   
   // Constructor
   // Parameters: int data and IntNode link
   // Return:
   // Preconditions:
   public IntNode(int _data, IntNode _node) {
      data = _data;
      link = _node;
   } // END Constructor
   
   
   //Get Method to get node value
   // Parameters: None
   // Return: data value
   // Preconditions: None
   public int getData() {
      return data;
   } // END getValue accessor
   
   
   //Get Method to get node link
   // Parameters: None
   // Return: node link
   // Preconditions: None
   public IntNode getLink() {
      return link;
   } // END getValue accessor.
   
   
   // Set Method to set node value
   // Parameters: int node data
   // Return: None
   // Preconditions: None
   public void setData(int _data) {
      data = _data;
   } // END setData mutator
   
   
   // Set Method to set link
   // Parameters: link
   // Return: None
   // Preconditions: None
   public void setLink(IntNode _node) {
      link = _node;
   } // END setLink mutator
   
   
   // Method to get number of nodes in the line
   // starting from the given node head
   // Parameters: IntNode head
   // Return: int number of nodes
   // Preconditions: None
   public static int listLength(IntNode head) {
      IntNode cursor;
      int answer;
      
      answer = 0;
      for (cursor = head; cursor != null; cursor = cursor.link) {
         answer++;
      } // END for
      return answer;
   } // END listLength Method
   
   
   // toString method to return values in linked list
   // Parameters: None
   // Return: String 
   // Preconditions: None
   public String toString() {
      IntNode cursor;
      IntNode head;
      head = this;
      String s = "";
      
      for (cursor = head; cursor != null; cursor = cursor.link) { 
         s =(String) s + "->" + (cursor.data);
      } // END for
      s = s.substring(2);
      return s;
   } // END toString method
   
   
   // Add Node After This method to add a new node after a selected node
   // Parameters: int - new data to enter
   // Return: None
   // Preconditions: None
   public void addNodeAfterThis(int newdata) {
      link = new IntNode(newdata, link);
   }// END addNodeAfterThismethod
   
   
   // Method to search a linked list starting with head  contains a given value
   // Parameters: IntNode head and int type data
   // Return: boolean
   // Preconditions: head is not null
   public static boolean search(IntNode head, int data) {
      IntNode cursor;
      if (head != null) {
         for( cursor = head; cursor != null; cursor = cursor.link) {
            if (data == cursor.data) {
               return true;
            } // END inside if
         } // END for
      } // END if 
      return false;
   } // END search method
   
   
   // Remove Node After This method to remove a node after a selected node
   // Parameters: int - new data to remove
   // Return: None
   // Preconditions: None
   public void removeNodeAfterThis() {
      link = link.link;
   }// END removeNodeAfterThis method
   
   //************************************************************************************************** Past assignment
   
   
   // Method to calculate the number of even elements in linked list
   // Parameters: head
   // Return: int - number of even elements
   // Preconditions: None
   public static int listEvenNumber( IntNode head ) {
      int count;
      IntNode cursor;
      count = 0;
      //check if null
      if ( head != null ) {
         //check if even, inc count by 1
         for ( cursor = head; cursor != null; cursor = cursor.link ) {
            if ( cursor.data % 2 == 0 ) {
               count++;
            } // END if to check if even
         } // END for to check the list
      } else {
         return 0;
      } //END if - else to check if null
      return count;
   } // END list even Number method
   
   
   // Method to add node at end of list
   // Parameters: int - newdata to be entered
   // Return: None
   // Preconditions: None
   public void addToEnd(int newdata) {
      IntNode cursor;
      IntNode head;
      int i = 1;
      head = this; 
      
      if ( head == null ) {
         return;
      }//END if
      
      // for loop to advcance cursor to last element
      for (cursor = head; cursor != null; cursor = cursor.link ) {
         if (i == listLength(head) ) {
            cursor.addNodeAfterThis(newdata);
            return;
         } // END if
         i++;
      } // END cursor for
      
      
      
   } // END addToEnd method
   
   // Method to sum the last inputted number of nodes
   // Parameters: head and num of elemts to sum
   // Return: the sum of the elements - int
   // Preconditions: Head is not null
   public static int sumLast( IntNode head, int num ) {
      int length;
      int sum = 0;
      IntNode cursor;
      cursor = head;
      
      if (head == null) { return 0; }
      
      length = listLength(head);
      // if num is greater than number of nodes, add all
      if ( num > length ) {
         for ( ; cursor != null; cursor = cursor.link ) {
            sum = sum + cursor.data;
         } // END for
      } else {
         //find where to start adding
         int index = length - num;
         //loop to advance cursor to index
         for (int i = 0; i < index; i++) {
            cursor = cursor.link;
         } // END for
         //loop to sum all nodes
         for ( ; cursor != null; cursor = cursor.link ) {
            sum = sum + cursor.data;
         } // END for
      } // END if - else statement
      
      return sum;
   } // END sumLast method
   
   // Method to copy odd numbered elements starting from the inputted head
   // Parameters: None
   // Return: new IntNode with odd elements
   // Preconditions: None
   public static IntNode copyOdd ( IntNode head ) {
      IntNode copy;
      IntNode cursor;
      copy = new IntNode();
      //check if null
      if (head == null) {
         return null;
      } else {
         //check each node
         for ( cursor = head; cursor != null; cursor = cursor.link ) {
            
            // if odd, copy into IntNode copy
            if ( (cursor.getData() % 2) != 0 )  {
               if (cursor.getData() == 0) {
                  continue;
               } else {
                  copy.addNodeAfterThis(cursor.data);
               } // END if-else
            } // END if
         } // END for
         
      } // END if - else 
      return copy;
   } // END copyOdd method
   
   // Method to remove all nodes with instance of input
   // Parameters: int e - value to remove and head
   // Return: new IntNode without element
   // Preconditions: None
   public static IntNode removeAll( IntNode head, int e ) {
      IntNode cursor;
      IntNode precursor;
      precursor = head;
      cursor = precursor.getLink();
      
      //check if null
      if ( head == null ) {
         return null;
      } else {
      
         // to remove e in head
         while (head.getData() == e) {
            head = head.getLink(); 
         } // END while
         
         //To remove if match, else continue to next node
         while (cursor != null) {
            if ( cursor.getData() == e ) {
               precursor.setLink(cursor.getLink());
               cursor = cursor.getLink();
            } else {
               precursor = cursor;
               cursor = cursor.getLink();
            } // END if-else to remove
         } // END while
      } // END if-else to chek if null
      return head;
   } // END removeAll method
   
   // Method to reverse all nodes
   // Parameters: IntNode head
   // Return: reversed IntNode
   // Preconditions: None
   public static IntNode reverse (IntNode head ) {
      IntNode cursor;
      IntNode tail = new IntNode (head.getData(), null);
      IntNode temp = new IntNode (head.getData(), null);
      int i = 0;
      int length = listLength(head);
      cursor = head;
      
      // check if null
      if ( head == null ) { return null; }
      
      //for loop to set tail
      for ( ; cursor != null; cursor = cursor.link ) {
         i++;
         if ( i == length ) {
            tail.setData(cursor.data);
         } // END if  to check if last
      } // END for set tail
      
      cursor = head;
      int position = length-1;
      i = 1;
      
      
      //reverse and copy
      while (position > 0) {
         while (i <= position) {
            if ( i == position) {
               tail.addToEnd(cursor.getData());
               position--;
               //System.out.println(cursor.data);
            }
            
            cursor = cursor.getLink();
            i++;
         } // END inner while
         
         //set index and cursor back to zero to check next node
         i = 1;
         cursor = head;
      } // END while
      
      return tail;
   } // END reverse method
   
   
   // Method to detect if IntNode is cyclic or acyclic
   // Parameters: IntNode head
   // Return: true if cyclic or false if a cyclic
   // Preconditions: None
   public static boolean hasCycle(IntNode head) {
      //Create to Intnodes, initialize to head
      IntNode fast = head;
      IntNode slow = head;
      
      if ( head == null ) { return false; }
      
      //while loop to check all nodes
      while (fast != null && fast.link != null) {
         //slow advances to next node
         //fast advances 2 nodes
         slow = slow.link;
         fast = fast.link.link;
         
         //check if they are equal to eachother, return true
         if (slow == fast) {
            return true;
         } //END if
      } // END while
      return false;
   } // END hasCycle method

   
      
} // END IntNode class