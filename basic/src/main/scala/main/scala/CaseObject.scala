package main.scala

import java.io.{ObjectOutputStream, ByteArrayOutputStream}

/**
 * Created by junius on 14-11-17.
 */
object CaseObject {
  // both object and case object for pattern match.
  // the only difference is case object can be serialization.
  case object MyCaseObj {

  }


  def main (args: Array[String]) {
    val bos = new ByteArrayOutputStream
    val oos = new ObjectOutputStream(bos)
    // case object is ok for serialization.
    oos.writeObject(MyCaseObj)
    // can't write non case object, it can not be serialized.
    // oos.writeObject(CaseObj)
  }
}
