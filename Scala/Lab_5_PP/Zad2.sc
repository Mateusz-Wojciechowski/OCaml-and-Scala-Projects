import scala.collection.mutable

val memo_map: mutable.Map[Int, BigInt] = mutable.Map()

def make_memoize(fun: Int => BigInt): Int => BigInt = {
  (arg: Int) => {
    memo_map.getOrElseUpdate(arg, fun(arg))
  }
}

def fib(n: Int): BigInt = {
  if (n <= 1) n
  else fib(n - 1) + fib(n - 2)
}

val memoized_fib = make_memoize(fib)

// Testowanie memoizacji
val fib_range1 = 20
val fib_range2 = 20

val startMemoFib = System.nanoTime()
val resultMemoFib = memoized_fib(fib_range1)
val endMemoFib = System.nanoTime()

val startMemoFib2 = System.nanoTime()
val resultMemoFib2 = memoized_fib(fib_range2)
val endMemoFib2 = System.nanoTime()

println(s"Memoized Fib $fib_range1: $resultMemoFib, Time ${(endMemoFib - startMemoFib)/1e9d} ns")
println(s"Memoized Fib $fib_range2: $resultMemoFib2, Time ${(endMemoFib2 - startMemoFib2)/1e9d} ns")

