package HackerRank

object Solution2 {

  def main(args: Array[String]) {
    def distance(p1: (Int, Int), p2: (Int, Int)): Double = {
      Math.sqrt(Math.pow(Math.abs(p1._1 - p2._1), 2.0) + Math.pow(Math.abs(p1._2 - p2._2), 2.0))
    }

    def rate(p1: (Int, Int), p2: (Int, Int)): Double = {
      (p1._2 - p2._2).toDouble / (p1._1 - p2._1).toDouble
    }

    // minus is left. plus is right.
    def turnLeft(p1: (Int, Int), p2: (Int, Int), p3: (Int, Int)): Boolean = {
      val l1 = (p2._1 - p1._1, p2._2 - p1._2)
      val l2 = (p3._1 - p2._1, p3._2 - p2._2)
      val cross = l1._1 * l2._2 + l1._2 * l2._1
      cross < 0
    }
    println(turnLeft((1, 1), (2, 2), (1, 2)))


    def findBottom(l: List[(Int, Int)]): (Int, Int) = {
      var bot = Int.MaxValue
      l.foreach(p => bot = Math.min(p._2, bot))
      l.filter(p => p._2 == bot).sortBy(_._1).head
    }

    def getList(n: Int): List[(Int, Int)] = {
      var l = List[(Int, Int)]()
      (0 until n).foreach(i => {
        val strs = readLine().split(" ").map(_.toInt)
        l = (strs(0), strs(1)) :: l
      })
      l
    }

    val n = readLine().trim.toInt
    if (n < 2) {
      println(0); return
    }

    var l = getList(n)
    val bot = findBottom(l)

    val sort = l.map(p => (p._1, p._2, rate(bot, p))).sortBy(_._3)

    sort.foreach(i => println( "after sort " + i))


    l = bot :: Nil

    def pushOne(p: (Int, Int)): Unit = {
      println("push " + p._1 + " and " + p._2)
      l.foreach(i => println("push one f " + i))
      if (l.length < 3) l = p :: l
      else {
        val h1 = l.head
        val h2 = l.tail.head
        if (turnLeft(h2, h1, p)) l = p :: l
        else {
          println("remove " + l.head)
          l = l.tail
          pushOne(p)
        }
      }
    }

    pushOne(bot)

    sort.foreach(t => pushOne(t._1, t._2))
    sort.foreach(i => println("sort " + i))
    l.foreach(i => println("list " + i))
    def compute(): Double = {
      val arr = l.toArray
      var sum = 0.0
      (1 until arr.size).foreach(i =>
        sum += distance(arr(i), arr(i-1)))
      sum
    }
    println(compute())

  }
}
