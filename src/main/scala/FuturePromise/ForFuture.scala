package FuturePromise

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/*
if there is a chained future and there is dependence relation.
following implementation is ugly. so for and map can do beautiful.

val rateQuote = future {
  connection.getCurrentValue(USD)
}
rateQuote onSuccess { case quote =>
  val purchase = future {
    if (isProfitable(quote)) connection.buy(amount, quote)
    else throw new Exception("not profitable")
  }

  purchase onSuccess {
    case _ => println("Purchased " + amount + " USD")
  }
}
 */

object ForFuture {
  def main (args: Array[String]) {
    def f: Future[String] = future {
      val b = false
      if (b) "okok" else {
        throw new Exception
      }
    }

    def chainedFuture() : Unit = {
      val res1 = f

      val res2 = res1 map {
        str => if (str.nonEmpty) str else throw new Exception
      }

      res2 onSuccess {
        case str => println(str)
      }

      Thread.sleep(1000)
    }

    // other way to use for combine two futures.
    // acutally it like a flatmap, a new future may depend on two previous futures.
    val res3 = f
    val res4 = f
    val equ = for {
      str1 <- res3
      str2 <- res4
      if str1 == str2
    } println("equal")

    Thread.sleep(1000)

  }
}
