import scala.collection.immutable._

object ImmutableContainer{
  def main (args: Array[String]) {
    //List
    println("---------------------list-----------------------")
    val lst: List[Int] = 1 :: 2 :: 3 :: Nil
    println(lst)
    lst.map(println) //print all items since all items are valued.

    //Vector
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
    val stk = Stack(1,2)
    stk.push(3)
    stk.foreach(println)
    val stk2 = stk.tail
    stk2.foreach(println)


    //queue
    println("---------------------queue-----------------------")

    //red black tree
    println("---------------------red black tree-----------------------")

  }
}