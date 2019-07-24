// Written by: Michelle Martinez-Figueroa
// Lab 8 - Motor Controller with Remote Control
// April 11, 2018

#include <IRremote.h> // Library for remote sensing
int receiver = 10; // PB2 or Digital pin 10 used for remote sensing
IRrecv irrecv(receiver);  // create instance of 'irrecv'
decode_results results;   // create instance of 'decode_results'

/*
 * The signal received from the remote is a 24 bit value and thus needs to be stored as an integer that is 4 bytes (32 bits),
 * however, since our AVR likes bytes more than int we will convert 'int' to 'byte[4]'. Also, only the last 2 bytes are important for 
 * us and ** don't forget that we working on a little endian system **.
*/

extern byte remotecommand[]; // The array we would be sharing with AVR
unsigned char * onechar; // Used for int to byte conversion
int remotevalue; // Used for int to byte conversion
extern byte command; // Used to return the command for the respective remote signal
byte lastcommand; // If the current command is equivalent to the last command, do nothing!!

extern "C" {
  void control();
  void controlMotor();
}

void setup() {
  Serial.begin(9600); // Begin serial communication
  irrecv.enableIRIn(); // enable the IR pin connected to PB2 or digital pin 10
  //control();
}

// This loop reads from the IR receiver and places the byte codes generated by the receiver.
//  There are unique pairs of bytes for each button pressed.
//  The goal is to determine the byte pairs for the keys we want to use and then
// to have AVR run the specific subcommands and provide back via the "command" shared variable
//  what was selected so that we can put something to the Serial screen

void loop() {

  lastcommand = command;
  if (irrecv.decode(&results)) // have we received an IR signal?
  {
    Serial.println("Signal Recived!");
    remotevalue = results.value;
    for(size_t i=0; i<2; i++) // We only need the last 2 bytes.
    {
      onechar = (unsigned char *)(&remotevalue); // convert the base address of integer 'remotevalue' to an unsigned char address
      onechar = onechar + i; // Add the offset to get the respective byte
      remotecommand[i] = *onechar; // Store the byte into 'remotecommand'
    }
    delay(1000); // To avoid signal interference
    irrecv.resume(); // receive the next value
  }

  // FIX, use Serial.print() to figure out what the upper and lower bytes of the Remote you pressed here
  Serial.println(remotecommand[0], HEX);
  Serial.println(remotecommand[1], HEX);
  delay(1000);
  
  controlMotor();  // FIX -- incomment this when you get your controller working
  if(lastcommand != command) // This will make sure that the same command is not printed multiple times as the 'results' remembers the last signal until it receives a new one
  {
    
     switch((char)command)
     {
      case '>':
        Serial.println("Moving motor in clockwise direction!!");
        Serial.print(command);
        break;
      case '<':
       Serial.println("Moving motor in counter clockwise direction!!");
        break;
      case '!':
        Serial.println("Stopping motor!!");
        break;
      case '^':
        Serial.println("Turn on LED!!");
        break; 
      case 'v':
       Serial.println("Turn off LED!!");
        break;
       default:
         Serial.println("Unknown Command");
      }
   }
}

