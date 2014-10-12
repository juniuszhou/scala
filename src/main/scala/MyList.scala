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

    //
    l.foreach(println)

    println(l.take(3))

    val list=List(1 to 20 by 2)
    val list1=list++List(21,22)
    println("list1="+list1)
    val list2=22+:21+:list
    println("list2="+list2)


  }
}