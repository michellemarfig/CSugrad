// Written by: Michelle Martinez-Figueroa
// CS 273
// February 7, 2019
// Lab3
// Fat Monitor
//
//QUESTIONS:
// My code already runs in decimal values, not HEX
//Gender:   Age:    Fat:    Light
// F        42        32      green
// M        25        30      all lights
// F        30        21      blue
// M        23        17      green


// Declare the things that exist in our assembly code
//

extern byte sex;
extern byte age;
extern byte fat;

extern "C" {   
  void lightup();
}

//
// function to read a 2-digit HEX value from user
//function to read sex Value
byte readSex()
{
  byte inch; int val;
  Serial.println("Enter 01 for FEMALE or 02 for MALE:");
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

// function to read age value
byte readAge()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value for AGE:");
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

// function to read fat value
byte readFat()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value for FAT:");
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

//
// Arduino-required setup function (called once)
//
void setup()
{
  //
  // Initialize serial communications
  //
  Serial.begin(9600);
  //
  // Read 3 values from user
  //
  sex = readSex();
  age = readAge();
  fat = readFat();
  //
  // Call our assembly code!! :)
  //
  lightup();
}

//
// Arduino-required loop function (called infinitely)
//

void loop()
{
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}

