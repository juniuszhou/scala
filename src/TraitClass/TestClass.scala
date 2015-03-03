package TraitClass

/**
 * Created by junius on 15-1-16.
 */
trait Row {
  def printRow = println("Row")
}

object TestClass {
  def main (args: Array[String]) {
    val c =  new ClassPrivate
    val r = new Row{}
    r.printRow
    // val r2 = new Row

    // package private method can be called in same package.
    c.printName
  }
}
