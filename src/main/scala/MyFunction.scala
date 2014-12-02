object MyFunction{
  def main(args: Array[String]) {
    def funcWithoutResult(i: Int) {println(i)}
    def funcWithResult(i: Int) = {println(i)}

    val i = 1
    funcWithoutResult(i)
    funcWithResult(i)

    def returnFalse = {
      println("returnFalse")
      false
    }
    def funcCallByName(i: => Boolean, j : Boolean): Unit ={
      // you can see i not really called. if call by name

    }

    def funcWithMultipleParamters(x: Int*): Unit ={
      println(x.getClass)
      x.map(println)
    }

    funcWithMultipleParamters(1,2,3)
    funcCallByName(returnFalse, returnFalse)
  }
}