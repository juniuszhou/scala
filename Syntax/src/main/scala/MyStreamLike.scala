package Syntax

/**
 * Created by juzhou on 3/19/2015.
 */
class MyStreamLike(l: List[Int]){
  def productElement(i: Int) : Any = {}
  var data = l
  // def take(i: Int) = {data.take}
}

object MyStreamLike {

  def connect(i: Int, l: => MyStreamLike) : MyStreamLike = {
    //data = i :: l.data
    new MyStreamLike(i :: l.data)
  }

  def main (args: Array[String]) {
    def constance(i: Int): MyStreamLike = connect(i, constance(i))
    println(constance(1).data.take(5))

  }
}
