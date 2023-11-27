def filter[A](list: List[A], fun: A=>Boolean): List[A]={
  list match {
    case Nil => Nil
    case head :: tail => if(fun(head)) head :: filter(tail, fun) else filter(tail, fun)
  }
}

def map[A, B](list: List[A], fun: A=>B): List[B]={
  list match {
    case Nil => Nil
    case head :: tail => fun(head) :: map(tail, fun)
  }
}

def isNonEmpty(word: String): Boolean ={
  word.nonEmpty
}

def createAcronym(text: String): String={
  val words_list = text.split(" ").toList
  val filtered_words = filter(words_list, isNonEmpty)
  val acronym = map(filtered_words, (word: String) => word.head.toUpper)
  acronym.mkString
}

val text = "Wroclaw University of Science and Technology"
println(createAcronym(text))