object MyUnapply{
  class UnapplyClass{

  }

  object UnapplyClass{
    def apply(): Unit ={

    }

    def unapply(i: Int): Option[String] = {
      println("unapply was called.")
      Some("0")
    }
  }

  object Email{
    def unapply(str: String): Option[(String, String)] = {
      println("unapply was called.")
      val parts = str split "@"
      if (parts.length == 2) Some(parts(0), parts(1)) else None
    }
  }

  def main (args: Array[String]) {
    //instantiate object without new. compiler create object and apply method for case class.
    val i = 123
    //UnapplyClass.unapply()
    i match{
      case UnapplyClass("123") => println("matched")
      case _ => println("not matched")
    }

    val str = "jack@163.com"
    /* unapply will be translated into code following
      Email.unapply(str) match{
      case Some(username, address) =>  ...
      case None => ...
     */
    str match{
      case Email(username, address) =>  println("username: "+username+" address: "+ address);
      case _ =>  println("this is not an email address ");
    }

  }
}