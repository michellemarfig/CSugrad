// Written by: Michelle Martinez-Figueroa
// April 17, 2019
// Lab 10 - make motor turn to photosensor with more power, if too close, stop the motor

#include <avr/interrupt.h>
#include <IRremote.h> // Library for remote sensing
int receiver = 10; // PB2 or Digital pin 10 used for remote sensing
IRrecv irrecv(receiver);  // create instance of 'irrecv'
decode_results results;   // create instance of 'decode_results'

long start_time;
long totduration;
byte left;  // to store left photosensor value
byte right; //to store right photosensor value
unsigned char * onechar; // Used for int to byte conversion
int remotevalue; // Used for int to byte conversion
byte lastcommand; // If the current command is equivalent to the last command, do nothing!!
extern byte remotecommand[]; // The array we would be sharing with AVR
extern byte command; // Used to return the command for the respective remote signal
extern byte pinbstate;

extern "C" {
  void ultrasensor(); //ultrasonic sensor function
  void readPINBState(); //utrasonic read chanes in bit
  void initAD();  // photosensor setup
  byte readAD(byte i);  //photosensor read; param is the pin number that you want to read
  void control();
  void controlMotor();
  void turnoffmotor();
  void turnonclockwise();
  void turnoncounterclockwise();
  void setupMotor();
  void turnonlight();
  void turnofflight();
}

void setup()
{
   
  Serial.begin(9600);
  setupMotor();
  irrecv.enableIRIn(); // enable the IR pin connected to PB2 or digital pin 10
  initAD();           //call assembly init A/D routine
  
  /*
   * Set the bits of the appropriate PCMSKx register high
   * to enable pin change detection on PB1 (port b pin 1). 
   * PCINT1 in our case.
   */
  PCMSK0 = (1<<PCINT1);

  // Enable the corresponding vector, PCIE0 in our case.
  PCICR = (1<<PCIE0);

  // Enable the interrupt flag
  sei();
  
}

void loop()
{
  ultrasensor();  

      readPINBState();

   if(pinbstate == 1)
    start_time = micros();

   if(pinbstate == 0)
   {
     // figure out total time,
     totduration = micros() - start_time;
//     long q2 = totduration - micros();
//     Serial.println(totduration, DEC);
//     Serial.println(q2, DEC);
     // determine a safe distance (like 5 inches)
     // print out "Save Distance"  or "Too close" based on your science
     if (totduration < 688) {
        Serial.println("Too close");
        turnoffmotor();
     } else {
        //Serial.println("Safe Distance");
        left = readAD(0);
        right = readAD(1);

        Serial.print("Left: ");
        Serial.println(left, DEC);
        Serial.print("Right: ");
        Serial.println(right, DEC);

        if ( left > right) {
          if ( (left - right) < 10 ) {
            turnoncounterclockwise();
           } // END if
        } else if ( right > left) {
          if ((right - left) < 10) {
             turnonclockwise();
           } // ENd if
          Serial.println();
        }

      // *************************************************motor controller

     } // END
   }


  
  delay(1000); // delay a second
}

/*
 * The interrupt service routine that would activate on 
 * a value change of PB1
 */
ISR(PCINT0_vect)
{
  /* The echo pin is changed twice
   * 1. First echo pin is set, this is when the echo is sent,
   * record start time in microseconds
   * 2. Then echo pin is cleared, this is when the echo came
   * back, record the end time now.
   */
    // ***************************************************ultrasonic sensor
   // Read the pin b state to know if its 0 or 1



     
   }

