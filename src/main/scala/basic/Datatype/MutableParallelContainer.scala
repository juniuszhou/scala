package basic.Datatype

import java.util.concurrent.ConcurrentLinkedQueue

import scala.collection.parallel.mutable._

/**
 * Created by juzhou on 8/3/2015.
 */
object MutableParallelContainer {
  def main (args: Array[String]) {

    // for array, the size still fixed.
    val ab = new ParArray[Int](10)
    ab.foreach(println)
    ab.take(0)
    ab.update(0, 1)

    val pq = new ParHashMap[Int, Int]()
    pq.+=(1 -> 2)

    // thers is no par queue implementation. must use the one from java
    // for container like map/set/array/vector , the implementation of scala
    // is so different, so scala also implement parallel version.
    // container like queue maybe java is good enough.

    val qq = new ConcurrentLinkedQueue[Int]()
    qq.add(9)
    println(qq.peek())

  }
}
