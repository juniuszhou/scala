package Contrainer

/**
 * Created by juzhou on 8/6/2015.
 */
object MyArray {
  def main (args: Array[String]) {
    // fill with fixed value. the value is passed with lazy reference.
    Array.fill(10)(0).foreach(print)
    println()
    println("-----------------")

    // fill two dimension array with fixed value.
    Array.fill(2, 10)(0).foreach(arr => arr.foreach(print))
    println()
    println("-----------------")

    // fill with type
    Array.fill[String](10)("zero")

    //tabulate accept a functor as parameter.
    Array.tabulate[Int](10)(_ => 0).foreach(print)
    println()
    println("-----------------")

    // always recursive support
    val arr = Array(1)
    println(arr.size)  //size always equal to length.
    println(arr.length)
    arr.head
    arr.tail
    arr.tails
    println("-----------------")

    //item always mutable
    arr.update(0, 100)

    // link with any container
    (arr ++ List(1,2)).foreach(println)

    println("-----------------")
    //hash code
    print("array hash code is ")
    println(arr.##)

    println("-----------------")

    //generate a new array add item as head.
    arr.+:(4).foreach(println)
    arr.foreach(println)

    //
    arr.++:(Array(2)).foreach(println)

    // group by item 's value. an ops function also acceptable
    arr.groupBy((i:Int) => i)
    arr.groupBy(_ / 10 ) // group according its higher number except last one.

    println("------------------------------")
    // fold ops, change 2 dimension to 2 dimension
    val arr1 = Array(
      Array[Double](0.1, 0.2, 0.3, 0.4, 0.0), // topic 0
      Array[Double](0.5, 0.05, 0.05, 0.1, 0.3), // topic 1
      Array[Double](0.2, 0.2, 0.05, 0.05, 0.5) // topic 2
    )
    println(arr1.fold(Array.empty)(_ ++ _))

  }
}
