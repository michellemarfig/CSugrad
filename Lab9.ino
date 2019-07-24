// Written by: Michelle Martinez-Figueroa
// April 17, 2019
// Lab 9 - UltraSonic Sensor


/* 
 *  1)  Take 5 different distance measurements noting the exact distance.  Report these values. 
 *  
 *          156 at 1 inch
 *          208 at 2 inch
 *          308 at 3 inch
 *          552 at 4 inch
 *          804 atn6 inch
 *          

2)  Calculate how many microseconds one foot is.  Show your work

           1716 - micros() = answer

3)  What is the minimum and maximum effective measuring distance of the device?  Provide a link along with your answer

            1” to 13 feet.
            https://www.tutorialspoint.com/arduino/arduino_quick_guide.htm
            
4)  Is it possible for our ISR to be interrupted with another PINB, pin 1 state change? 

        No the code has to run until it is finished before another interupt can be processed.
 */



#include <avr/interrupt.h>
long start_time;
long totduration;
extern byte pinbstate;

extern "C" {
  void ultrasensor();
  void readPINBState();
}

void setup()
{
  Serial.begin(9600);
  
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

   // Read the pin b state to know if its 0 or 1
   readPINBState();

   if(pinbstate == 1)
    start_time = micros();

   if(pinbstate == 0)
   {
     // figure out total time,
     totduration = micros() - start_time;
     long q2 = totduration - micros();
     
     Serial.println(totduration, DEC);
     Serial.print("Q2 ");
      Serial.println(q2, DEC);
     // determine a safe distance (like 5 inches)
     // print out "Save Distance"  or "Too close" based on your science
     if (totduration < 688) {
        Serial.println("Too close");
     } else {
        Serial.println("Safe Distance");
     }
   }
}

