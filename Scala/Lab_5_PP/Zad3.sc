def stirling(n: Int, m: Int): BigInt = {
  println(s"Calling stirling ($n, $m)")
  if (m == 1 || m == n){
    1
  }
  else{
    stirling(n - 1, m - 1) + m * stirling(n - 1, m)
  }
}

lazy val stirling_value = stirling(10, 5)

println("Before evaluation")
println(s"Value of stirling $stirling_value")