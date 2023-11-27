import scala.annotation.tailrec

@tailrec
def last_element[T](list: List[T]): Option[T]={
  list match {
    case Nil => None
    case element :: Nil => Some(element)
    case _ :: tail => last_element(tail)
  }
}

val list = List(1, 2, 3, 4, 5)
println(last_element(list))