
#
# Global data (x1, x2, and x3)
#
    .data
    .comm x1,1
    .global x1
    .comm x2,1
    .global x2
    .comm x3,1
    .global x3

#
# Program code (addition function)
#
    .text
    .global addition
addition:
    lds  r18, x1
    lds  r19, x2
    lds  r20, x3
    inc r18
    add r18, r18
    
    dec r19
    
    dec r20
    dec r20
    dec r20
    add  r18, r19
    add  r18, r20
    sts  x3, r18

    //put a 1 on bit 5 on address 0x04
    ldi r18, 0b00100000
    out 0x04, r18
    
    //put a 1 on bit 5 on address 0x04
    ldi r18, 0b00100000
    out 0x05, r18
  
    ret
