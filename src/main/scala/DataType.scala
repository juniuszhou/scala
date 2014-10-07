object DataType{
  def main(args: Array[String]) {
    val i:Int=0
    val l:Long=0L
    val d:Double=0.0
    val b:Boolean=true
    val f:Float=0.0f
    val c:Char='a'
    val by:Byte=0
    val s:String="hello"

    val a:Any=null
    val ar:AnyRef=null

    //all operator in scala implemented as method
    val five=5
    println(five.+(5))



    //Tuple
    val tup=(1,2)
    tup._1 + tup._2
    println("hello world")
  }
}