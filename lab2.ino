
//
// Declare the things that exist in our assembly code
//

extern byte x1, x2, x3;
extern "C" void addition(void);

//
// function to read a 2-digit decimal value from user
//
byte readHexValue()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit hex value:");
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  
  // pickup letters and convert to decimal
  switch (inch) {
    case 'a': case 'A': inch = 10; break;
    case 'b': case 'B': inch = 11; break;
    case 'c': case 'C': inch = 12; break;
    case 'd': case 'D': inch = 13; break;
    case 'e': case 'E': inch = 14; break;
    case 'f': case 'F': inch = 15; break;
  } // END switch

  //Base 16
  val = inch * 16;

  while (!Serial.available()) delay(100);
  inch = Serial.read();

  // pickup letters and convert to decimal
  switch (inch) {
    case 'a': case 'A': inch = 10; break;
    case 'b': case 'B': inch = 11; break;
    case 'c': case 'C': inch = 12; break;
    case 'd': case 'D': inch = 13; break;
    case 'e': case 'E': inch = 14; break;
    case 'f': case 'F': inch = 15; break;
  } // END switch

  // add values
  val = val + inch;
  Serial.print("The value entered in HEXADECIMAL is ");
  Serial.println(val,HEX);
  Serial.print("The value entered in DECIMAL is ");
  Serial.println(val,DEC);
  return (byte) val;
}

//
// Arduino-required setup function (called once)
//
void setup()
{
  // To turn off LED
  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);
  //
  // Initialize serial communications
  //
  Serial.begin(9600);
  //
  // Read three values from user, store in global vars
  //
  x1 = readHexValue();
  x2 = readHexValue();
  x3 = readHexValue();
  //
  // Call our assembly code
  //
  addition();
  //
  // Print out value of x3 variable
  //
  Serial.println("After addition()");
  Serial.print("The value is ");
  Serial.println((int) x3,HEX);
  Serial.println((int) x3,DEC);
}

//
// Arduino-required loop function (called infinitely)
// - this just prints a '*' on the serial comm output
//   once every 20 seconds, forever
//
void loop()
{
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}

