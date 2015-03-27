import scala.collection.immutable.HashMap

val m = HashMap[Int, Int](1 -> 1)
val i: Option[Int] = m.get(2)
i match {
  case Some(j) => println(j)
  case None => println("none")
  case _ => println("error")
}

