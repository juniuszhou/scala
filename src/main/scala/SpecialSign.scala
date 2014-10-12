/**
 * Created by junius on 14-10-13.
 */
object SpecialSign {
  def main (args: Array[String]) {
    println((1 to 20 by 2)toString())
    // range
    val l = List(1 to 20 by 2: _*)
    l.map(println)
    val l2 = List(1 to 20: _*)
    l2.map(println)
  }

}
