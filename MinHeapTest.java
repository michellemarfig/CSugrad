// Written by: Michelle Martinez
// April 29, 2019
// lab 13 - Heaps
// MinHeap Testing

public class MinHeapTest {
   public static void main(String[] args) {
      //Testing add method
      System.out.println("Testing add method:");
      minHeap t1 = new minHeap();
      t1.add(1);
      System.out.println();
     
      System.out.println("Testing print method:");
      t1.print();
      System.out.println();
      
      System.out.println("Adding 5, 10, 8, and 60 to the heap:");
      t1.add(5);
      t1.add(10);
      t1.add(8);
      t1.add(60);
      
      
      
      
   } // END main
} // END class