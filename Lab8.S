// Written by: Michelle Martinez-Figueroa
// Lab 8 - Motor Controller with Remote Control
// April 11, 2018


# Constants for motor

       ; on port B
      .set PORTB,0x05
      .set DDIRB,0x04
      .set PINB, 0x03
      .set MOTDATA,0
      .set MOTLATCH,4
      .set M1ENABLE,3
      .set BOARDLED, 5
      .set SWITCH2, 2
      
      ; on port D
      .set PORTD,0x0B
      .set DDIRD,0x0A
      .set MOTCLOCK,4
      .set M2ENABLE,3
      .set M4ENABLE,6
      .set M3ENABLE,5
      
# Constants for LED

      ; on port C
      .set PORTC, 0x08
      .set DDIRC, 0x07

# Macros to push and pop registers without writing them multiple times
# Fun fact : One would prefer a function over macro but you cannot use a function that pushes onto stack, why? 

.macro pushall 
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
.endm

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
.endm

# Data

    .data
    .comm remotecommand, 2
    .global remotecommand ; For getting the 2 byte remote command sent from the .ino side

    .comm command, 1
    .global command ; To return the respective command for a button press
    
     commandlowbyte: ; All low bytes in order of 'commandcode'
     .byte 0xFD, 0xDD, 0x3D, 0x57, 0x1F  // FIX UPDATE THIS TO MATCH YOUR REMOTE LOWERBYTE

     commandhighbyte:  ;All high bytes in order of 'commandcode'
     .byte 0x2, 0x22, 0xC2, 0xA8, 0xE0 // FIX UPDATE THIS TO MATCH YOUR REMOTE UPPER BYTE

     # Command codes -- where '>' means forward (clockwise), '<' means backward (counter clockwise), '!' means stop motor
     # '^' means turn a LED on and 'v' mean turn a LED off.
     commandcode: 
     .byte '>', '<', '!', '^', 'v' // you should set command to one of these values based on the values in remotecommand, '.' for not found

     commandlen: ; maximum number of commands
     .byte 5

# Program

    .text
    .global control
    .global controlMotor
    .extern delay

control: 
      pushall
      call setupMotor

      ; 
      ; TODO: change this "mainLoop" to be the code for lab 8
      ;

      ; argument to sendMotorByte (r24) holds the 8-bits 
      ; to control 4 bidirectional motors: 
      ; (bits 2+3  for motor1, bits 0+6  for motor4, 
      ;  bits 1+4  for motor2, bits 5+7  for motor3)
      ;;   FIX This program runs forever, you are to make the following modifications
      ;;  Run the loop 3 times.  You should use turnoffmotor, turnonclockwise, and turnoncounterclockwise
      ;; 
mainLoop:        

      ldi r17, 3  // counter to loop 3 times
      
      call turnonclockwise
      call delayLong
      
      call turnoffmotor
      call delayTwo
      call turnoncounterclockwise
      call delayLong
      
      call turnoffmotor
      call delayTwo

      call turnonlight
      call delayLong

      call turnofflight
      call delayLong

      dec r17
      cpi r17, 0
      brne mainLoop
      
      popall
      ret  ;; of control()


setupMotor: 
      PUSH r20
      push r21
      
      ; set ports B and D to be output
      ldi r20 ,0b11111001
      out DDIRB, r20
      out DDIRD, r20

      //set portc to output on pin 5
      ldi r21, 0b00100000
      out DDIRC, r21

      pop r21
      pop r20
      
      ret ;; of setupMotor

remoteCommand: #  This routine uses the 2 bytes of remote command to determine which of the 
               #  5 inputs are selected
               #  on completion, the shared global variable "command" will be one of 6 values
               #   '<', '>', '!','^','v','.'
               
      pushall ; push all registers so that 'we' do not overwrite a register used by compiler/linker/loader
      
      ldi r26, lo8(remotecommand) ; Read the 2 bytes of remote signal in X
      ldi r27, hi8(remotecommand) ; Read the 2 bytes of remote signal in X

      #  FIX ME
      #  You need to create code to map the 2 bytes (r18 and r19) to the corresponding character command code
     
//      // CHANGES ***********************
      ld r20, X+
      ld r21, X

      // X to store lowbyte
      ldi r26, lo8(commandlowbyte)
      ldi r27, hi8(commandlowbyte)

      // y gto store high byte
      ldi r28, lo8(commandhighbyte)
      ldi r29, hi8(commandhighbyte)

      // z to store the commandcode
      ldi R30, lo8(commandcode)
      ldi r31, hi8(commandcode)

      // load the length (also serves as counter)
      lds r19, commandlen

loop:
      ld r22, X+  // get next element in array
      ld r23, Y+
      ld r24, Z+

      cp r20, r22 // compare low byte, if matches go to loop2
      breq loop2

      dec r19     // keep looping until 0
      cpi r19, 0
      breq error
      jmp loop

loop2:  // loop to compare high byte
      cp r21, r23
      breq done
      jmp loop

error:    
      ld r24, Z
      sts command, r24   //save z
      
      popall
      ret

done:
      sts command, r24    // found, now save to command variable
      popall
      ret



controlMotor:
      pushall
      call setupMotor ; Setup motor
      call remoteCommand ; Pattern match the remote command to get a code.  Sets "command"

      lds r22, command ; Load the code

      # Call corresponding utility based on the command code received.
      cpi r22, '>'
      breq turnonclockwise

      cpi r22, '<'
      breq turnoncounterclockwise

      cpi r22, '!'
      breq turnoffmotor

      cpi r22, '^'
      breq turnonlight

      cpi r22, 'v'
      breq turnofflight

finish:
      popall
      ret  ;  of controlMotor
      
turnoffmotor:
// FIX this to turn off motor

      // CHANGES ****************
      
      ldi   r24, 0b00000000
      call  sendMotorByte
      jmp finish
      

turnonclockwise:      
// FIX THIS to turn motor clockwise

      // CHANGES ****************
      ldi   r24, 0b11011000   ; all motors 1 direction
      call  sendMotorByte
      jmp finish

turnoncounterclockwise:
 //FIX this to turn the motor counterclockwise

      // CHNAGES *******************
      ldi   r24, 0b00100111   ; then all motors opposite dir
      call  sendMotorByte
      jmp finish

turnonlight:
// FIX THIS.  
//  USE CBI/SBI to enable PORTC, PIN5 to output mode and then set the bit

//      // CHANGES *************
      sbi PORTC, 5
      jmp finish
      
turnofflight:
// FIX THIS with CBI/SBI to enable PORTC,PIN5 in output mode and clear bit
     
      cbi PORTC, 5
      jmp finish
      
#
# Delays for 1 and 255 milliseconds
#

delay1:
      pushall
      ldi   r22, 0x01
      ldi   r23, 0x00
      ldi   r24, 0
      ldi   r25, 0
      call  delay
      popall
      ret ;; of delay1

delayLong:
      pushall     
      ldi   r22, 0xe8
      ldi   r23, 0x13
      ldi   r24, 0
      ldi   r25, 0
      call  delay 
      popall    
      ret ;; of delayLong
      
delayTwo:
      pushall
      ldi   r22, 0x00
      ldi   r23, 0x08
      ldi   r24, 0x00
      ldi   r25, 0x00
      call  delay
      popall     
      ret ;; of delayTwo

#  1 bit transmission
sendOneBit:
      sbi DDIRB,MOTDATA
      sbi PORTB, MOTDATA
      sbi DDIRD, MOTCLOCK
      sbi PORTD, MOTCLOCK  
      call delay1
      cbi PORTD, MOTCLOCK 
      ret

# 0 bit transmission
sendZeroBit:
   // FIX as per the information in the AVR booklet
      sbi DDIRB,MOTDATA
      cbi PORTB, MOTDATA
      sbi DDIRD, MOTCLOCK
      sbi PORTD, MOTCLOCK  
      call delay1
      cbi PORTD, MOTCLOCK 
      ret

#
# latch now should be enabled (one) in order to release 
# the control pattern to the motor driver chips 
#
latchData:
      sbi   PORTB,MOTLATCH
      call  delay1
      ; make sure PWM outputs are on
      sbi   PORTB, M1ENABLE
      sbi   PORTD, M2ENABLE
      sbi   PORTD, M3ENABLE
      sbi   PORTD, M4ENABLE
      ret

# latch should be zero in order to send the control 
# pattern to shift register    
latchReset: 
      cbi   PORTB,MOTLATCH
      call  delay1
      ret

sendMotorByte: ;; assumes r24 has the byte we want to send
      push  r15
      push  r16
      mov   r15, r24
      call  latchReset
      ldi   r16, 8
smbloop:
      lsl   r15
      brcs  smbone
      call  sendZeroBit   
      rjmp  smbdone
smbone:
      call  sendOneBit
smbdone:
      dec   r16
      brne  smbloop
      call  latchData
      call  latchReset
      pop   r16
      pop   r15
      ret
