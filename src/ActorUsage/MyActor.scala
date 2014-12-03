package ActorUsage
import actors._, Actor._


object MyActor{
  def main(args: Array[String]) {
    // junius self is a variable defined in Actor. so it is Actor.self
    // it is refer to the current thread.
    val caller = self

    // actor the method used to create a new Actor.
    val accumulator = actor {
      var continue = true
      var sum = 0
      loopWhile(continue) {
        reactWithin(500) {
          case number: Int => sum += number
            // TIMEOUT is a case object, just for pattern match.
          case TIMEOUT => continue = false
            println("500 msec ran out.")
            caller ! sum
        }
      }
    }

    accumulator ! 1
    accumulator ! 2
    accumulator ! 3

    // junius get a message from mailbox in 1 second. if message got then print
    // even receive TIMEOUT, just print TIMEOUT.
    // if we don't deal with TIMEOUT type, then exception.

    receiveWithin(100) {
      case result: Int => println(result)
    }

    println("hello world")
  }
}