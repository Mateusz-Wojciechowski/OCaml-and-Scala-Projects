
def reverse_list[T](list: List[T]): List[T] ={
  def recursion[T](list: List[T], accum: List[T]): List[T] = {
    list match {
      case Nil => accum
      case x :: tail => recursion(tail, x :: accum)
    }
  }
  recursion(list, Nil)
}

val list = List(1, 2, 3, 2, 4)
println(reverse_list(list))

