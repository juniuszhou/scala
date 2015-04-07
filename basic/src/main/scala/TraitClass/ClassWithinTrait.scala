package TraitClass

/**
 * Created by junius on 15-2-10.
 */
trait TraitIncludeClass{
  class innerClass{

  }
}

// if you need use or inherit an inner class of a trait. we can extends it or with it.
object ClassWithinTrait extends TraitIncludeClass {
  class myInner extends innerClass{

  }

  def main (args: Array[String]) {
    val v: innerClass = new innerClass()
    v.toString

  }
}
