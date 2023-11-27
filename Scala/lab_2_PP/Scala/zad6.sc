def removeDuplicates[T](list: List[T]): List[T] ={
  def containsElement(list: List[T], element: T): Boolean = {
    list match {
      case Nil => false
      case head :: tail if head == element => true
      case _ :: tail => containsElement(tail, element)
    }
  }

  def removeRecursion(list: List[T], accum: List[T]): List[T] = {
      list match {
        case Nil => accum
        case head :: tail if containsElement(accum, head) => removeRecursion(tail, accum)
        case head :: tail if !containsElement(accum, head) => removeRecursion(tail, accum :+ head)
      }
  }
  removeRecursion(list, Nil)
}


val list = List(1, 2, 3, 4, 4 ,1)
println(removeDuplicates(list))