package Syntax

//how to define a data member with the same type as me.
//or the type is my subtype. in this way, we can do it.
abstract class parentCont[T <: parentCont] {
  val mine: T

  //other usage is a data member or method take it as template type.
}

class selfContainTemplateClass extends parentCont {
  val mine: selfContainTemplateClass = new selfContainTemplateClass
}

object selfContainTemplateClass {
  def main (args: Array[String]) {
    val s = new selfContainTemplateClass

  }
}