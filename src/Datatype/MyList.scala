object MyList{
  def main(args: Array[String]) {
    val l: List[Int] = 1 :: 2 :: Nil
    l.map(println)

    //implicit match
    val m: List[Option[Int]] = Some(1) :: Some(2) :: Nil
    m.map {
      case Some(x:Int) => println(x)
      case None => println("Nothing")
    }

    // difference of foreach and map
    println("---------------------difference of foreach and map---------------------")
    val l2: List[Int] = 1 :: 2 :: Nil
    val l3 = l2.foreach(_ + 2)
    // foreach just apply a func to each item, got nothing
    println(l3.getClass.toString)
    // map apply func to each item, then return a give size list. each item is
    // the result of apply func to one item.
    val l4 = l2.map(_+2)
    l4.map(println)

    // junius so the point is if just print all items of a list. of course, the foreach
    // much faster then map. if you need generate a list result map is the choice.

    // iterator just for once.
    val l5: List[Int] = 1 :: 2 :: Nil
    l5.iterator.foreach(println)

    println(l.take(3))

    val list=List(1 to 20 by 2)
    val list1=list++List(21,22)
    println("list1="+list1)
    val list2=22+:21+:list
    println("list2="+list2)


  }
}