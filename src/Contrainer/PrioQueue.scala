package Contrainer

import scala.collection.mutable
import scala.math.Ordering

/**
 * Created by junius on 15-3-8.
 */
object PrioQueue {
  case class a(s: Int, e: Int, sum: Int){
    def > (other: a) = (sum > other.sum || (sum == other.sum && s < other.s )
      || (sum == other.sum && s == other.s && (e-s) < (other.e - other.s)))
    def < (other: a) = (sum < other.sum || (sum == other.sum && s > other.s )
      || (sum == other.sum && s == other.s && (e-s) > (other.e - other.s)))
    def == (other: a) = false

  }
  trait aOrdering extends Ordering[a] {
    def compare(a1: a, a2: a) = {
      if (a1 > a2) 1
      else if (a1 < a2) -1
      else 0
    }
  }

  def main (args: Array[String]) {


    val strs: Array[String] = readLine().split(" ")
    val N: Int = strs(0).toInt
    val K: Int = strs(1).toInt
    val o: aOrdering = new aOrdering {}
    val p: mutable.PriorityQueue[a] = new mutable.PriorityQueue[a]()(o)
  }
}
