def pascal(x: Int) = {
  def p(arr: Array[Int]) = {
    (0 until arr.length).foreach(i => {
      print(arr(i))
      if(i == arr.length -1) println else print(" ")
    }
    )
  }

  var l:List[Int] = List(1)

  (0 until x).foreach(i => {
    val arr = l.toArray
    p(arr)
    //println("++++++++++++")
    val newArr = new Array[Int](arr.length + 1)
    (0 until newArr.length).foreach(index => {
      if (index == 0 || index == newArr.length - 1) newArr(index) = 1
      else newArr(index) = arr(index-1) + arr(index)
    })

    l = newArr.toList
  })
}
pascal(12)

