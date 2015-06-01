package basic.TraitClass

/**
 * Created by juzhou on 6/23/2015.
 */
object ChainedTraitsCall {
  trait MyReader{
    def read(): Unit = throw new Exception
  }
  trait oneReader extends MyReader {
    override def read(): Unit = {
      println("oneReader called")
      super.read()
    }
  }

  trait twoReader extends MyReader {
    override def read(): Unit = {
      println("twoReader called")
      super.read()
    }
  }

  // then from right side to left side. all read will be called even read in root trait.
  class MyReaderImp extends oneReader with twoReader {
    //override def read() = {
    //}
  }

  def main (args: Array[String]) {
    val read = new MyReaderImp
    read.read()
  }
}
