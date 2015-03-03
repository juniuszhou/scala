package hackerrank

/**
 * Created by junius on 15-3-3.
 */
object Introduction {

  def f(x: Float):Float={
    def comp(i: Int, f: Float): Float ={
      if(i == 9) return f * x / i.toFloat
      else f * x / i.toFloat + comp(i + 1, f * x / i.toFloat)
    }
    (Math.round((comp(1, 1.0F) + 1) * 10000) / 10000.0).toFloat
  }

  def main(args: Array[String]){
    println(f(5.0F))
    //println(f2(2.0F))
    println(Math.exp(5))
  }
}
