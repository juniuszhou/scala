object Solution {

  def gcd(x: Int, y: Int): Int =
  {
    if(x == y) x else {
      if (x > y)
        gcd(x-y, y)
      else
        gcd(y-x, x)

    }
  }


  /**This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair:List[Int]) = {
    println(gcd(pair.head,pair.reverse.head))
  }

  def main(args: Array[String]) {
    acceptInputAndComputeGCD(List(18, 39))
    /** The part relates to the input/output. Do not change or modify it **/
    //acceptInputAndComputeGCD(readLine().trim().split(" ").map(x=>x.toInt).toList)

  }
}