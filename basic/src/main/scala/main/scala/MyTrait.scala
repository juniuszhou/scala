// similar with sealed class, all sub trait and class must define
// in the same source file.
sealed trait MySealedTrait{

}

abstract class MyLog{
  def log
}

trait EmailService {
  def sendEmail
  def downloadAttachment
}

trait Pop3EmailService extends EmailService{
  def sendEmail = {

  }
}

trait ImapEmailService extends EmailService{
  def sendEmail = {}
  def downloadAttachment = {}
}

class ImapEmailImplementation extends MyLog with ImapEmailService{
  def log = {println("log recorded.")}
}

object MyTrait{
  def main(args: Array[String]): Unit = {
    val a: EmailService = new ImapEmailImplementation
    println(a.getClass)
    println(a.isInstanceOf[EmailService])
    println(a.isInstanceOf[ImapEmailImplementation])
    println(a.isInstanceOf[Pop3EmailService])

    //asInstanceOf will transmit
    println(a.asInstanceOf[EmailService])
    println(a.asInstanceOf[ImapEmailImplementation])
    //ClassCastException
    //println(a.asInstanceOf[Pop3EmailService])
  }
}