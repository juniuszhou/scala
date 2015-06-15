package Syntax

/**
 * Created by juzhou on 5/29/2015.
 */

abstract class NoExplicitReturnTypeP {
  def f: Int
}

class NoExplicitReturnTypeC extends NoExplicitReturnTypeP {
  //for override function, we can ignore its return type in definition.
  override def f = {1}
}
object NoExplicitReturnType {
  def main (args: Array[String]) {

  }
}
