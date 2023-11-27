def filter[A](list: List[A], fun: A=>Boolean): List[A]={
    list match {
      case Nil => Nil
      case head :: tail => if(fun(head)) head :: filter(tail, fun) else filter(tail, fun)
    }
}

val list = List(1, 2, 3, 5, 6, 8, 9)
val filtered_list = filter(list, (x:Int) => x % 2 == 1)
println(filtered_list)
