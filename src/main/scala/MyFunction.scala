object MyFunction{
  def main(args: Array[String]) {
    def funcWithoutResult(i: Int) {println(i)}
    def funcWithResult(i: Int) = {println(i)}

    val i = 1
    funcWithoutResult(i)
    funcWithResult(i)


  }
}