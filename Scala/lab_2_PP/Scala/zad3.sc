def list_length[T](list: List[T]):Int ={
  if(list==Nil){
    0
  }

  else{
    1 + list_length(list.tail)
  }
}


val list = List(1, 2, 3, 4)
println(list_length(list))