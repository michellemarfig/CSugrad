 # Setting constants for ultrasonic sensor 
  .set trigpin, 4; port c pin 4
  .set echopin, 1; port b pin 1
  .set PINB, 0x03
  .set DDIRB, 0x04
  .set DDIRC, 0x07
  .set PORTC, 0x08

.data

   .comm pinbstate, 1
   .global pinbstate ; used to store the current state of PINB

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

.text
   .global ultrasensor
   .global readPINBState
   .extern delayMicroseconds

# Setup the ultrasonic sensor to send an echo
ultrasensor:
 pushall
 # Set trig pin to output and echo pin to input
  //
  sbi DDIRC, trigpin
  cbi DDIRB, echopin

 # Trig pin is low for 2 microseconds
  cbi PORTC, trigpin
  call delay2

 # Trig pin is high for 10 microseconds
  sbi PORTC, trigpin
  call delay10

 # Finally set trig pin to low, this will send an echo
  cbi PORTC, trigpin

  popall
  ret

readPINBState:
 #Routine to look at the echo pin and set "pinbstate" the global variable to 1 or 0 based on the pin

    pushall
    
    # Read PINB in a register, we want to see if the echo pin has been set

    //CHNAGES

    in r16, PINB
    sbrs r16, echopin
    jmp falselabel
    jmp truelabel
    
    # If the echo pin has been set, it means that the echo has been sent, store 1 in 'pinbstate'
    
    
    

    # If the echo pin has been cleared, it means that the echo might have come back, store 0 in 'pinbstate'
  

falselabel:
    ldi r18, 0
    STS pinbstate, r18
    jmp done
    
truelabel:
    // CHANGES
    ldi r17, 1  //put 1 in a rgister
    STS pinbstate, r17  //store to pinbstate
    

done:
    popall
    ret


delay10:
#FIX THIS, make sure you protect registers
      pushall
      ldi r24, 0x0A
      ldi r25, 0x00
      call delayMicroseconds
      popall
      ret

delay2:
#FIX THIS, make sure you protect registers

      // CHNGES
      pushall
      ldi   r24, 0x02
      ldi   r25, 0x00
      call  delayMicroseconds
      popall
      ret

  
