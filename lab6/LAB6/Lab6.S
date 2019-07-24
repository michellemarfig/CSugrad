//Written by: Michelle Martinez-Figueroa
// CS 273
// March 8, 2019
// Lab 6 - Displaying Tempreature and Humidity on DHT11 display
// take a string, compare it, and send back ascii value

.data
.comm data,4
.global data
.comm result, 1
.global result
.comm inbound, 1
.global inbound
.global decode


// This is my segment table
// It holds all the binary patterns to the correct pins to make a digits
// Format is 0b0GFEDCBA [ 0 is OFF, 1 is ON ]
segment_table:
  .byte 0b000111111, 0b00000110, 0b01011011, 0b01001111, 0b01100110, 0b01101101, 0b01111101, 0b00000111, 0b01111111, 0b01101111

.macro pushall
push r16
push r17
push r18
push r19
push r20
push r21
push r22
push r23
push r24
push r25
push r26
push r27
push r28
push r29
push r30
push r31
.endm ; of pushall

.macro popall
pop r31
pop r30
pop r29
pop r28
pop r27
pop r26
pop r25
pop r24
pop r23
pop r22
pop r21
pop r20
pop r19
pop r18
pop r17
pop r16
.endm ; of popall




#
# I2C interface is wired to Arduino PORTB bits
# 4 and 5, with 4 being data and 5 being clock,
# so these symbols give us the values needed
#
      .set PORTB,0x05
      .set DDIRB,0x04
      .set SDA,0 ;; digital pin 8 
      .set SCL,1 ;; digital pin 9 

#
# I2C addresses of the components:
#  7-segment LED: 0x40
#   Position: 0xC0 + 4 bytes
#   Brightness: 0x8a
#  
#  We will be using pull up resistors which means that we have opposite logic about
#  When the value we set is the opposite that is being read by the display
#  This code is based heavily off of the TM1637Display.cpp code found on Github  

    
# external symbol (delay function)
    .extern delay

#
# Program code
#
     .text
     .global display_symbol
     .global sendBrightness
     .global  stopBit
     .global  startBit
display_symbol: 
      call setupport ;; set the port to the correct IO direction
      
      call  sendAddress     ; send 7SEG address 
      call  sendPos        ; send instruction for each segment
      call  sendBrightness  ; set brightness
      ret                   ; all done, return to main program!

setupport: ;; set up the port for TM1637
       # set pins to input mode
       cbi   DDIRB,SDA
       cbi   DDIRB,SCL
       cbi   PORTB, SDA
       cbi   PORTB, SCL  ;; this means data and clock are high
       call  delay1          ; wait to make sure PORTB ready
       ret ;; of setupport
#
# Delay for 1 millisecond (saves/restores r18-r20)
#
delay1:
      push r18
      push r19
      push r20
      ldi  r22, 1
      ldi  r23, 0
      ldi  r24, 0
      ldi  r25, 0
      call delay
      pop  r20
      pop  r19
      pop  r18
      ret

#
# I2C startbit: a high-to-low transition on SDA while clock is high
#
startBit:
      sbi   DDIRB,SDA    ; set data bit high, maklng data line go low
      call  delay1       ; leave clock high long enough
      ret

#
# I2C stopit: a low-to-high transition on SDA while clock is high
#
stopBit:
      sbi   DDIRB,SDA    ;
      call delay1
      cbi   PORTB,SCL    ; set clock high
      cbi   DDIRB, SCL    ;  when we turn off one we have to take care of direction
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SDA    ; bring up SDA while clock is high
      cbi   DDIRB, SDA     ; when we clear port we set input mode
      call  delay1       ; keep clock high for a while
      ret

#
# I2C 1 bit transmission: SDA high while clock is high
# 
oneBit:
      sbi   DDIRB,SCL    ; clock goes down due to pull-up 
      call delay1
      cbi   PORTB,SDA    ; A clear writes a 1 to the device
      cbi   DDIRB, SDA
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SCL    ; finally bring clock low
      cbi   DDIRB, SCL
      call  delay1       ; leave clock low for long enough
      ret

#
# I2C 0 bit transmission: SDA low while clock is high
# 
zeroBit:
      sbi   DDIRB,SCL    ; clock goes down due to pull-up 
      call delay1
      sbi   DDIRB,SDA    ; A clear writes a 1 to the device
      call  delay1       ; leave clock high long enough
      cbi   PORTB,SCL    ; finally bring clock low
      cbi   DDIRB, SCL
      call  delay1       ; leave clock low for long enough
      ret

ack:  sbi DDIRB, SCL
      cbi PORTB, SDA
      cbi DDIRB, SDA
      call delay1
      cbi PORTB, SCL
      cbi DDIRB, SCL
      call delay1

      sbis PORTB, SDA  ;; skip if we have a 0 in this slot as per the arduino code
      sbi DDIRB, SDA
      call delay1
      
      sbi DDIRB, SCL
      call delay1
      ret
#
# I2C LED address transmission: must transmit the byte value 0x40
#
sendAddress:
      LDI R18, 0x40
      call  startBit
      call  sendByte
      call  stopBit
      ret

#
# Position should be 0xC0 
#  - 
#
sendPos:
      LDI R18, 0xC0
      call startBit
      call  sendByte
      call  sendData ;
      call stopBit
      ret

// purpose is to send 4 bytes of data, one for each display
// data[0], data[1], data[2], data[3]
sendData:
    pushall
    LDI R31, hi8(data)   //Load data array
    LDI R30, lo8(data)

    LD R18 , Z+         // load next value into z
    call  sendByte      // Call sendByte
    LD R18 , Z+         //Reapeat for times
    call  sendByte
    LD R18 , Z+
    call  sendByte
    LD R18 , Z+
    call  sendByte
    popall
    ret
#
# Command Brightness 0x89
#  - in binary, 01001010
#
sendBrightness:
      LDI R18, 0x8F     //set brightness by chnaging hex value here
      call  startBit
      call sendByte
      call stopBit
     
      ret

#
# Transmit a byte that will display a symbol
#  - you must figure it out!
#
// call senByte to check if bits are 1 or 0
show_one_symbol: ;; you should not have to call this other than testing
      LDI R18 , 0b01010111
      call sendByte
      ret

#  A simple routine which assumes R18 has the Byte in question
#  We loop through the bits of the R18 (this makes R18 not usable
#  and sends the appropriate zero or one bit. We send by least significant bit
#  We then send an ACK at the end




// check whether each bit is a 1 or zero and call appropriatefunction
sendByte:
        pushall
        
       LDI R19, 8   //loop counter
       
loop:  LDI R17, 1     
       AND R17, R18   //AND R17, to R18
       CPI R17, 1     // if 1 go to 1, else, call 0
       BREQ one
       call zeroBit
       rjmp done

       
  one: call oneBit    // call oneBit

  done:
     
       lsr R18
       dec r19
      
       brne loop
       call ack   //call ack function

       popall
       ret


//deocode function to walk through array and send correct binary pattern back to c
// param r18 inbound
// return result
decode: 
    pushall

    //load the table
    ldi r31, hi8(segment_table)
    ldi r30, lo8(segment_table)

    lds r18, inbound  // load inbound from C
    ldi r17, 0  //indx 

         
chkAgain:
      ld r16, Z+  //load z+
      cp r18 , r17  //compare idx to inbound
      breq out      //if equal, out
      inc r17        //increaseidx
      rjmp chkAgain   //chck again

out:
    sts result, r16   //save result of z
    
    popall
    ret


