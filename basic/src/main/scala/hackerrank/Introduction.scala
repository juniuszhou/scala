package hackerrank

object Introduction {
  case class pair (val value: Int, val index: Int){
    def > (other: pair): Boolean = other.value > value || (other.value == value && other.index > index)
    def == (other: pair): Boolean = other.value == value && other.index == index
    def < (other: pair): Boolean = other.value < value || (other.value == value && other.index > index)
  }
  def quickSort(arr: Array[pair]) : Array[pair] = {
    if (arr.length <= 0) arr

    else {
      val pivot = arr(arr.length / 2)
      Array.concat(quickSort(arr.filter(pivot >)), arr.filter(pivot ==), arr.filter(pivot <))
    }

  }

  def main(args: Array[String]){
    val str: Array[String] = readLine().split(" ")
    val (n, q) = (str(0).toInt, str(1).toInt)

    val str2: Array[String] = readLine().split(" ")
    val cur = new Array[Int](str2.length)
    (0 until str2.length).foreach(i => cur(i) = str2(i).toInt)


    val str3 : Array[String] = readLine().split(" ")
    val day = new Array[Int](str3.length)
    (0 until str2.length).foreach(i => day(i) = str3(i).toInt)

    (0 until q).foreach(i => {
      val which = readLine().toInt
      var j = 0
      var max = cur(j) + which * day(j)
      (1 until n).foreach( nn => {
        if(max <= (cur(nn) + which * day(nn))) {
          max = cur(nn) + which * day(nn)
          j = nn
        }
      })
      println(j + 1)
    })
  }
}
