let rec getEvenIndicies list accum =
  match list with
  | [] -> accum
  | elem :: next_elem :: valid_elem -> getEvenIndicies valid_elem (accum @ [elem])
  | elem :: [] -> accum @ [elem]


let list = [1;2;3;4;5;6;7];;
getEvenIndicies list [];;