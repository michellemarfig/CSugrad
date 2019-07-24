// Shaun Cooper
// 2018
// simple example of recursion

// set up connect to AVR code

extern "C" { int recur(int);}

void setup() {
  
  
  // put your setup code here, to run once:
  int v;
  Serial.begin(9600);
  v=recur(1);
  Serial.print("The summation is ");
  Serial.println(v);
  
  

}

void loop() {
  // put your main code here, to run repeatedly:
  int v = recur(1);
  delay(2000);
  Serial.println(v);

}
