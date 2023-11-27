def getEvenIndices[T](list: List[T], accum: List[T]): List[T] ={
  list match {
    case Nil => accum
    case elem :: next_elem :: valid_elem => getEvenIndices(valid_elem, accum:+elem)
    case elem :: Nil => accum:+elem
  }
}


val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,  12)
println(getEvenIndices(list, Nil))