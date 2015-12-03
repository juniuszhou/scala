import scala.collection.concurrent.TrieMap

object MyConcurrent{
  def main (args: Array[String]) {
    // concurrent thread-safe lock-free implementation of a hash array mapped trie.
    // it is mutable and support insert and update
    val map = TrieMap(1 -> '1', 2 -> '2').par
    map.foreach(pair => println(pair._1 + pair._2))
    //map.put(3) = '3'
    map.update(3, '4')

  }
}