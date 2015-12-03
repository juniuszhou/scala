package Grammar

object functor {
  def main (args: Array[String]) {
    // a function variable
    val abc = (a: String) => a.length
    println(abc("abc"))

    // a method definition.
    def cba = (a: String) => a.length
    println(cba("abc"))

    def bcd(a:String) = a.length
    println(bcd("bcd"))

    // not valid format
    // val bcd(a:String) = a.length

    // value from code block
    val cde = {
      100
    }

    def dde = (i:Int) => {
      i+1
    }

    println("--------------------------")

    def functorPar(body: => Int) = {
      //body
      println("body called")
    }

    def strLen(s: String): Int = s.length
    val ff = functorPar(strLen("hello"))

    // other way to call functorPar
    val gg = functorPar {
      println("into body")
      100
    }

    println("--------------------------")
    // not functor parameter, just pass by reference. lazy evaluation.
    def functorPar2(body: => Int) = {
      body
      println("body called")
    }
    val ff2 = (i: Int) => {
      println("into ff2 body")
      i + 1
    }
    val fg = functorPar(ff2(100))

    println("--------------------------")
    def functorPar3(body: (Int) => Int) = {
      println(body(100))
    }

    def bb(i:Int):Int = i+1

    functorPar3(bb)

    println("--------------------------")
  }
}
