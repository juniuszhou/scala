package Grammar

/**
 * Created by junius on 14-12-6.
 */
object MyTypeOf {
  abstract class Bar {
    type T <: AnyRef
    def bar(x: T) {
      println("5: " + x.getClass())
    }
  }
  def main(args: Array[String]) {
    println("1: " + args.getClass())
    println("2: " + classOf[Array[String]])
    new Bar {
      type T = Array[String]
      val x: T = args
      println("3: " + x.getClass())
      println("4: " + classOf[T])
    }.bar(args)

    /*
      the output in console.
      scala> classOf[String]
      res1: Class[String] = class java.lang.String
    */

    println(classOf[String])
    println(classOf[Array[String]])

  }
}
