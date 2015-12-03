package FuturePromise

import scala.concurrent.{future, promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object SimplePromise {
  def main(args: Array[String]) {
    val p = promise[Int]()
    val f = p.future
    def responseToPromise() = future {
      f onComplete {
        case Success(i) => println("we got " + i)
        case Failure(e) => e.printStackTrace()
      }
    }
    responseToPromise()
    //p success 100
    p failure new Exception
    //
    Thread.sleep(1000)
  }
}
