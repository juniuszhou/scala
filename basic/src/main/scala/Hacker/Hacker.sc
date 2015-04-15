import scala.collection.mutable
import scala.collection.mutable.HashMap
class Node(v: Int, i: Int){
  var s: String = _
  var parent: Int = 0
  var child: Int = 0 // number of child visited.
  var sum: Int = 0
  val id: Int = 0
  val value:Int = v
}

val l = mutable.MutableList(1,2)
val t = l.tail
l += 3
t.length
t
l










