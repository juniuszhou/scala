package Inheritance

/**
 * Created by junius on 14-12-24.
 */

abstract class AnParent(val dataMember: String){
  // junius, you can define either way as following.
  // because scala put method and data into same namespace.
  //
  //val dataMember: String
  //def dataMember: String
  def print = {println(dataMember)}
}

class AnChild(override val dataMember: String) extends AnParent(dataMember){

}
object InheritWithParameter {
  def main (args: Array[String]) {
    val child = new AnChild("I am child")
    child.print
    println(child.dataMember)
  }

}
