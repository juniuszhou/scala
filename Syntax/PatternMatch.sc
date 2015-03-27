// compiler take capital B as constant
val (a, b) = (100, 200)

// it is ok. because object is lazy init.
object Test {
  val 2 = 3
}

// match multiply classes
val am: Any = 1
am match {
  case _: Int | _: String => println("matched")
  case _ => println("ok")
}

val arr = Array(1, 2, 3)
arr match {
  case Array(1, _*) => println("matched")
}

//variable match, always ok.
val Other = "okok"
val oneStr = "junius"
oneStr match {
  case Other => println(Other + " matched")
  case _ =>
}



