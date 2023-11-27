let rec isPrimeNum num divider = 
  if num < 1 then false
  else if divider * divider > num then true
  else if num mod divider = 0 then false 
  else isPrimeNum num (divider + 1)

let num = 5;;
isPrimeNum num 2;;