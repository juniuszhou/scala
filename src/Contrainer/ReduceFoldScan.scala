package Contrainer

/**
reduceLeft and reduceRight cumulate a single result.

foldLeft and foldRight cumulate a single result using a start value.

scanLeft and scanRight cumulate a collection of intermediate cumulative results using a start value.
 */
object ReduceFoldScan {
  def main (args: Array[String]) {
    val abc = List("A", "B", "C")

    def add(res: String, x: String) = {
      println(s"op: $res + $x = ${res + x}")
      res + x
    }

    // reduce no need to set init value
    abc.reduceLeft(add)
    // op: A + B = AB
    // op: AB + C = ABC    // accumulates value AB in *first* operator arg `res`
    // res: String = ABC

    //need init value and result is a single value
    abc.foldLeft("z")(add) // with start value "z"
    // op: z + A = zA      // initial extra operation
    // op: zA + B = zAB
    // op: zAB + C = zABC
    // res: String = zABC

    //need init value and result is all intermediate result.
    abc.scanLeft("z")(add)
    // op: C + z = Cz
    // op: B + Cz = BCz
    // op: A + BCz = ABCz
    // res: List[String] = List(ABCz, BCz, Cz, z)

  }

}
