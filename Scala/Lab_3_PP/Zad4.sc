def reduce[A, B](list: List[A], fun: (A,B)=>B, accum: B): B={
    list match {
      case Nil => accum
      case head :: tail => reduce(tail, fun, fun(head, accum))
    }
}

val list = List(1, 4, 8, 11)
val reduced = reduce(list.tail, (x:Int, y:Int)=>x*y, list.head)
println(reduced)

// kolejnosc operandow ma znaczenie
// na przyklad dla dzielenia albo potegowania