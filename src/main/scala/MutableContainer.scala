import scala.collection.mutable._
object MutableContainer{
  def main (args: Array[String]) {
    println("---------------------stack-----------------------")
    val stck = Stack(1,2,3)
    stck.push(4)
    stck.pop()
    stck.foreach(println)

    // Array Buffers implemented in an array.
    val buf = ArrayBuffer.empty[Int]
    buf += 1

    // List Buffers linked list
    val buf2 = ListBuffer.empty[Int]

    buf2 += 1

    // StringBuilders
    val buf3 = new StringBuilder
    buf3 += 'a'

    //Linked Lists

    //Double Linked Lists


     // Queues

     val queue = new scala.collection.mutable.Queue[String]

     queue += "a"

    // Array Sequences

     // Stacks

    // Array Stacks

     // Hash Tables

    // Hash sets and maps are used just like any other set or map. Here are some simple examples:

     val map = scala.collection.mutable.HashMap.empty[Int,String]
          map += (1 -> "make a web site")

      // Weak Hash Maps

      // Concurrent Maps

    // Mutable Bitsets
    val bits = scala.collection.mutable.BitSet.empty
    bits += 1



  }
}