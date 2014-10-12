/**
 * Created by junius on 14-10-13.
 */

import scala.collection.parallel.ForkJoinTaskSupport
import scala.collection.parallel.mutable.ParIterable
import scala.collection.{Parallelizable, parallel}
import scala.concurrent.forkjoin.ForkJoinPool

object MultiThread {
/*
  implicit class ParToMutile[+A](parable:Parallelizable[A,ParIterable[A]]){
    def mutile(thread:Int= -1)={
      if(thread== -1){
        parable.par
      }else{
        val resutl=parable.par
        resutl.tasksupport=new ForkJoinTaskSupport(new ForkJoinPool(thread))
        resutl
      }
    }
  }
*/

 def main (args: Array[String]) {
   //0 to 10 mutile(7) foreach {}

   val list=1::2::3::4::6::Nil
   //list mutile(3) map {}
  }
}
