//Written by: Michelle Martinez-Figueroa
// CS 273
// February 28, 2019
// Lab 5
// 7 segment display

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
;;

;;  AVR code to do the function of the 4  x 7 segment display of Lab 5
;;
;;
;;   Shaun Cooper
;;    CS 273
;;    Semester XXXX , 20XX
;;
;;  The basic algorithm is to have the main loop
;; set some shared variable values
;;  we then use simulataneous arrays (vectors)
;;  to figure out which segment is desired 
;;; and which sequence is needed
;;
;;  Since our setup utilizes PORTB and PORTB, then we need to main
;;   simulataneous vectors for all of the segment sequences that are neededed
;;
;; main routine does
;;   setup_ports once
;; 
;;   C code to do the following

;;   segment=0
;;   digit=9
;;   display_segment();; will display 9 on segment 0, for example
;;  
  .data
  .size segment_table, 4
  .size portb_table, 10
  .size portd_table, 10
  
segment_table:  #binary for seting input on PORTB for segment select
    .byte 0b00000010, 0b00000100, 0b00001000, 0b00010000
    ;; 0, 1, 2,3 4, 5, 6 , 7, 8 , 9
portb_table:  # list of binary sequences for setting port B to be ORed with segment table ite
    .byte  0b00000001,1,0,0,0,0,0,1,0,0
portd_table: # list of binary sequences for setting port D.
    .byte  0b00000000,0b11100100,0b10010000,0b11000000,0b01100100,0b01001000,0b00001100,0b11100000,0, 0b01100000
segmentv: .byte 1


  
  .comm segment, 1 ;; the common name for segment
  .comm digit, 1 ;; the digit into our sequences
  .global segment, digit

  

# --------
  .text
  .global setup_ports
  .global display_segment



setup_ports:  ;; routine to set the ports into output mode
   pushall
   //set the direction of the ports to out
   ;; set PORT B
      ldi r16, 0b00011111
      out 0x04, r16
      
  ;; set PORT D
      ldi r16, 0b11111100
      out 0x0A, r16
  popall
  ret ;; of setup_ports



display_segment:  ;;  main entry point for setting the segment
pushall

   ;; the goal is the use "digit" to and "segment" to find the values that need
   ;; to be sent to PORTB and PORT D 

    //load the tables
    LDI R31, hi8(segment_table) ; initialize high byte of Z
    LDI R30, lo8(segment_table) ; initialize low byte of Z
    LDI R29, hi8(portb_table) ; initialize high byte of Y
    LDI R28, lo8(portb_table) ; initialize low byte of Y
    LDI R27, hi8(portd_table) ; initialize high byte of X
    LDI R26, lo8(portd_table) ; initialize low byte of X

    //load global variables
    LDS R16, segment
    LDS r17, digit
 

    //Look at the segment
loop: ld r20, z+
      cpi r16, 0
      breq out1
      dec r16
      jmp loop
      
      //right here i know r20 is the segment vector

      //which register
out1:  ld r21, Y+
      ld r22, X+
      
      cpi r17, 0
      breq out2
      dec r17
      jmp out1
out2:
      OR r20, r21
      
     
      out 0x05, r20
      out 0x0b, r22
      //walk down the arrays
      
    popall
    ret ;; of display_segment
    

