//Written by: Michelle Martinez-Figueroa
// CS 273
// March 19, 2019
// Lab 7 - Analog to Digital Conversion

/*
 * Questions:
 * 1.) lowest: 50 (when covering)
 * 2.) highet: FD (with flashlight)
 * 3.) it doesn't show the 1024 values because it rounds off to the closest discrete value.
 */


.data
.global initAD
.global readAD
.text


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

//get ready to read
initAD:
          pushall
          
          //setting didr0 0-5 to 1 to turn off digital input buffers
          ldi r16, 0b00111111
          STS 0x007E, r16


          //setting adcsra
          ldi r16, 0b10000111
          sts 0x007A, r16
          
          popall
          ret

readAD:
           //admux
          ldi r16, 0b01100000
          or r16, r24
          sts 0x007C, r16

          //adsra set adsc to 1 to start conversion
          ldi r16, 0b11000111
          sts 0x007A, r16

loop:     //read adsc until it reads 0
          lds r16, 0x007A
          sbrc r16, 6         //if bit 6 is 0, skip next  line
          rjmp loop

          

done:
          //fetch result from adch
          clr r25
          lds r24, 0x0079

          ret

          
