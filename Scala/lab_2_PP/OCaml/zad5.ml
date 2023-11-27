let rec isPalindrome text =
  let text_len = String.length text in
  if text_len<=1 then true 
  else if text.[0] = text.[text_len-1] then isPalindrome(String.sub text 1 (text_len-2))
  else false;;


isPalindrome "ala";;