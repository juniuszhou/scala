package CoreUsage

import org.apache.spark.SparkContext

/**
 * Created by junius on 15-1-15.
 */
object MyBroadcast {
  def main (args: Array[String]) {
    //val sc = new SparkContext("local[4]", "Simple App")
    // myCombineByKey(sc)
    //val bc = sc.broadcast[String]("junius")

    // start 4 local thread, or 4 worker in cluster to print data 1 to 10.
    // but set the broadcast value as prefix. so worker just get bc 's value.
    // then data from driver send to cluster is transparent for developer.
    //sc.parallelize(1 to 10, 4).map(x => println(bc.value + " " + x)).count()
    // println(bc.value)

    // Torrent broadcast as default type. configurable in configure file.
    //sc.stop()
  }
}
