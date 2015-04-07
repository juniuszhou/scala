object MyPattern{
  class Patt{

  }
  object Patt{
    def apply() = {
      println("apply called")
      new Patt
    }

    def unapply(i: Int): Option[Int] = {
      println("unapply called")
      Some(48)
    }
  }

  object Twice {
    def apply(x: Int): Int = {
      println("Twice apply called")
      x * 2
    }
    def unapply(z: Int): Option[Int] = if (z%2 == 0) {
      println("Twice unapply called.")
      Some(z / 2)
    }
      else None
  }


  def main (args: Array[String]) {
    val pt = Patt()
    pt match{
      case _: Patt => println("Patt matched")
      case _ => println("not matched")
    }

    val i = 48
    i match{
      case Patt(48) => println("Patt matched")
      case _ => println("not matched")
    }


    val x = Twice(21)
    x match { case Twice(n) => Console.println(n) } // prints 21
  }
}