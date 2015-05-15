package Syntax

object FileOps {
  def main(args: Array[String]) {
    val path = "D:\\dev\\src\\1953\\e3\\components\\shopsvc\\prototypes\\modules\\GeoWallE\\pSprint.0\\src\\resources\\CountryCodes.txt"
    val newP = "D:\\dev\\src\\1953\\e3\\components\\shopsvc\\prototypes\\modules\\GeoWallE\\pSprint.0\\appConfig\\DefaultService.txt"
    val file = io.Source.fromFile(newP, "utf-8")

    file.getLines().foreach(str => {
      val pp = str.split("\t")
      val p = pp(0)
      val s = if(p.last == ',') p.substring(0,p.length - 1) else p
      println(s+ "\t" + "Google")
    })

  }
}
