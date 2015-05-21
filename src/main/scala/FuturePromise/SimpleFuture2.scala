package FuturePromise

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by juzhou on 5/20/2015.
 */
object SimpleFuture2 {
  def f: Future[String] = future {
    val b = false
    if (b) "okok" else {
      throw new Exception
      "sadfa"
    }
  }

  def main (args: Array[String]) {
    val res = f
    println("start")
    // if we just deal success case, then process got nothing if exception.
    // it is ignored by default.
    res onSuccess {
      case str => println("we get " + str)
    }
    // we for async call future
    Thread.sleep(1000)

    println("end")
  }
}
