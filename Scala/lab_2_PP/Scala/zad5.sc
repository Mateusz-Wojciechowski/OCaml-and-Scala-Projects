def isPalindrome(text: String): Boolean={
  val text_length = text.length
  if (text_length<=1){
    true
  }

  else if (text(0)==text(text_length-1)){
    isPalindrome(text.substring(1, text_length-2))
  }

  else{
    false
  }
}

isPalindrome("ala")
isPalindrome("Marcin")