//Written by: Michelle Martinez-Figueroa
// CS 273
// March 19, 2019
// Lab 7 - Analog to Digital Conversion


extern "C" { void initAD(); }
extern "C" { byte readAD(byte i); }


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  initAD();           //call assembly init A/D routine
} // END setup

void loop() {
  // put your main code here, to run repeatedly:
  byte v;
  v = readAD(2);         // call assembly read sensor routine, A/D pin #2         
  Serial.print(" light = ");    
  Serial.println(v,HEX);    
  delay(1000);          // delay one second 
} // END loop
