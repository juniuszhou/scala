object MyOption{
  def main (args: Array[String]) {
    var str: Option[String] = None
    println(str.getOrElse())
    str = Some("hello")
    println(str.getOrElse())

    //option also like a container in scala, so we can call foreach
    //even it mostly has just one object.
    str.foreach(println(_))

    str.filter(str => true)


  }

}