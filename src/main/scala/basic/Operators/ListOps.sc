var lst = List(0,1,2)

// ++ connect two same data structure
lst ++= List(3,4,5)
lst

// + itself to string then concat with string
println(lst + "7")
lst.foreach(println)

// +: can add item or complex data structure.
lst.+:(7)
lst.+:(List(7))

// :: for single item and ::: for list
7 :: lst
List(7) ::: lst

// delete head n times.
lst.drop(2)

// take head n times and link
lst.take(2)

// ## get its hash code the same with hashcode
println(lst.##)
lst.hashCode()
