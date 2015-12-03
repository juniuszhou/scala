package basic.Grammar

import scala.util.{Failure, Try}


object SimulateFinally {
  def getE() = throw new Exception

  def main (args: Array[String]) {
    def getTry(): Try[String] = {
      for {
        i <- Try { getE()  } recoverWith {case err => {
          println("catch the exception")
          Failure(err)
        }}
        //recoverWith { case err => { println("get error")
        //Failure(err)}}
        k <- Try {println("into next ")
          getE() } recoverWith { case err => {
        // do sth for i if i occupy some resource and need close here.
        Failure(err)
      }}
      } yield k.toString
    }

    getTry()
  }
}
