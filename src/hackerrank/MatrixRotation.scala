package hackerrank

object MatrixRotation {
  def main (args: Array[String]) {
    //all from 0 until size - 1
    def indexToDim(i: Int, r1: Int, m: Int, n: Int): Tuple2[Int, Int] = {
      val r = 2 * r1
      if (i < (m- r)) (i+r1,r1)
      else if (i < (m - r + n - r)) (m - r1, i - m + r + r1)
      else if ( i < (m - r + n - r + m - r)) (m - i + m - r + n - r - r1, n - r1)
      else (r1, n - ( i - m + r - n + r - m + r ) - r1)
    }

    val s: String = readLine()
    val dim = s.split(" ")
    val (m1, n1, step) = (dim(0).toInt, dim(1).toInt, dim(2).toInt)
    val mat: Array[Array[Int]] = Array.ofDim(m1, n1)
    (0 until m1).foreach(i => {
      val items = readLine().split(" ")
      val arr = new Array[Int](n1)

      mat.update(i, items.toList.map(str => str.toInt).toArray)
    })

    val m = m1 -1
    val n = n1 -1

    val r = Math.min(m1, n1) / 2
    //mat.foreach(arr => { arr.foreach( inn => print(" " + inn)); println() } )
    //println(m + " " + n + " " + r)
    (0 until r).foreach(i => {
      //println(" 32 line " + i)
      val rSize = 2 * (m + n - 4 * i)
      val fStep = step % rSize
      val arr: Array[Int] = new Array[Int](rSize)
      (0 until rSize).foreach(j => {
        val (col, row) = indexToDim(j, i, m, n)
        //println(" col row " + col + " " + row)
        arr(j) = mat(col)(row)
      })
      //println(" 40 line " + i)
      // move
      val arr2 : Array[Int] = new Array[Int](rSize)
      (0 until rSize).foreach(index => arr2( (index + step) % rSize ) = arr(index ))
      //println(" 44 line " + i)
      //write back to matrix
      (0 until rSize).foreach(j => {
        val (col, row) = indexToDim(j, i, m, n)
        //println(" col row " + col + " " + row)
        mat(col)(row) = arr2(j)
      })

    })
    // println(indexToDim(15, 0, 4, 5))
    //println("Hello world " + s)
    mat.foreach(arr => { arr.foreach( inn => print(inn+" ")); println() } )

  }
}