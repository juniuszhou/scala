package Datatype

class MyMutableContainer[T]{
  def add(item: T): Unit = {}
  def delete[U >: T](item: U) = {}
}

object Container{
  class a{

  }
  class b extends a{

  }
  def main(args: Array[String]){
    val mmca: MyMutableContainer[a] = new MyMutableContainer
    mmca.add(new b)
    mmca.add(new b)

    val mmcb: MyMutableContainer[b] = new MyMutableContainer
    // mmcb.add(new a)  can't pass compilation
    mmcb.delete(new a)

    println("end")
  }
}