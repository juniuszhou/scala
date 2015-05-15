package algorithm
import scala.collection.immutable.Vector

object Sort {
  def QuickSort(data: Vector[Int]) : Vector[Int] = {
    if (data.size < 2) {
      data
    }
    else {
      val pivot = data(0)
      QuickSort(data.filter(pivot >)) ++ data.filter(pivot ==) ++ QuickSort(data.filter(pivot <))
    }
  }

  def QuickSort(data: List[Int]): List[Int] = {
    if (data.size < 2) {
      data
    }
    else {
      val pivot = data(0)
      QuickSort(data.filter(pivot > )) ++ data.filter(pivot ==) ++ QuickSort(data.filter(pivot <))
    }
  }

  def main (args: Array[String]) {
    val data = Vector(1,3,5,7,9,2,5,7,9,2,4,6,8)
    val data2 = List(1,3,5,7,9,2,5,7,9,2,4,6,8)

    QuickSort(data).map(println)
    QuickSort(data2).map(println)

  }

}
