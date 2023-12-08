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


val result1 = Result(5)
val result2 = Result(throw new Exception("Bład"))
