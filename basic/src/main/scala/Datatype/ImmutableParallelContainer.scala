package Datatype

import scala.collection.parallel.immutable._

object ImmutableParallelContainer{
  def main (args: Array[String]) {

    //ParHashMap
    val phm = ParHashMap(1 -> 'a', 2 -> 'b')
    phm.get(1)

    println(phm.isParIterable)

    //ParHashSet
    val phs = new ParHashSet[Int]()
    val phs2 = ParHashSet(1,2,3)
    phs.take(0)
    phs2.contains(2)

  }
}