package HackerRank

import scala.collection.mutable
import scala.util.Sorting

class Node(id: Int, v: Long) {
  val index: Int = id
  val value: Long = v
  var children : List[Node] = Nil
}
class NodeComparator extends Ordering[Node] {
  def compare(n:Node, that: Node) = n.value compare that.value
}

object Solution {
  def getAllChild(id: Int, m: mutable.HashMap[Int, Node]): List[Node] = {
    //println(" id child " + id);
    val localRoot: Option[Node] = m.get(id)
    val root: Node = localRoot.get

    def recur(n: Node): List[Node] = {
      if (n == null) Nil
      else {
        // println("recur id child " + n.index);
        var result = List[Node]()
        n.children.foreach(node => result = result ::: recur(node))
        n :: result
      }
    }
      // println("recur id child " + n.index);
      var result = List[Node]()
      root.children.foreach(node => result = result ::: recur(node))
      result
  }

  def main(args: Array[String]) {
    def binary(arr: Array[Node], l: Int, r: Int, rank: Int): Node = {
      //Thread.sleep(1000)
      //println(l,r,rank)
      //arr.foreach(n => print(n.index, n.value, " "))
      //println()

      // if (rank == 1) return arr(mp)
      if (l >= r) return arr(l)
      if (r - l == 1) {
        val min = if (arr(l).value > arr(r).value) arr(r) else arr(l)
        val max = if (arr(l).value < arr(r).value) arr(r) else arr(l)
        if (rank == 0) return min else return max
      }

      val mid = arr(l)
      def pos():Int = {
        var li = l
        var ri = r

        while (ri > li){
          while(arr(ri).value >= mid.value && ri > li) ri -= 1
          if (ri > li) arr(li) = arr(ri)
          //arr.foreach(n => print(n.index, n.value, " RRR"))
          //println()
          while(arr(li).value <= mid.value && ri > li) li += 1
          if (ri > li) arr(ri) = arr(li)
          //arr.foreach(n => print(n.index, n.value, " LLL"))
          //println()
        }
        arr(li) = mid
        //arr.foreach(n => print(n.index, n.value, " MMM"))
        //println()
        li
      }
      val mp = pos()
      //println("current mp is " + mp)
      //arr.foreach(n => print(n.index, n.value, " "))
      //println()

      if (mp == rank) return arr(mp)
      if (mp > rank) binary(arr, l, mp-1, rank) else binary(arr, mp+1, r , rank - mp - 1)
    }

    val inputs = readLine().split(" ").map(_.toInt)
    val (n, q) = (inputs(0), inputs(1))
    var l: List[(Int, Int)] = Nil
    val m = mutable.HashMap[Int, Node]()
    (0 until n-1).foreach(i => {
      val ins = readLine().split(" ").map(_.toInt)
      l = (ins(0), ins(1)) :: l
    })

    //println(l)
    // add a useless item to simply index op.
    val values = (-1 + " " + readLine()).split(" ").map(_.toLong)
    l.foreach(cp => {
      val node = m.get(cp._2) // get parent
      node match {
        case Some(n) => {
          val cnode = m.get(cp._1)
          cnode match {
            //child exist then just create the relationship.
            case Some(inNode) => {
              n.children = inNode :: n.children
            }
            case None => {
              val tmp = new Node(cp._1, values(cp._1))
              n.children = tmp :: n.children
              m.put(cp._1, tmp)
            }
          }
        }
        case None => {
          val pn = new Node(cp._2, values(cp._2))
          val cnode = m.get(cp._1)
          cnode match {
            case Some(inNode) => pn.children = inNode :: pn.children
            case None => {
              val tmp = new Node(cp._1, values(cp._1))
              m.put(cp._1, tmp)
              pn.children = tmp :: pn.children
            }
          }
          m.put(cp._2, pn)
        }
      }
    })

    // the scope, l is zero and r is len - 1


    var lastOutput = 0
    (0 until q).foreach(i => {
      val pair = readLine().split(" ").map(_.toInt)
      val (id, rank) = (pair(0), pair(1))
      //println("id and rank",id,rank)
      val nid = lastOutput + id
      val l = getAllChild(nid, m)
      val arr = l.toArray
      val s = Sorting.quickSort(arr)(new NodeComparator)
      lastOutput = arr(rank-1).index

      //lastOutput = binary(l.toArray, 0, l.size-1, rank-1).index
      println(lastOutput)
      //println("___________________")

    })
  }
}
