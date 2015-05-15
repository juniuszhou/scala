package HackerRank

import scala.sys.process._

object CallSystemCmd {
  def main (args: Array[String]) {
    // This uses ! to get the exit code
    def fileExists(name: String) = Seq("test", "-f", name).! == 0

    // This uses !! to get the whole result as a string
    val dirContents = "ls".!!

  }
}
