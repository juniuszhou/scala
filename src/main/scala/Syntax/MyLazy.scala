package Syntax

/**
 * Created by juzhou on 8/6/2015.
 */
object MyLazy {
  def main (args: Array[String]) {
    def normalCall(i: Int) = {
      println("into normal call")
      println(i)
      println("exit normal call")
    }

    def lazyCall(i: => Int) = {
      println("into lazy call")
      println(i)
      println("exit lazy call")
    }

    def getI = {
      println("into getI")
      100
    }

    normalCall(getI)
    println("---------------------")
    lazyCall(getI)
  }
}
