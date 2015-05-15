import scala.collection.immutable

case class Node(s:Int, e:Int, row: Boolean){

}
val arr = Array('+','-','-','+','+','-','-','+','+','+')
def scanArray(a: Array[Char]) : List[Node] = {
  var l: immutable.List[Node] = Nil
  var s = -1
  (0 until 9).foreach(i => {
    if (a(i) == '-') {
      if (s == -1) s = i
    }
    else {
      if (s != -1) {
        l = new Node(s, i, true) :: l
        s = -1
      }
    }
  })
  l
}
scanArray(arr)
def getConMinus(arr: Array[Array[Char]]): List[Node] = {

  val l: immutable.List[Node] = Nil
  l
}