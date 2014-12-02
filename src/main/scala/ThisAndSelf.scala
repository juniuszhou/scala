package main.scala

/**
 * Created by junius on 14-10-27.
 */

class ThisAndSelf{
  self =>
  def printName = {println("ThisAndSelf")}
  class InnerClass{
    def printInnerName = {println("InnerClass")}

    this.printInnerName

    self.printName

  }

  val inn = new InnerClass
  inn.printInnerName
  this.printName
}

object ThisAndSelf {
  def main (args: Array[String]) {
    val obj = new ThisAndSelf
    obj.printName
  }


}
