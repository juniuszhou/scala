package basic.Operators

/**
 * Created by juzhou on 6/30/2015.
 */
object AllListOps {
  def main (args: Array[String]) {
    var lst = List(0,1,2)

    // ++ connect two same data structure
    lst ++= List(3,4,5)

    //
    lst.foreach(println)
  }

}
