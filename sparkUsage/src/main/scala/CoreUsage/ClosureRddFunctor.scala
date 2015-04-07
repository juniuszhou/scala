package CoreUsage

import org.apache.spark.SparkContext
import CoreUsage.RddGenerator

/**
 * Created by junius on 15-3-31.
 */
object ClosureRddFunctor {
  def main (args: Array[String]) {
    val sc = new SparkContext("local[4]", "Simple App")
    val rdd = RddGenerator.GenerateFromCollection(sc)
    var s = "abc"

    // the varialbe must be bound when set the function as parameter.

    rdd.map(item => item + s).collect().foreach(println)
    s = "dbc"
    println("++++++++++++++++++" + s)

    sc.stop

  }

}
