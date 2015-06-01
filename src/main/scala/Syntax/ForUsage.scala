package Syntax

/**
 * Created by juzhou on 3/20/2015.
 */
object ForUsage {
  def main(args: Array[String]) {
    for (x <- List(1, 2, 3)) {
      println(x)
    }

    for (x@2 <- List(1, 2, 3)) {
      println(x)
    }

    for ((name, "male") <- Set("zhou" -> "male", "yuan" -> "female")) {
      println(name)
    }

    // for Function, the input parameter is contravariant the output is covariant.
    // val f: Function2[Int, Int, Int] = (a, b) => a + b
    def f(a:Int, b:Int):Int = a+b

    //high stage function
    def f2() = (a: Int, b: Int) => { println(a,b); a + b }
    f2()(1,2)

    // array doesn't support covariance
    var arr: Array[Object] = null
    // assignment not allowed.
    // arr = new Array[String](1)

    def forYield() = {
      // for yield, it we loop on list then result is list.
      // if loop on array then result is array. since it will be translated to map and flatmap.
      val alist = for(i <- List(0,1,2)) yield i
      alist.foreach(println)
    }


  }
}
