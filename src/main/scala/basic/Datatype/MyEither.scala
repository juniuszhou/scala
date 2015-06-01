package basic.Datatype

/**
 * Created by juzhou on 7/2/2015.
 */
object MyEither {
def main (args: Array[String]) {
    def justE(b: Boolean): Either[Exception,String] = {
      if (b) Left(new Exception) else Right("ok")
    }

    // call we get exception when true, otherwise a "ok"
    val res = justE(true)
    res match {
      case Left(_) => println("we got exception")
      case Right(_) => println("we got value")
    }
  }
}
