import scala.annotation.tailrec

@tailrec
def foldLeft[A, B](list: List[A], accum: B)(f: (B, A) => B): B =
  list match {
  case Nil => accum
  case head :: tail => foldLeft(tail, f(accum, head))(f)
}

def calculateMean(list: List[Int]): Double = {
  if (list.isEmpty) {
    0.0
  }
  else {
    val sum = foldLeft(list, 0)(_ + _)
    sum.toDouble / list.length
  }
}

val list = List(1, 2, 3, 4, 5)
println(calculateMean(list))
