// Written by: Michelle Martinez-Figueroa
// CS 273
// February 7, 2019
// Lab3
// Fat Monitor

//QUESTIONS:
// My code already runs in decimal values, not HEX but i converted anyways for the questions
//Gender:   Age:  Hex:   Fat:  HEX:  Light
// F        42     2A     32    20   green
// M        25     19     30    1E   all lights
// F        30     1E     21    15   blue
// M        23     17     17    11   green
       
       .text
       .global lightup
       .comm sex, 1
       .global sex
       .comm age, 1
       .global age
       .comm fat, 1
       .global fat
       
lightup:

     
      // Load registers   
      LDS R16, sex
      LDS R17, age
      LDS R18, fat

      //if 1 then female
      CPI R16, 1
      BREQ female
      //if 2 then male
      CPI R16, 2
      BREQ male

//Brach if female
female:
      CPI R17, 40   //compare R17 with 40
      BRLo f20  // if less than 40 go to m20
      CPi R17, 60   //compare r16 with 60
      BRLO f40    // if less than 60 go to f40
      CPI R17, 60   // compare r16 with 60
      BRSH f60    // else go to f60
 
//Branch if male
 male:
      CPI R17, 40
      BRLo m20  // if less than 40 go to m20
      CPi R17, 60
      BRLO m40    // if less than 60 go to m40
      CPI R17, 60
      BRSH m60    // else go to m60

// Branch for F20
//if less than 21 go to blue
//if less than 33 go to green
//if less than 39 go to all lights
f20:
      CPI R18, 21
      BRLO blue 
      CPI R18, 33
      BRLO green
      CPI R18, 39
      BRLO red
      CPI R18, 39
      BRSH alllights

//Branch for f40
//if less than 23 go to blue
//if less than 34 go to green
// if less than 40 go to red
// else go to all lights
 f40:
      CPI R18, 23
      BRLO blue
      CPI R18, 34
      BRLO green
      CPI R18, 40
      BRLO red
      CPI R18, 40
      BRSH alllights

// Branch for f60
// if less than 24 go to blue
// if less than 36 go to green
// if less than 42 go to red
// else go to alllights    
f60:
      CPI R18, 24
      BRLO blue
      CPI R18, 36
      BRLO green
      CPI R18, 42
      BRLO red
      CPI R18, 42
      BRSH alllights

// Branch for m20
// if less than 8 go to blue
// if less than 20 go to green
// if less than 25 go to red
// else go to alllights    
m20:
      CPI R18, 8
      BRLO blue
      CPI R18, 20
      BRLO green
      CPI R18, 25
      BRLO red
      CPI R18, 25
      BRSH alllights

// Branch for m40
// if less than 11 go to blue
// if less than 22 go to green
// if less than 28 go to red
// else go to alllights 
m40: 
      CPI R18, 11
      BRLO blue
      CPI R18, 22
      BRLO green
      CPI R18, 28
      BRLO red
      CPI R18, 28
      BRSH alllights

// Branch for m60
// if less than 13 go to blue
// if less than 25 go to green
// if less than 30 go to red
// else go to alllights 
m60:
      CPI R18, 13
      BRLO blue
      CPI R18, 25
      BRLO green
      CPI R18, 30
      BRLO red
      CPI R18, 30
      BRSH alllights
    
// will light up blue
blue:
       ldi  r18, 0b00100000

       out  0x04, r18   ; 0x04 is I/O address of DDRB

       out  0x05, r18   ; 0x05 is I/O address of PORTB

       ret
       

 // will light up green
 green:
       ldi  r18, 0b00010000

       out  0x04, r18   ; 0x04 is I/O address of DDRB

       out  0x05, r18   ; 0x05 is I/O address of PORTB

       ret
       
// will light up red
red:
        ldi  r18, 0b00000001

       out  0x04, r18   ; 0x04 is I/O address of DDRB

       out  0x05, r18   ; 0x05 is I/O address of PORTB

       ret
       
       
// Will turn on alllights
alllights:
        ldi  r18, 0b00110001

       out  0x04, r18   ; 0x04 is I/O address of DDRB

       out  0x05, r18   ; 0x05 is I/O address of PORTB

       ret
