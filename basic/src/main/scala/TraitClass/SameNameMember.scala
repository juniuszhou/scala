package TraitClass

/**
 * you can see if a class implement two traits with the same method.
 * if one just has declaration and other one has ream implementation.
 * there is no conflict and scala compiler can recognize it.
 */
trait MajorTrait{
  def good : Unit
}

trait MinorTrait{
  def good = {println("minor trait")}
}

class SameNameMember extends MajorTrait with MinorTrait{
}

object SameNameMember {
  def main (args: Array[String]) {
    val s = new SameNameMember
    s.good
  }
}
