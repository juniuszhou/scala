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


  }
}