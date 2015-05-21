package FuturePromise

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Future is implemented by callback method.
 */
object SimpleFuture {
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
    res onComplete {
      case Success(str) => println("we get " + str)
        // from trace we can see the future implemented in fork join thread model.
      case Failure(e) => e.printStackTrace()
    }
    // we for async call future
    Thread.sleep(1000)

    println("end")
  }
}
