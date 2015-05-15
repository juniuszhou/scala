class MyApply{
  def apply() = {println("I am apply method.")}
}

object MyApply{
  def main(args: Array[String]) {
    val myApply = new MyApply
    myApply()

  }
}