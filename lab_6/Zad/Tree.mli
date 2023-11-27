type 'a tree 
 
val emptyTree: 'a tree

val insert: 'a -> 'a tree -> 'a tree

val remove: 'a -> 'a tree -> 'a tree

val inOrder: 'a tree -> 'a list

val postOrder: 'a tree -> 'a list

val preOrder: 'a tree -> 'a list

val getLeaves: 'a tree -> 'a list

