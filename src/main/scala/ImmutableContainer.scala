import scala.collection.immutable.List
import scala.collection.immutable.Vector
import scala.collection.immutable

object ImmutableContainer{
  def main (args: Array[String]) {
    //List
    println("---------------------list-----------------------")
    val lst: List[Int] = 1 :: 2 :: 3 :: Nil
    lst.map(print) //print all items since all items are valued.
    println()
    lst.drop(1).map(print) //drop the first item
    println()
    lst.take(2).map(print) //get first two items
    println()

    //Vector
    /*
    Vectors are represented as trees with a high branching factor
    (The branching factor of a tree or a graph is the number of children at each node).
    Every tree node contains up to 32 elements of the vector or contains up to 32 other tree nodes.
    Vectors with up to 32 elements can be represented in a single node.
    Vectors with up to 32 * 32 = 1024 elements can be represented with a single indirection.
    Two hops from the root of the tree to the final element node are sufficient for vectors with up to 215 elements,
    three hops for vectors with 220, four hops for vectors with 225 elements and five hops for vectors with up to 230 elements.
    So for all vectors of reasonable size, an element selection involves up to 5 primitive array selections.
     This is what we meant when we wrote that element access is “effectively constant time”.
     */
    println("---------------------vector-----------------------")
    val vec = Vector(1,2,3)
    vec.take(1)

    //Stream, similar with List but item value is lazy
    println("---------------------stream-----------------------")
    val strm = 1 #:: 2 #:: 3 #:: Stream.empty
    strm.map(println) // just print first item since just it is valued.
    strm.foreach(println) // print all items

    println(strm)


    //Range
    println("---------------------range-----------------------")
    val rang = 0 to 12 by 2
    rang.foreach(println)

    //stack
    println("---------------------stack-----------------------")
    val stk = immutable.Stack(1,2)
    stk.push(3)
    stk.foreach(println)
    val stk2 = stk.tail
    stk2.foreach(println)



    println("---------------------queue-----------------------")
    //queue
    val qu = immutable.Queue(1,2,3)
    qu.apply(0)
    qu.find(i => i > 2)
    qu.front
    qu.head

    //red black tree
    println("---------------------red black tree-----------------------")
    //tree set implemented in red black tree
    val ts = immutable.TreeSet(1,2,3)
    println(ts.firstKey)


    //tree map implemented in red black tree
    println("---------------------tree map-----------------------")
    val tm = immutable.TreeMap(1 -> 'a', 2 -> 'b')
    tm.foreach(item => println(item._1.toString + item._2))


    //hash trie
    /*
    Their representation is similar to vectors in that they are also trees where every node has 32 elements or 32 subtrees.
     But the selection of these keys is now done based on hash code.
     For instance, to find a given key in a map, one first takes the hash code of the key.
     Then, the lowest 5 bits of the hash code are used to select the first subtree,
     followed by the next 5 bits and so on. The selection stops once all elements stored in a node have hash codes
     that differ from each other in the bits that are selected up to this level.
     */

    //hash map implemented in hash trie
    println("---------------------hash map-----------------------")
    val hm = immutable.HashMap(1 -> 'a', 2 -> 'b')
    hm.foreach(println)

    //hash set implemented in hash trie
    println("---------------------hash set-----------------------")
    val hs = immutable.HashSet(1,2,3)
    hs.foreach(println)

    //list map, implemented in an array. low efficient except frequently get the first item.
    val lmp = immutable.ListMap(1 -> 'a', 2 -> 'b')
    println(lmp.get(1))

    //bit set, implemented in an array of 64-bit Longs.
    val bs = immutable.BitSet(1024)
    println(bs.firstKey)
  }
}