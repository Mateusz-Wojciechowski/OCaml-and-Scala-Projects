type 'a tree =
| Empty
| Node of 'a * 'a tree * 'a tree

let emptyTree = Empty

let rec insert x = function
  | Empty -> Node(x, Empty, Empty)
  | Node(y, left, right) as node->
    if x<y then Node(y, insert x left, right)
    else if x>y then Node(y, left, insert x right)
    else node

let rec remove x = function
    | Empty -> Empty
    | Node(y, left, right) ->
      if x<y then Node(y, remove x left, right)
      else if x>y then Node(y, left, remove x right)
      else
        match (left, right) with
        | (Empty, _) -> right
        | (_, Empty) -> left
        | _ ->
          let rec findSuccessor node =
            match node with 
            | Empty -> failwith "Empty tree!"
            | Node(value, Empty, _) -> value
            | Node(_, left, _) -> findSuccessor left
          in
          let succ  = findSuccessor right in
          Node(succ, left, remove succ right)


let rec inOrder = function
  | Empty -> []
  | Node(value, left, rigth) -> inOrder left @ [value] @ inOrder rigth

let rec preOrder = function
  | Empty -> []
  | Node(value, left, right) -> [value] @ preOrder left @ preOrder right

let rec postOrder = function
  | Empty -> []
  | Node(value, left, right) -> postOrder left @ postOrder right @ [value]


let rec getLeaves = function
| Empty -> []
| Node(value, Empty, Empty) -> [value]
| Node(_, left, right) -> getLeaves left @ getLeaves right




(* Funkcja do wydrukowania listy *)
let print_list lst =
  List.iter (fun x -> print_int x; print_string " ") lst;
  print_newline ()

(* Testowe operacje na drzewie *)
let () =
  (* Tworzenie pustego drzewa *)
  let tree = Empty in

  (* Wstawianie elementów *)
  let tree = insert 5 tree in
  let tree = insert 3 tree in
  let tree = insert 7 tree in
  let tree = insert 1 tree in
  let tree = insert 4 tree in
  let tree = insert 6 tree in

  (* Przechodzenie drzewa *)
  print_string "Inorder traversal: ";
  print_list (inOrder tree);

  print_string "Preorder traversal: ";
  print_list (preOrder tree);

  print_string "Postorder traversal: ";
  print_list (postOrder tree);

  (* Usuwanie elementu *)
  let tree = remove 3 tree in
  print_string "Inorder after removing 3: ";
  print_list (inOrder tree);

  (* Wyświetlanie liści drzewa *)
  print_string "Leaves of the tree: ";
  print_list (getLeaves tree);
