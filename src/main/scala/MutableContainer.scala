import scala.collection.mutable
import scala.collection.mutable._
object MutableContainer{
  def main (args: Array[String]) {

    // val arm = AnyRefMap[Int](1 -> '1')

    // ArrayBuffer implemented in an array.
    println("---------------------ArrayBuffer-----------------------")
    val ab = ArrayBuffer(1,2,3)
    ab.append(4,5,6)

    // ArraySeq
    val as = ArrayStack(1,2,3)
    as.push(4)

    //

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
    println("---------------------StringBuilder-----------------------")
    val buf3 = new StringBuilder
    buf3 += 'a'

    //Linked Lists
    val buf4 = new mutable.LinkedList[Int]()
    val buf5 = mutable.LinkedList(1,2,3)
    buf5.append(LinkedList(4,5,6))
    val b = buf5.forall(i => i > 4)
    println(b)



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