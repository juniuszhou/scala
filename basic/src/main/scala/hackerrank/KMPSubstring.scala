package hackerrank

/**
 * Created by junius on 15-3-6.
 */
object KMPSubstring {
  def generateMapTable(pattern: String): Array[Int] = {
    val res = new Array[Int](pattern.length)
    (0 until pattern.length).foreach(i => res(i) = -1)

    //always should be one.
    res(0) = 0
    (1 until pattern.length).foreach(i =>{
      val c: Char = pattern.charAt(i)
      val prev: Int = res(i - 1)
      if(c == pattern.charAt(prev)) res(i) = res(i-1) + 1 else res(i) = 0
    })

    res
  }

  def compareStr(str: String, pattern: String, m: Array[Int]) : Boolean = {
    var i = 0

    while ( i <= str.length - pattern.length ){
      var j = 0
      var b: Boolean = true
      while (j < pattern.length && b){
        //println("current j " + j + " " + str.charAt(i) + " " + pattern.charAt(j))
        if(str.charAt(i + j) == pattern.charAt(j)) j = j + 1 else b = false
      }
      if (j == pattern.length) return true;

      i = i + m(j) + 1
      //println("current i " + i)
    }
    return false;
  }
  def main (args: Array[String]) {
    val m = generateMapTable("abacab")
    // m.foreach(print)
    //println(compareStr("adsfsdfabacab3dsf", "abacab", m))


    val number = readLine().toInt

    (0 until number).foreach(i => {
      val str = readLine()
      val pattern = readLine()
      val arr = generateMapTable(pattern)
      if (compareStr(str, pattern, arr)) println("YES") else println("NO")
    })

  }
}
