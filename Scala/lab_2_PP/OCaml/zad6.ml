  let rec removeDuplicates list =
    let rec containsElem list elem =
      match list with
      | [] -> false
      | hd :: tail -> if hd = elem then true else containsElem tail elem
     
    in
    let rec removeRecursion list accum =
      match list with
      | [] -> accum
      | head :: tail -> if containsElem accum head then removeRecursion tail accum else removeRecursion tail (accum @ [head])
    in
    removeRecursion list []


let list = [1;2;3;4;3;2;5];;

removeDuplicates list;; 