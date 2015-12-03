package Syntax

object MyOption {
  def main (args: Array[String]) {
    def getGson(): Option[String] = {
      if (true) Some("I ma ok") else None
    }

    getGson() match {
      case str: Some[String] => println(str.get)
      case _ => println("none")
    }
  }
}
