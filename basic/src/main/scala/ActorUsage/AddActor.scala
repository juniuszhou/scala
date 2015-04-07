package ActorUsage

import scala.actors.{TIMEOUT, Actor}
import scala.actors.Actor._
/**
 * Created by junius on 14-12-3.
 */

case class Add(number: Int)
case class GetResult(sender: Actor)

// junius , the Actor keep the add result via parameter.
// there is no internal variable to record.
class AddActor extends Actor {
  override def act(): Unit = process(0)
  def process(value: Int): Unit = {
    reactWithin(500) {
      case Add(number) => process(value + number)
      case GetResult(a) => a ! value; process(value)
      case _ => process(value)
    }
  }
}

object AddActor {
  val addActor = new AddActor
  addActor.start()
  addActor ! Add(1)
  addActor ! Add(2)
  addActor ! Add(3)
  addActor ! GetResult(self)
  receiveWithin(1000) {
    case result => println("Total is " + result)
  }
}
