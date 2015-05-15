package Syntax

/**
 * Created by juzhou on 4/22/2015.
 */
object TrySimple {
  def main (args: Array[String]) {
    val a1 = Array[Int](10)
    val a2 = Array[Int](10)
    a1.zip(a2).map(p => p._1 + p._2)
  }
}
