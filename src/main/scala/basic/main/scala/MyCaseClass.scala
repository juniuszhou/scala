object MyCaseClass{
  case class CaseClass(id: Int, name: String){

  }
  def main (args: Array[String]) {
    val cc = CaseClass(1, "junius")
    //extractor
    val CaseClass(id, name) = cc
    println(id.toString + " " + name)
  }
}