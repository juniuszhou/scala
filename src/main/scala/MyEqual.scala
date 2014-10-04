object MyEqual{
  def main(args: Array[String]) {
    val a = null
    val b = 0
    // equal in scala can deal with null
    println(a == b)
    println(a == null)
  }
}