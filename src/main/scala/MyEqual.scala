object MyEqual{
  case class Point(var x:Int, var y:Int){
    def Double: Unit = {
      x += 2
      y += 2
    }

    override def canEqual(obj: Any): Boolean = {
      obj match {
        case Point => true
        case _ => false
      }
    }

    /*
    def canEqual(obj: AnyRef): Boolean = {
      obj match {
        case Point => true
        case _ => false
      }
    }
    */

  }
  def main(args: Array[String]) {
    val a = null
    val b = 0
    // == sign in scala can deal with null
    println(a == b)
    println(a == null)

    //equal compare the value for primitive type
    val c = 15
    if (c.equals(15)) println("equal") else println("not equal")

    //eq compare the address.
    val d: Integer = 15
    if(d.eq(new Integer(15))) println("eq") else println("not eq")


  }
}