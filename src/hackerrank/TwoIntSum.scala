package hackerrank

import scala.util.Random

/**
 * Created by junius on 15-3-3.
 */
object TwoIntSum {
  case class pair (val value: Int, val index: Int){
    def > (other: pair): Boolean = value > other.value || (other.value == value && index > other.index)
    def == (other: pair): Boolean = other.value == value && other.index == index
    def < (other: pair): Boolean = value < other.value || (other.value == value && index < other.index)
    override def toString() = value + " " + index + " "
  }
  def quickSort(arr: Array[pair]) : Array[pair] = {
    if (arr.length <= 0) arr

    else {
      val pivot = arr(arr.length / 2)
      Array.concat(quickSort(arr.filter(pivot >)), arr.filter(pivot ==), quickSort(arr.filter(pivot <)))
    }
  }

  def quickSort(arr: Array[Int]) : Array[Int] = {
    if (arr.length <= 0) arr

    else {
      val pivot = arr(arr.length / 2)
      Array.concat(quickSort(arr.filter(pivot >)), arr.filter(pivot ==), quickSort(arr.filter(pivot <)))
    }

  }


  def main(args: Array[String]) {
    val arr: Array[Int] = new Array[Int](10)
    val r = new Random()
    (0 until 10).foreach(arr(_) = r.nextInt(100))
    arr.foreach(println(_))
    quickSort(arr).foreach(i => print(i + " "))
    println()
    var index = 0
    val m: Array[pair] = arr.toList.map(i => {
      val p = pair(i, index)
      index += 1
      p
    }).toArray
    quickSort(m).foreach(p => print(p.toString()))

  }
}
