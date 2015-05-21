package FuturePromise

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Promise}

object MyPromise{
  def getPromise(i: Int) : Promise[Int] = {
    val res = Promise[Int]()
    res
  }

  def generatePromiseResult(p: Promise[Int]): Unit = {
    Thread sleep 2000
    p.success(20)
  }

  def main (args: Array[String]) {
    val p = getPromise(20)
    val f = p.future

    f onSuccess {
      case i => println(i)
    }

    f onFailure {
      case _ => println("got an exception")
    }

    //non block the main thread.
    generatePromiseResult(p)


    //Promise usage.
    val p1 = Promise[Int]()
    val f1 = p1.future
    f1 onSuccess {
      case i => println(i)
    }
    f1 onFailure {
      case _ => println("got an exception")
    }

    //p1.success(123)
    p1.failure(new Throwable)

    Thread sleep 3000
  }
}