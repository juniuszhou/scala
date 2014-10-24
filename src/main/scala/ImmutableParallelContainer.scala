import scala.collection.parallel.immutable._

object ImmutableParallelContainer{
  def main (args: Array[String]) {

    //ParHashMap
    val phm = ParHashMap(1 -> 'a', 2 -> 'b')
    phm.get(1)

    println(phm.isParIterable)

    //ParHashSet

  }
}