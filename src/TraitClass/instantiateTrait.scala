package TraitClass

/**
 * Created by junius on 15-3-2.
 */
trait IfInstantiatible {
  var name = "IfInstantiatible"
  def printName = println(name)
}

object instantiateTrait {
  def main (args: Array[String]) {
    // we can instantiate the trait like this way. give it a constructor like this.
    // here just an empty implementation.
    val ii = new IfInstantiatible {}

    //can't pass compilation if no {}
    // val ii = new IfInstantiatible

    // more complex constructor.
    val ii2 = new IfInstantiatible {
      name = "some name"
      printName
    }

  }
}
