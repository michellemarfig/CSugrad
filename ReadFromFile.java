import java.util.*;
import java.io.*;
public class ReadFromFile {
public static void main (String args[]) throws IOException {
String inputLine;
int lineCount = 0;
Scanner fileScan = new Scanner(new File("bowl1.txt"));
while (fileScan.hasNext()) {
inputLine = fileScan.nextLine();
// print the line that we just got from the file
System.out.println(inputLine);
// count the input line
lineCount++;
} // end while
System.out.println("I read " + lineCount + " lines from the file.");
} //end main
} // end class