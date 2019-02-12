/* 
*  Written by: Michelle Martinez-Figueroa
*  Lab 1
*  CS272
*  January 29, 2019
*  Book class and testing
*/

class Book{

	private String bookTitle;
	private int numAuthors;
	private String[] authors = new String[3];
	private String isbn;
	
   //Default Constructor
	public Book() {					// #1
		bookTitle = null;
		isbn = null;
		numAuthors = 0;
		authors = new String[3];
	} //END Default Constructor
	
   //Book Title Constructor
	public Book(String _title) { 	// #2
		bookTitle = _title;
		isbn = "null";
		numAuthors = 0;
		authors = new String[2];
	} // END constructor to set book title
	
     
   //Copy Constructor
	public Book(Object obj) {		// #3
      //If object is not null
		if (obj != null) {
         Book answer;
         answer = (Book)obj;
         answer.bookTitle = bookTitle;
			answer.numAuthors = numAuthors;
			answer.authors = authors;
			answer.isbn = isbn;
			return;
		} // if statement to check if null
		
	} // END Copy Constructor
	
	public String getTitle() {		// #4
		return bookTitle;
	} // END get Title Accessor
	
	public int getAuthorNumber() {	// #5
		return numAuthors;
	} // END get Author Num Accessor
	
	public String getISBN() {		// #6
		return isbn;
	}// END get ISBN Accessor
	
	public void setTitle(String _title) {	//#7
		bookTitle = _title;
	} // END setTitle Mutator
	
	public void setISBN(String _isbn) {			// #8
		isbn = _isbn;
	} // END setISBN mutator
  	
	public boolean addAuthor(String _author) {	// #9
		// loop to check if next spot in array is empty
      for (int i = 0; i <= 2; i++) {
			// if empty, add authors name & increase counter
         if (authors[i] == null) {
				authors[i] = _author;
				numAuthors++;
				return true;
			} else {
				continue;
			} // END if-else 
		} // END for loop
		return false;
	} // END addAuthor method
	
   
   //Method to check if 2 object's isbn are the same
	public boolean equals(Object obj) {		            // #10
		if ( (obj instanceof Book) && (obj != null) ) {
         Book answer;
         answer = (Book)obj;
			return ( (answer.bookTitle == bookTitle) && (answer.numAuthors == numAuthors)
                        && (answer.authors == authors) && (answer.isbn == isbn) );
		} else {
			return false;
		} // END if-else
	} // END Equals Method 
	
   
   //Method to print all authors of 2 books
	public static void getAllAuthors(Book b1, Book b2) {	// #11
		//if not null
      if ( (b1 != null) && (b2 != null)) {
      
         //Get number of authors
		   int first = b1.getAuthorNumber();
		   int second = b2.getAuthorNumber();
         
         //Create a String array
         String[] allAuthors = new String[first + second -1];
         
			//for loop to add all authors in array
			for (int i = 0; i < allAuthors.length; i++) {
				if(i < first) {
					allAuthors[i] = b1.authors[i];
				} else {
					allAuthors[i] = b2.authors[i];
				} // END if-else
         } // END for
                  
         //for loop to print authors
         for(int i = 0; i < allAuthors.length;i++) {
            System.out.print(allAuthors[i] + " ");
         } // END for
      
		} // END if
	 // END getAllAuthors Accessor 
	
   } //toString method to print out book info
	public String toString() {		// # 12
      String s = "";
      //if statements to check which string should be printed
      if ( numAuthors == 0) {
         s = "Title: " + bookTitle + " ISBN: "
				+ isbn + " Number of Authors: " + numAuthors+
            " Authors: ";
      } // end if
   
      if ( numAuthors == 1) {
         s = "Title: " + bookTitle + " ISBN: "
				+ isbn + " Number of Authors: " + numAuthors+
            " Authors: " + authors[0];
      } // end if
   
      if ( numAuthors == 2) {
         s = "Title: " + bookTitle + " ISBN: "
				+ isbn + " Number of Authors: " + numAuthors+
            " Authors: " + authors[0] + " & " + authors[1];
      } // end if
   
      if ( numAuthors == 3) {
         s = "Title: " + bookTitle + " ISBN: "
				+ isbn + " Number of Authors: " + numAuthors+
            " Authors: " + authors[0] + " & " + authors[1] +
              " & " + authors[2];
      } // end if
      
      return s;
	} //END  toString method
	
   //Here is main method
	public static void main(String[] args) {	// #13
      // Testing no-argument constructor
      Book b1 = new Book();
      System.out.println(b1.toString());
      
      //Testing Constructor for Book Title
      Book b2 = new Book("Hello");
      System.out.println(b2.toString());
      
      //Testing copy constructor
      
      //Testing equals
      
      // Testing get and setTitle
      b1.setTitle("Java");
      String s = b1.getTitle();
      System.out.println(s);
      
      //Testing add Authorand get author number
      b2.addAuthor("Ben");
      b2.addAuthor("Jerry");
      int i = b2.getAuthorNumber();
      System.out.println(b2.toString());
      
      //Testing set ISBN
      b1.setISBN("0123456789");
      System.out.println(b1.toString());
      
      //Testing getAllAuthors
      getAllAuthors(b1, b2);
      
	} // END main
	
} // end class