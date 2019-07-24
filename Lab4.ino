//Written by: Michelle Martinez-Figueroa
// CS 273
// February 21, 2019
// Lab 4 
// Decoding Morse Code



extern byte val;
extern byte width;
extern char ascii;

extern "C" { 
  void decode_morse();
  void goaggies();
}

//
// function to read a 2-digit decimal value from user
//
byte read2DigitValue()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value:");
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val = (inch - '0') * 10;
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val += (inch - '0');
  Serial.print("The value entered is ");
  Serial.println(val,DEC);
  return (byte) val;
}

void flashGoAggies() 
{
  
val = read2DigitValue();
goaggies();
  // You will call the GoAggies() function from assembly file GoAggies.S
}

void decodeMorse(const String & string, char message[])
{
  // Write your code below.
  // string contains the input binary string separated by single spaces
  // message contains the decoded English characters and numbers    
  // You will call the assembly function decode_morse()
  
  
  int j =0; //to hold location of message
  val = 0;
  width = 0;
  
  
  
  for (int i=0;i<string.length();i++) {
     
      if (string[i] == '1') {      // if 1
        val = val * 2 + 1;
        width++;
      }// END if


      if (string[i] == '0') {     // if 0
        val = val * 2;
        width++;
      } // END if

      
      if(string[i]==' '){       // if space
        decode_morse();
        message[j]= ascii;
        width = 0;
        val = 0;
        j++;
      } // END if
    } // END for  


    if ( val > 0 || width > 0 ) // if last word(no space)
     {
        decode_morse();
        message[j]= ascii;
        j++;
     } // ENd if
    
    message[j]=0;
     
        
 } //
// END decode morse function



void decodeMorse() 
{
  Serial.println("Input a Morse code string (separate the code for characters by a space):");

  while (!Serial.available()) delay(100);
  String string = Serial.readString();

  Serial.print("The Morse code string is: ");
  Serial.println(string);

  
  char message[100];

  decodeMorse(string, message);

  if(strlen(message) > 0) {
    Serial.print("The decoded message is: ");
    Serial.println(message);
  } else {
    Serial.print("Failure in decoding the input Morse code\n");
  }  
}

void setup() {
  //
  // Initialize serial communications
  //
  Serial.begin(9600);

  flashGoAggies();

  decodeMorse();
 
  
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}
