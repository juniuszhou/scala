package TraitClass

/**
 * Created by junius on 14-12-27.
 */
case class TryCopy(val a: String, val b: String){

}
object CaseClass {
  def main (args: Array[String]) {
    val t1 = TryCopy("a", "b")
    // copy is auto created method for case class.
    val t2 = t1.copy()

    println(t2.toString)
  }
}
