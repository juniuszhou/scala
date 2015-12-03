object StringOps{
  def main (args: Array[String]) {
    //get a regex class via a string
    val hello = """baidu""".r
    //match all string in char sequence
    val res = hello.findAllIn("href=www.baidu.com")
    res.foreach(println)


    val str = "baidu"
    println(str)

    // init get all character of a string except last one.
    println(str.init)

    // replace via functional way
    def fix(s: String) = s.replace('b', '*').replaceFirst("c$", "#")

    def fix2(s: String) = Some(s.replace('b', '*')).map(s => if (s.endsWith("c")) s.init + "#" else s).get

    // embed a variable to string.
    val str2 = s"$str and goolge"
    println(str2)

    // format string.
    val str3 = "%s and %s".format("baidu", "google")
    println(str3)

    // embed a float variable to string.
    val f = 1.001
    println(f"This is $f string")

  }
}