package Hacker

// _root_ represent the absolute path

import _root_.scala.collection.immutable.HashMap

object ImportRoot {
  def main(args: Array[String]) {
    val h: HashMap[Int, Int] = null

    //usage of span
    val s = "oookooook"
    val (l, r) = s.span(_ == s(0))
    l.foreach(println)
    println()
    r.foreach(println)

    // stream.
    var sm = Stream(1,2,3)
    println(sm.toList.length)
    sm = 4 #:: sm
    sm.foreach(i => print(i))
    println()
    val l1 = sm.toList
    println(l1.length)
    // sm.append()
    (0 to 100).foreach(i => sm = i #:: sm)

    println(sm.toList.length)
  }
}
