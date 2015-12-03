package basic.Inheritance

/**
 * Created by juzhou on 8/6/2015.
 */

class parentOne {
  val abc = "parent"
}

class childOne extends parentOne
 {
  override val abc = "child"
}

object OverrideDataMember {
    def main (args: Array[String]) {
    val c: parentOne = new childOne
      println(c.abc)
  }
}
