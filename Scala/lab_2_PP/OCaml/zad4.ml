
let rec reverseList list =
  let rec innerRecursion list accum =
    match list with
    | [] -> accum
    | elem :: rest -> innerRecursion rest (elem::accum)
  
  in
  innerRecursion list []

let list = [1;2;3;4;3;2;5];;

reverseList list;; 