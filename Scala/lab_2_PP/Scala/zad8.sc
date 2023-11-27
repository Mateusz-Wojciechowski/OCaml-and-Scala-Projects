
def isPrimeNum(num: Int, divider: Int = 2): Boolean={
  if(num<=1){
    false
  }

  else if(divider * divider>num){
    true
  }

  else{
    if(num % divider == 0){
      false
    }
    else{
      isPrimeNum(num, divider+1)
    }
  }
}

val num = 12
println(isPrimeNum(num))