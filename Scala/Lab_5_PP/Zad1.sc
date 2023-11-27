
import scala.collection.mutable

def stirling(n: Int, m: Int): BigInt = {
  if(m==1 || m==n){
    1
  }

  else{
    stirling(n-1, m-1) + m * stirling(n-1, m)
  }
}

val memo_map: mutable.Map[(Int, Int), BigInt] = mutable.Map()

def memoized_stirling(fun: (Int, Int) => BigInt): (Int, Int) => BigInt = {
  (n: Int, m: Int) => {
    memo_map.getOrElseUpdate((n, m), {
      if (n == 0 && m == 0) 1
      else if (n == 0 || m == 0) 0
      else if (m == 1 || m == n) 1
      else fun(n - 1, m - 1) + m * fun(n - 1, m)
    })
  }
}

// zwykly stirling
val startStirling = System.nanoTime()
val resultStirling = stirling(20, 10)
val endStirling = System.nanoTime()

// stirling z memoizacja
val memoized_stirling_fun = memoized_stirling(stirling)
val startMemoized = System.nanoTime()
val resultMemoized = memoized_stirling_fun(20, 10)
val endMemoized = System.nanoTime()

val startMemoized1 = System.nanoTime()
val resultMemoized1 = memoized_stirling_fun(21, 10)
val endMemoized1 = System.nanoTime()

println(s"Result stirling: $resultStirling, Time: ${(endStirling - startStirling)/1e9d} ns")
println(s"Result memoized_stirling: $resultMemoized, Time: ${(endMemoized - startMemoized)/1e9d} ns")
println(s"Result memoized_stirling: $resultMemoized1, Time: ${(endMemoized1 - startMemoized1)/1e9d} ns")


