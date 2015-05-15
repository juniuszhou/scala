package Datatype

/**
 * Created by junius on 15-1-10.
 */
object MyIterator {
  def main (args: Array[String]) {
    //val i = 0
    val it = Iterator(1,2,3,4,5)
    // Iterator just a trait, why it can create an instance ?
    it.foreach(println)

    //map just create an new abstract iterator and the func not called.
    val it2 = it.map(println)
    it2.foreach(println)

  }
}
