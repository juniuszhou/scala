package FuturePromise

import scala.concurrent._

/**
 * Created by juzhou on 5/20/2015.
 */
object FutureOps {
  def main (args: Array[String]) {
    def f: Future[String] = future {
      val b = false
      if (b) "okok" else {
        throw new Exception
      }
    }

  }
}
