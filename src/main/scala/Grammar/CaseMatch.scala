package Grammar

/**
 * Created by juzhou on 11/5/2015.
 */
object CaseMatch {
  def main (args: Array[String]) {
    val a = Option[String]("100")
    a match {
      case Some(str) => 100
      case None => Nil
    }
  }
}
