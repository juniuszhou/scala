package FuturePromise

import java.util.concurrent.atomic.AtomicInteger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object MyFuture{
  def main (args: Array[String]) {

    val lastInteger = new AtomicInteger
    def futureInt() = Future {
      Thread sleep 3000
      lastInteger incrementAndGet
    }

    // use callbacks for completion of futures
    val a1 = futureInt
    val a2 = futureInt
    println("a1.onSuccess")
    a1.onSuccess {
      case i1 => {
        a2.onSuccess {
          case i2 => println("Sum of values is " + (i1 + i2))
        }
      }
    }
    Thread sleep 1000
    println("Thread sleep 1000")

    // use for construct to extract values when futures complete
    val b1 = futureInt
    val b2 = futureInt
    println("for")
    for (i1 <- b1; i2 <- b2) yield println("Sum of values is " + (i1 + i2))
    Thread sleep 1000
    println("Thread sleep 1000")

    // wait directly for completion of futures
    val c1 = futureInt
    val c2 = futureInt
    println("val c2 = futureInt")
    //wait the result of future via blocking approach.
    println("Sum of values is " + (Await.result(c1, Duration.Inf) +
      Await.result(c2, Duration.Inf)))
    println("the end")



  }
}