package ActorUsage

import scala.actors.{TIMEOUT, Actor}
import scala.actors.Actor._


// junius, Actor is a trait, we can define own Actor class.
// just re-define the act method is OK.
class MiniActor extends Actor{
  def act() = {
    println("I am a mini Actor")
    var continue = true
    loopWhile(continue) {
      reactWithin(500) {
        case msg: String => println("got message " + msg)
        // TIMEOUT is a case object, just for pattern match.
        case TIMEOUT => continue = false
          println("500 msec ran out.")
      }
    }
  }

  // define method let this Actor run
  def run() = this.start()
}

// other type to define runnable via give receive.
// actually receive will start a dead loop to deal message.

class MiniActor2 extends Actor{
  def act() = {
    println("I am a mini Actor2")
    // receive is a just once method.
    // in while actor can continue
    while (true) {
      receive {
        case msg => println(msg)
        case _ => println("got sth.")
      }
    }
  }

  // define method let this Actor run
  def run() = this.start()
}

object MiniActor {
  def main (args: Array[String]) {
    val ma = new MiniActor
    println("start the mini Actor")
    ma.run()

    ma ! "I am main"

    val ma2 = new MiniActor2
    println("start the mini Actor 2")
    ma2.run()
    ma2 ! "I ma main 2"
    // Thread.sleep(5000)
    ma2 ! "if mini 2 still alive."
    println("game over.")

  }

}
