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
  }
}