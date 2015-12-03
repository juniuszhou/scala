package FuturePromise

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureOps {
  def main (args: Array[String]) {

    def f(i: Int) = Future {
      if (i == 0) throw new Exception
      else {
        if (i > 0) "I am ok." else 3
      }
    }

    val res = f(1)
    res.onSuccess({
      case str: String => println(str)
      case _ => println("exception")
    })

    res.onFailure({
      case _ => println("Exception thrown")
    })

    Thread.sleep(1000)
  }
}
