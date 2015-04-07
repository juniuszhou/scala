package TraitClass

/**
 * Created by junius on 15-1-16.
 */
class ClassPrivate {
  private val name : String = "class private "
  private[TraitClass] def printName = println(name)

}
