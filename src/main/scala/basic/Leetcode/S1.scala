package Leetcode

import scala.collection.mutable.HashMap

/**
 * Created by junius on 15-2-26.
 */
object S1 {
  private class Solution{
    def ifTwoSameVal(a: Array[Int], v: Int): Boolean ={
      a.filter(i => (i == v)).length > 1
    }
    def twoSum(a: Array[Int], b: Array[Int], c: Int): Tuple2[Int, Int] ={
      val m = new HashMap[Int, Int]()
      var index: Int = 0
      a.foreach{
          i => m.put(i, index)
          index = index + 1
      }
      index = 0
      for(i <- b){
        val gap = c - i
        if (m.contains(gap))
          return (index, m.get(gap).get)
      }

      return (0,1)
    }
  }

  def main (args: Array[String]) {
    val s = new Solution

    val (a, b) = s.twoSum(null, null, 0)
    println(" " + a + " and " + b)
  }
}
