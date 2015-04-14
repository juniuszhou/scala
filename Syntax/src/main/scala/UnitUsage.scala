package Syntax

/**
 * Created by juzhou on 3/16/2015.
 */
object UnitUsage {
  def main (args: Array[String]) {
    // the difference between Unit and Nothing. if method as Unit, you can return.
    // ant the value returned is (). but if as Nothing, you can put return in you function
    // body. since Nothing has no any instance.
    def met: Unit = {return ;}
    // Unit is child class of all types. so
    val a: Unit = 1
    println(a)

    //Null is a trait we can instantiate it.
    //val n = new Null{}
    // null is null pointer. it is only instance of Null by scala
    val str = null
    //println(n)

    // Nil is empty list
    val l = Nil
    println(l)

    //Nothing is subtype of every class except the plain integer and double.
    // Nothing used when a function never return
    val l1: List[Int] = List[Nothing]()

    //None is sub type of Option
    val opt = Option[String]("abc")
    opt match {
      case None => println("none ")
      //case Some => println("sth here")
    }

    // iterator of tuple
    val tup = Tuple3(0,1,2)
    tup.productIterator.foreach(println)

  }
}
