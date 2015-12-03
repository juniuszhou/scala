package ScalaThreads

object MultiThread {
 def main (args: Array[String]) {

   (0 to 5).foreach(i => {
     val thread = new Thread() {
       override def run() = {
         println("new thread")
         while(true){

         }
       }
     }.start()

   })

   val thread = new Thread() {
     override def run() = {
       println("new thread")
       while(true){

       }
     }
   }.start()

   val thread2 = new Thread() {
     override def run() = {
       println("new thread")
       while(true){

       }
     }
   }.start()
  }
}
