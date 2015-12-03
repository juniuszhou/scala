package Syntax

object TrySimple {
  def main (args: Array[String]) {
    def quickSort(arr: List[Int]): List[Int] = {
      if (arr.length < 2) arr else {
        val mid = arr.head
        val left = arr.filter(i => i < mid)
        val right = arr.filter(i => i > mid)
        val mm = arr.filter(i => i == mid)
        quickSort(left) ::: quickSort(mm) ::: quickSort(right) ::: Nil
      }
    }

    val arr = List(1,100,4,9,2,34,22,35,68)
    val sorted = quickSort(arr)
    sorted.foreach(i => print(i + " "))
    println()
  }
}
