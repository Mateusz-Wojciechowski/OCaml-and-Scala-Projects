import scala.util.Try

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

implicit class ResultMonad[X](res: Result[X]){
  def flatMap[Y](f: X=>Result[Y]): Result[Y] = res match{
    case Success(x) => f(x)
    case Failure(msg) => Failure(msg)
  }

  def >>=[Y](f: X => Result[Y]): Result[Y] = flatMap(f)
}

// f1
def getUserInput(user_input: String): Result[String] = {
  if(user_input.nonEmpty) Success(user_input)
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

//val result = getUserInput("10") >>= stringToInt >>= inverseNum
val result = getUserInput("10").flatMap(stringToInt).flatMap(inverseNum)

result match {
  case Success(value) => println(s"Wynik: $value")
  case Failure(error) => println(s"Błąd: $error")
}