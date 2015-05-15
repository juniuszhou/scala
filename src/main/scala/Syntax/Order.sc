import scala.util.Sorting
case class Init(init: Int, index: Int)

case class Node(indexOfInit: Int, indexOfRate: Int)

class NodeCompare extends Ordering[Init]{
  def compare(a: Init, b: Init): Int = a.init compare b.init
}

case class Rate(rate: Int, index: Int)

class RateCompare extends Ordering[Rate]{
  def compare(a: Rate, b: Rate): Int = a.rate compare b.rate
}



val arr = Array(0,1,2)
arr.filter(_ > arr(0))
Array.concat(arr, arr)

