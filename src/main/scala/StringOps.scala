object StringOps{
  def main (args: Array[String]) {
    //get a regex class via a string
    val hello = """baidu""".r
    //match all string in char sequence
    val res = hello.findAllIn("href=www.baidu.com")
    res.foreach(println)


    val str = "baidu"
    println(str)
  }
}