package Hacker

import scala.collection.mutable.HashMap

/**
 * Created by juzhou on 3/16/2015.
 */
object ForSugar {
  class a{override def hashCode() = {println("it is a hashcode"); super.hashCode()}}
  class b{override def hashCode() = {println("it is b hashcode"); super.hashCode()}}

  def main (args: Array[String]) {
    val m = new HashMap[a,b]
    m.put(new a, new b)
    println("+++++++++++++++++")
    // put tmp = a1 inside the loop instead of for() block. will be more efficient.
    // we can avoid for expanded to map and generate middle outcome even without yield.
    for((a1,b1) <- m; tmp = a1){
      println(b1)}
  }
}
