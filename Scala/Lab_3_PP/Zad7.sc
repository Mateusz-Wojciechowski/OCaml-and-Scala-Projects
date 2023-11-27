def foldLeft[A,B](list: List[A], fun: (B, A)=>B, accum:B): B={
  list match {
    case Nil => accum
    case head :: tail => foldLeft(tail, fun, fun(accum, head))
  }
}

def map[A, B](list: List[A], fun: A=>B): List[B]={
  list match {
    case Nil => Nil
    case head :: tail => fun(head) :: map(tail, fun)
  }
}

def filter[A](list: List[A], fun: A => Boolean): List[A] = {
  list match {
    case Nil => Nil
    case head :: tail => if (fun(head)) head :: filter(tail, fun) else filter(tail, fun)
  }
}

def squaresBelowThreshold(list: List[Int]): List[Int] = {
  val sum = foldLeft(list.tail, (x: Int, y: Int) => x+y, list.head)
  val filtered = filter(list, (x: Int) => x * x * x <= sum)
  map(filtered, (x: Int) => x * x)
}

val list = List(1, 2, 3, 8, 14)
val result = squaresBelowThreshold(list)
println(result)