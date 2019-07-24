//Written by: Michelle Martinez-Figueroa
// CS 273
// February 21, 2019
// Lab 4 - goAggies
// blink light to spell go aggies in morse code an inputted number of times


.data
.comm val, 1
    
    .global val

// The following is macros uses to hold old values of registers so caller is not confused
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

.extern delay
.text 
.global goaggies

goaggies: 
lds r18, val
ldi    r17, 0x20
      out    0x04, r17
flash:
          call g
          call o
          call a
          call g
          call g
          call i
          call e
          call s
          call wait
          dec r18
          cpi r18, 0
          brne flash
          ret
      
g:  call dash
    call dash
    call dot
    ret
   
o:  call dash
    call dash
    call dash
    ret
   
a:  call dot
    call dash
    ret
   
i:  call dot
    call dot
    ret

e:  call dot
    ret

s:  call dot
    call dot
    call dot
    ret


dash: //turn on light
      
      ldi    r16, 50
      ldi    r17, 0x20
      out    0x05, r17
      call wait
      call wait
      // turn off light
      ldi    r17, 0x00
      out    0x05, r17
      call wait
      ret

dot:  // turn on light

      ldi    r16, 50
      ldi    r17, 0x20
      out    0x05, r17
      call wait
      // turn off light
      ldi    r17, 0x00
      out    0x05, r17
      ret

wait: pushall
      ldi r22, 0xa0
      ldi r23, 0x00
      ldi r24, 0x00
      ldi r25, 0x00
      call delay
      popall
      ret
      
   
