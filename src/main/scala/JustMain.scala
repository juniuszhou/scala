object JustMain {

  val i = 100
  println(i)
  def main (args: Array[String]) {
    val arr = GetArray.get()
    arr.filter(_ != null).foreach(println)
  }
}




