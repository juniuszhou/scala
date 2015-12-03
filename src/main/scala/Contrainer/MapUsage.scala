package Contrainer

import scala.collection.mutable.Map
/**
 * Created by juzhou on 7/28/2015.
 */
object MapUsage {
def main (args: Array[String]) {
    val map = Map[Int, Object]()
    map.put(1, null)

    val v = map.get(1)
    println(v)

    val v2 = map.get(2)
    println(v2)

    val source = io.Source.fromFile("build.sbt").getLines()
    source.foreach(println)
  }
}
