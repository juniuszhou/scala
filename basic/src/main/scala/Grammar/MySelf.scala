package Grammar

/**
 * http://stackoverflow.com/questions/19821827/scala-self-type-annotation
 * The self type annotation generally has two purposes:
1. Enforce a certain base class/trait and ensure that your class
or trait can only be inherited by or mixed into that type, and
2. Reference an exterior case when implementing an inner case.
(If it wasn't for this syntax, what would 'this' refer to?)
 *
 */

class OutterClass {
  self =>
  class InnerClass{
    def innPrint = {
      println(this.getClass + " VS " + self.getClass)
    }
  }

  val i = new InnerClass
  def printAll = i.innPrint
}

trait student {
  def name: String
}

trait boy{
  // enforce sub class mix or implement student trait. and boy can use the
  // data member defined in student class.
  self: student =>
  def printName = {
    println(name)
  }
}

class chineseBoy extends boy with student{
  def name = "chinese boy"
}

object MySelf {

  def main (args: Array[String]) {
    val i: OutterClass = new OutterClass
    i.printAll
  }
}
