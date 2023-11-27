let rec getLastElement list =
  match list with
  | [] -> None
  | elem :: [] -> Some(elem)
  | _ :: rest -> getLastElement rest


let list = [1;2;3;4;5;9];;
getLastElement list;;