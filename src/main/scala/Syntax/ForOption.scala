package Syntax

object ForOption {
  def main (args: Array[String]) {
    val b = false
    val op = if (b) Some("abc") else None
    // if op is None then following code snippet not executed.
    for(str <- op) println(str)
  }
}
