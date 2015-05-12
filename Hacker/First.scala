package HackerRank

object First{
  def getString(i: Int): Array[Int] = {
    val a = new Array[Int](8)
    var num = i
    (0 until 8).foreach(index => {
      val residule = num % 3
      a(index) = residule
      num = num / 3
    })
    a
  }

  // 8 ops and 8 numbers.
  def compute(cur: Int, a: Array[Int], s: Array[Int]): Int = {
    if (a.size > 0){
      if(a(0) == 0) compute(cur * 10 + s(0), a.takeRight(a.size - 1), s.takeRight(s.size - 1))
      else if(a(0) == 1) cur + compute(s(0), a.takeRight(a.size - 1), s.takeRight(s.size - 1))
      else cur - compute(s(0), a.takeRight(a.size - 1), s.takeRight(s.size - 1))
    }
    else cur
  }

  def main (args: Array[String]) {
    val loop = Math.pow(3,8).toInt
    (0 until loop).foreach(i =>{

    })

    println(compute(1, Array(0,0,0,0,0,0,0,0), Array(2,3,4,5,6,7,8,9)))

  }
}
