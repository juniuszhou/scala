package basic.Contrainer

import scala.collection.LinearSeq
import scala.collection.immutable.{SortedMap, SortedSet}
/**
 * to show if we instantiate object via interface.
 * which real class will be created.
 */
object DefaultContainer {
  def main (args: Array[String]) {
    val l = Seq[Int](1,2,3) // default is list
    println(l)

    val v = IndexedSeq[Int](1,2,3) // default is vector
    println(v)

    val ll = LinearSeq[Int](1,2,3) // same with Seq. default is list.
    println(ll)

    val s = Set[Int](1,2,3,4,5,6,7,8,9,10) // hashset if length over 4
    println(s)

    val m = Map[Int, Int]((1,2),(11,2),(21,2),(31,2),(41,2),(51,2)) //hashmap if length over 4
    println(m)


    val ss = SortedSet[Int](1,2,3,4,5,6,7,8,9,10)
    // treeset if length over 4. and tree set is only implemented class in sdk
    println(ss)

    val sm = SortedMap[Int, Int]((1,2),(11,2),(21,2),(31,2),(41,2),(51,2))
    //treemap if length over 4. and tree map is only class in sdk.
    println(sm)
  }
}
