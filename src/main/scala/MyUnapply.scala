object MyUnapply{
  class UnapplyClass(i: Int){

  }

  object UnapplyClass{
    def apply(): Unit ={

    }

    def unapply(i: Int): Option[Int] = {
      println("unapply was called.")
      Some(0)
    }
  }


  def main (args: Array[String]) {
    //instantiate object without new. compiler create object and apply method for case class.
    val i = 0
    //UnapplyClass.unapply()
    i match{
      case UnapplyClass(0) => println("matched")
      case _ => println("not matched")
    }
  }
}