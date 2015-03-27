package Hacker

/**
 * Created by juzhou on 3/10/2015.
 */
class First {
  def getFirst = "I am first"
}
object First{

  def printFirst = println("I am first")

  def main (args: Array[String]) {
    val l = List(0,1,2)
    l.reduce(_+_).toString

  }
}
