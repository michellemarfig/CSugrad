.text
  .global recur

 recur:   // simple summation recurrence.  We look at R24 and if it is > we set up things to recur

     CPI R24, 1
     brge more  // do some more

     // we are base case
     LDI R24, 0
     CLR R25
     ret

 more:
     push R24
     dec R24
     call recur
     // at this point R24 is the result, we need to add on what we pushed
     pop r16
     ADD R24, R16
     CLR R25
     ret
