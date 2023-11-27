let rec getLastTwoElements list =
  match list with
  | [] -> None
  | elem :: [] -> None
  | elem1 :: elem2 :: [] -> Some((elem1, elem2))
  | _ :: rest -> getLastTwoElements rest



let list = [1;2;3;4;5;6;7;8];;
getLastTwoElements list;;