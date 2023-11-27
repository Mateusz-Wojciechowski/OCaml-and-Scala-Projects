import scala.annotation.tailrec

@tailrec
def last_two_elements[T](list: List[T]): Option[(T, T)]={
  list match {
    case Nil => None
    case x :: Nil => None
    case x :: y :: Nil => Some((x,y))
    case _ :: tail => last_two_elements(tail)
  }
}

val list = List(1, 2, 3, 4, 5, 6)
println(last_two_elements(list))