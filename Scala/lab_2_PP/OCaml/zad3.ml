let rec listLength list =
  if list == [] then 0

  else 1 + (listLength (List.tl list))


let list = [1;2;3;4;5;6;7;8;9];;
listLength list;;