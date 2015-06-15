package FuturePromise

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object FutureAwait {
  def main (args: Array[String]) {
    def f: Future[Int] = Future {
      Thread.sleep(2000)
      //throw new Exception
      1
    }

    val res = f
    //if exception then await can't catch.
    //val one = Await.result(res, Duration.Inf)

    // if not return in time then timeout exception.
    val one = Await.result(res, Duration(1, SECONDS))
    println(one)
  }
}
