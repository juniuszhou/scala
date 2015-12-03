package Syntax

object InternalObject {
  var count = 0
  var obj: InternalObject = null
  def setValue(i: Int) = {
    count = i
    if (obj == null) obj = new InternalObject(i)
  }
}

class InternalObject(i: Int) {
  if (InternalObject.obj == null ) InternalObject.setValue(i)

  def doSth() = {
    InternalObject.obj.print()
  }

  def print() = {println("ok")}
}

object MyStatic {
  def main (args: Array[String]) {
    val v = new InternalObject(8)
    v.doSth()
  }
}
