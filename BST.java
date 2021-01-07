/* Written by: Michelle Martinez-Figueroa 
 * Lab 11
 * CS 272
 * April 05, 2019
 * Binary Search Tree - BST.java
 */


/**
 * The class for Binary Search Tree
 * @author Huiping Cao
 *
 */
public class BST {
	protected BSTNode root; //the tree root
	
	
	/**
	 * Get the left subtree of this tree
	 * @return the left subtree of this tree
	 */
	private BST getLeftSubtree(){
		return root.getLeft();
	}
	
	/**
	 * Get the right subtree of this tree
	 * @return the right subtree of this tree
	 */
	private BST getRightSubtree(){
      return root.getRight();
	}
	
	/**
	 * Print the tree using in-order traversal strategy
	 */
	public void inOrderPrt(){
		inOrderPrt(0);
	}
	
	/**
	 * private, recursive function
	 *     I slightly changed the method to print right subtree first
	 *     It is to make the display more easier to read
	 * 
	 * @param node
	 * @param indentation
	 * @param branch
	 */
	private void inOrderPrt(int indentation){
		if(root!=null){
			if(getRightSubtree()!=null) getRightSubtree().inOrderPrt(indentation+1);
			
			for(int i=0;i<indentation*4;i++) System.out.print(" ");
			
			System.out.println(root.getData());
			
			if(getLeftSubtree()!=null) getLeftSubtree().inOrderPrt(indentation+1);
		}
	}
	
	
	/**
	 * Debug function, print the tree for debugging purpose
	 */
	public String toString()
	{
		if(root!=null) return root.toString();
		else return null;
	}
	
	///////////////////////////////////////
    ///////////////////////////////////////
	// Please add the functions required for your lab homework here.
   
   
   /*
    * Method to insert an element into binary search tree
    * @param the element to add
    * @return false if element already exists, or true if element was added
    * @postcondition checks if element is already in tree, if not adds it
    */
   public boolean insert (int e) {
      if (root == null) {
         root = new BSTNode(e, new BST(), new BST());
      } // END if - special case
      
      if ( e == root.getData()) {
         return false;
     } // END if - data already exists
     
     if ( e < root.getData()) {
         BST temp = getLeftSubtree();
         temp.insert(e);
         
     } else if (e > root.getData()) {
         BST temp = getRightSubtree();
         temp.insert(e);
     } // END if-else if
      return true;
   } // END insert method
   
   
   
   /*
    * Method to remove an element from tree
    * @param element to remove
    * @return true if element was removed, false is element deasn't exist in tree
    * @postcondition element is removed from tree
    */
    public boolean remove (int e) {
      BST temp;
      if (root == null) {
         return false;     // empty subtree
      } // END if - special case
      
      if (e == root.getData()) {
         if (root.getLeft() == null && root.getRight() == null) { return false; }
         
         if (root.getLeft() == null && root.getRight() != null) {
            temp = getRightSubtree();
         } // END if
         
         if (root.getLeft() != null && root.getRight() == null) {
            temp = getLeftSubtree();
        } // END if
        
        if (root.getLeft() != null & root.getRight() != null) {
            int maxDataLeft = removeMax();
            root.setData(maxDataLeft);
        } // END if
     } // END if
     
     if (e < root.getData()) {
         getLeftSubtree().remove(e);
     } // END if
     
     if (e > root.getData()) {
         getRightSubtree().remove(e);
     } // END if
     return true;
    } // END remove method
    
    
    
    /*
     * Method to get and remove the largest value in the left subtree
     * @ return the max value in the left subtree
     */
     public int removeMax() {
         int maxData = 0;
         BST RT = getRightSubtree();
         if (RT == null) { 
            maxData = root.getData();
            root = getLeftSubtree().root;
         } // END if
         
         RT.removeMax();
         return maxData;
     } // END removeMax method
   
   
   
   /*
   * Method to search if an element occurs in tree
   * @param element to search
   * @return the node that contains the element
   * O(2^N)
   */
   public BSTNode searchRecursion(int e) {
      if (root == null) {
         return null;
      } // END if - special case
      
      if ( e == root.getData()) {
         return root;
     } // END if 
     
     if ( e < root.getData()) {
         BST temp = getLeftSubtree();
         temp.searchRecursion(e);
         
     } else if (e > root.getData()) {
         BST temp = getRightSubtree();
         temp.searchRecursion(e);
     } // END if-else if
      return root;

   } // END searchRecursion
   
   
   
   /*
    * Method to search for an element
    * @param element to search
    * @return Node that contains element
    */
    public BSTNode searchNonRecursion( int e) {
      BST temp = null;
      if (root == null) {
         return null;
      } // END if - special case
      
      if ( e == root.getData()) {
         return root;
     } // END if - special case
     
     //set temp
     if ( e < root.getData()) {
         temp = getLeftSubtree();
      } else if (e > root.getData()) {
         temp = getRightSubtree();
      } // END if-else
     
     //Iterate until found
      while (temp != null ) {
         //check if found
         if (temp.getData() == e) {
            return root;
         } // END if
         
         if ( e < temp.getData()) {
            temp = getLeftSubtree();
         } else if (e > temp.getData()) {
            temp = getRightSubtree();
         } // END if-else
         
      } // END while
      return null;
    } // END searchNonRecursion
    
    
    /*
     * Method to sum all elements in tree
     * @return the sum off the elements
     */
     public int sum() {
         int s = 0;
         BST temp = root;
         s = s + temp.getData();
         temp = getLeftSubtree();
     } // END sum   
   
	/**
	 * Test cases provided by the instructor
	 * @throws Exception
	 */
	private static void test1() throws Exception{
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		
		boolean rc = true;
		
		//test 1: insert method, and test 2 in-order traversal
		rc = tree.insert(12); System.out.println("\nInsert 12, inserted="+rc+", after adding 12:"); tree.inOrderPrt();
		rc = tree.insert(6);  System.out.println("\nInsert 6, inserted="+rc+", after adding 6:"); tree.inOrderPrt();
		rc = tree.insert(19); System.out.println("\nInsert 19, inserted="+rc+", after adding 19:"); tree.inOrderPrt();
		rc = tree.insert(4);  System.out.println("\nInsert 4, inserted="+rc+", after adding 4:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8, inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(16); System.out.println("\nInsert 16, inserted="+rc+", after adding 16:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8 (second), inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(5);  System.out.println("\nInsert 5, inserted="+rc+", after adding 5:"); tree.inOrderPrt();
		rc = tree.insert(9);  System.out.println("\nInsert 9, inserted="+rc+", after adding 9:"); tree.inOrderPrt();
		rc = tree.insert(20);  System.out.println("\nInsert 20, inserted="+rc+", after adding 20:"); tree.inOrderPrt();
		
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
		// //test 3: search method
		BSTNode node = tree.searchRecursion(6);
		System.out.println("searchRecursion 6, node="+node);
		node = tree.searchRecursion(22);
		System.out.println("searchRecursion 22, node="+node);
		node = tree.searchRecursion(8);
		System.out.println("searchRecursion 8, node="+node+"\n");
		
		node = tree.searchNonRecursion(6);
		System.out.println("searchNonRecursion 6, node="+node);
		node = tree.searchNonRecursion(22);
		System.out.println("searchNonRecursion 22, node="+node);
		node = tree.searchNonRecursion(8);
		System.out.println("searchNonRecursion 8, node="+node);
		
		//test 4: remove method
		rc = tree.remove(30); //test case 0: e does not exist
		System.out.println("\nRemove 30, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(20); //test case 1: leaf
		System.out.println("\nRemove 20, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(4); //test case 2: left is empty
		System.out.println("\nRemove 4, rc="+rc);
		tree.inOrderPrt();
		
		
		rc = tree.remove(19); //test case 3: right is empty
		System.out.println("\nRemove 19, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(6); //test case 4: no subtree is empty
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(12); //more tests: remove root
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(5); //more tests
		System.out.println("\nRemove 5, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		rc = tree.remove(16); //more tests
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();

		
		System.out.println("\nAdding a series of numbers:");
		tree.insert(30);
		tree.insert(20);tree.insert(10);tree.insert(25);tree.insert(28);tree.insert(24);
		tree.insert(11);tree.insert(5);tree.insert(11);tree.insert(12);
		tree.insert(50);tree.insert(40);tree.insert(35);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.print("sum="+tree.sum()+"\n");
		System.out.print("\n\n");
		
		System.out.println("\nRemove 20 (removeNode case 4):");
		tree.remove(20);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("Inorder traversal results: ");
		tree.inOrderPrt();
		System.out.print("\n");
		System.out.print("sum="+tree.sum()+"\n");
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//You need to let your program pass the  test cases in this function
		test1(); 
		
		//You can add your own test cases here. 
		
	}

}