object MutableClass{
  class MyMutableClass{
    var x = 2
    var y = 2
    def Double {
      x *= 2
      y *= 2
    }
    override def toString = {x.toString + " and " + y}
  }
  def main (args: Array[String]) {
    //mmc as reference is immutable but object is mutable.
    val mmc = new MyMutableClass
    println(mmc.toString)
    mmc.Double
    println(mmc.toString)

  }
}