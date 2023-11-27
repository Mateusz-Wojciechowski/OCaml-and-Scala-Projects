enum Maybe[+A]:
  case Just(value: A)
  case Nothing


def safeHead[A](list: List[A]): Maybe[A] = {
  list match {
    case head :: _ => Maybe.Just(head)
    case Nil => Maybe.Nothing
  }
}

val list = List()
println(safeHead(list))

