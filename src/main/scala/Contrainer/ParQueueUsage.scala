package Contrainer
import collection.mutable
import scala.collection.parallel.mutable.ParSeq

// import collection.parallel.immutable.
/**
 * Created by juzhou on 8/3/2015.
 */
object ParQueueUsage {
def main (args: Array[String]) {
  val pq = new mutable.Queue[Int]().par
  pq.take(0)



  }
}
