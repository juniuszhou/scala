package main.scala

/**
 * Created by junius on 14-11-17.
 */
object PartialFunc {
  def main (args: Array[String]) {
    // Partial applied function.
    def addTriple(a: Int)(b: Int)(c: Int): Int ={
      a + b + c
    }

    // applied two parameters
    def PartialAppliedFunc = addTriple(1)(2)(_)

    // print 6
    println(PartialAppliedFunc(3))

    // Partial function. just deal with the part of all data sets.
    // for instance, just deal with positive.
    // Note, since PartialFunction is already a type of function.
    // so here you should use val instead of def. you can't see () for parameter definition.
    val dealPositive: PartialFunction[Int, Int] = {
      case x if x > 1 => 1
      case x if x < -1 => -1
    }

    println(dealPositive(2))
    println(dealPositive(-2))
    println(dealPositive(0))

   // def addZeroDeal: PartialFunction[Int, Int] = dealPositive.orElse(
      //case 0 => 0
    //)



  }

}
