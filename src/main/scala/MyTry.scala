import scala.util.{Failure, Success, Try}

object MyTry{
  def getTry(i: Int): Try[Int] = {
    if (i > 10)  Success[Int](i) else Failure(new Exception)
  }
  def main (args: Array[String]) {
    val i: Int = 0
    val result = getTry(i)

    //result.get
    result match{
      case Success(_) => println("success")
      case Failure(_) => println("failed")
    }

  }
}