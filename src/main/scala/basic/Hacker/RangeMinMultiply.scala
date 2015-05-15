package HackerRank

object RangeMinMultiply {
  def main(args: Array[String]) {
    val n = readLine().trim().toInt
    val lay = Math.sqrt(n - 1).toInt + 1
    val arr = new Array[Array[Long]](lay)
    (1 until lay).foreach(i => arr(i) = new Array[Long](n))

    val lay0 = readLine().split(" ").map(_.toLong)
    arr(0) = lay0

    def up() = {
      (1 until lay).foreach(i => {
        val len = Math.pow(2, i - 1).toInt
        (0 until n).foreach(j => {
          if (j + len < n) arr(i)(j) = m(arr(i - 1)(j), arr(i - 1)(j + len))
          else arr(i)(j) = arr(i - 1)(j)
        })
      })
    }

    up()

    def mul(p: Int, v: Int) = {
      arr(0)(p) *= v
      up()
    }

    def m(a: Long, b: Long): Long = {
      val max = Math.max(a, b)
      val min = Math.min(a, b)
      def gcd(c: Long, d: Long): Long = {
        val residual = c % d
        if (residual == 0) d else gcd(d, residual)
      }
      (a * b / gcd(max, min)) % (Math.pow(10, 9).toLong + 7)
    }

    def q(l: Int, r: Int): Long = {
      if (l == r) arr(0)(l)
      else {
        val layer = (Math.log(r - l + 1) / Math.log(2)).toInt
        m(arr(layer)(l), arr(layer)(r - Math.pow(2, layer).toInt + 1))
      }
    }

    val nn = readLine().trim().toInt
    (0 until nn).foreach(k => {
      val tri = readLine().split(" ")
      if (tri(0) == "Q") println(q(tri(1).toInt, tri(2).toInt))
      else mul(tri(1).toInt, tri(2).toInt)
    })
  }
}

