package main.scala

/**
 * Created by junius on 15-4-14.
 */

class parent {}
class child extends parent {}
class childTwo extends parent {}
class myContainer[T](var head: T){
  def append[A >: T](a: A): Unit = {

  }
  def setHead[A >: T](a: A) = {
    var b = a
    b = head
    // head = b
  }

}
object Covariant {
  def main(args: Array[String]) {
    val arr = List[parent]()
    val arr2 = new child() :: arr

    val con = new myContainer[parent](new child())
    con.append(new child()) // we can add even no +T

    con.setHead(new childTwo())

    println("hello world")
  }
}
