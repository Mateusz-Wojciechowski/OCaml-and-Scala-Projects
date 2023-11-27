def map[A, B](list: List[A], fun: A=>B): List[B]={
  list match {
    case Nil => Nil
    case head :: tail => fun(head) :: map(tail, fun)
  }
}

val list = List(1.23, 2.31, 3.56, 4.76, 5.94)
val mapped_list = map(list, (x: Double) => x.toInt)
println(mapped_list)