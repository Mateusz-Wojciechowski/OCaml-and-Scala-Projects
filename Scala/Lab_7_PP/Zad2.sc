import scala.util.Try
import scala.io.StdIn.readLine

sealed trait Result[+X]

case class Success[X](value: X) extends Result[X]
case class Failure(err_message: String) extends Result[Nothing]

object Result{
  def apply[X](x: =>X): Result[X] = {
    try{
      Success(x)
    }
    catch{
      case except: Exception => Failure(except.getMessage)
    }
  }
}

// f1
def getUserInput(user_input: String): Result[String] = {
  if (user_input.nonEmpty) Success(user_input)
  else Failure("Blad: podano pusty ciag znakow")
}

// f2
def stringToInt(str: String): Result[Int] = {
  Try(str.toInt) match{
    case scala.util.Success(int_num) => Success(int_num)
    case scala.util.Failure(_) => Failure("Blad: podany ciag znakow nie jest liczba")
  }
}

// f3
def inverseNum(num: Int): Result[Double] = {
  if(num!=0) Success(1.0/num)
  else Failure("Blad: dzielenie przez zero")
}


val step1 = getUserInput("10")

val step2 = step1 match {
  case Success(value) => stringToInt(value)
  case Failure(error) => Failure(error)
}

val result = step2 match {
  case Success(value) => inverseNum(value)
  case Failure(error) => Failure(error)
}


result match {
  case Success(value) => println(s"Wynik: $value")
  case Failure(error) => println(s"Błąd: $error")
}

