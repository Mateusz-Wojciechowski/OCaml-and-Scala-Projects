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
}
