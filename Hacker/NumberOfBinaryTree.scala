package Hacker

/**
 * Created by juzhou on 3/25/2015.
 */
object NumberOfBinaryTree {
  def main(args: Array[String]) {
    val modulo = Math.pow(10, 8).toLong + 7

    /*
    def how(l: Int, r: Int): Long = {
      if (r - l < 2)  (r - l + 1).toLong
      else {
        var sum = 0L
        (l to r).foreach(i => {
          if (i == l)  sum += how(i + 1, r)
          else if (i == r)  sum += how(l, r - 1)
          else  sum += how(l, i-1) * how(i + 1, r)
          if (sum > modulo) sum = sum % modulo
        })
        sum
      }
    }*/
    val n = readInt()
    val arr1 = new Array[Int](n)
    var maxinput = Int.MinValue
    (0 until n).foreach(i => {
      arr1(i) = readInt();
      maxinput = Math.max(maxinput, arr1(i))
    })

    val arr = new Array[Long](maxinput + 1)
    def how() = {
      arr(0) = -1
      arr(1) = 1
      arr(2) = 2
      (3 to maxinput).foreach(i => {
        var sum = 0L
        (1 to i).foreach(j => {
          if(j == 1) sum += arr(i-1) else if(j == i) sum += arr(i-1)
          else sum += arr(j-1) * arr(i-j)
        })
        arr(i) = sum % modulo
      })
    }
    how()
    (0 until n).foreach(i => println(arr(arr1(i))))
  }
}
