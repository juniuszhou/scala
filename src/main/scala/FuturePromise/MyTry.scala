package FuturePromise

import scala.util.{Failure, Success, Try}

/**
 * Try used if a method may return a value or throw exception.
 */
object MyTry {
  def main(args: Array[String]) {
    def f: Try[Int] = {
      val b = true
      if (b) Success(100) else Failure(new RuntimeException)
    }

    val res = f
    res match {
      case Success(i) => println("we got int " + i)
      case Failure(e) => e.printStackTrace()
    }
  }
}
