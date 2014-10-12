val list=List(1 to 20 by 2:_*)
val list1=list++List(21,22)
println("list1="+list1)
val list2=22+:21+:list
println("list2="+list2)
//val list3=list--List(19,20)
//println("list3="+list3)
//val list4=list-19-20
//println("list4="+list4)
val list5=list:::List(21,22)
println("list5="+list5)
val list6=22::21::list
println("list6="+list6)
val list8=list.companion(4,5)
println("list8="+list8)
val list9=list.drop(5)
println("list9="+list9)
val list10=list.dropWhile(_<10)
println("list10="+list10)
val list11=List("a","b").mapConserve(_.toUpperCase())
println("list11="+list11)
val list14=list.reverse
println("list14="+list14)
val list15=list.slice(2,6)
println("list15="+list15)
val list17=list.span(_<10)
println("list17="+list17)
val list18=list.splitAt(8)
println("list18="+list18)
val list19=list.stringPrefix
println("list19="+list19)
val list20=list.take(5)
println("list20="+list20)
val list22=list.takeWhile(_<15)
println("list22="+list22)
val list23=list.toList
println("list23="+list23)
val list24=list.toStream
println("list24="+list24)
val list25=list++:List(21,22)
println("list25="+list25)
val list26=list./:(0)((x,y)=>x+y)
println("list26="+list26)
val list28=list.:\(0)((x,y)=>x+y)
println("list28="+list28)
val list29=list.:\(0)((x,y)=>x+y)
println("list29="+list29)
val list30=list:+20:+21
println("list30="+list30)
val list31=list.addString(new StringBuilder("a"))
println("list31="+list31)
val list32=list.apply(5)
println("list32="+list32)
val list33=list.canEqual("")
println("list33="+list33)
val list34=list.collect{case i:Int => i+"b"}
println("list34="+list34)
val list35=list.andThen(_<10).isDefinedAt(10)
println("list35="+list35)
val list36=list.collectFirst{case i:Int => i+"b"}
println("list36="+list36)
val list37=list.take(3).combinations(2).toList
println("list37="+list37)
val list39=list.contains(9)
println("list39="+list39)
val list40=list.containsSlice(List(1,3))
println("list40="+list40)
val array=new Array[Int](10)
list.copyToArray(array)
println("array="+array.mkString(","))
list.copyToArray(array,5)
println("array="+array.mkString(","))
list.copyToArray(array,1,3)
println("array="+array.mkString(","))
val list41=list.corresponds(list)(_>=_)
println("list41="+list41)
val list42=list.count(_<15)
println("list42="+list42)
val list43=list.diff(List(1,5,11))
println("list43="+list43)
val list44=list.distinct
println("list44="+list44)
val list45=list.dropRight(3)
println("list45="+list45)
val list47=list.endsWith(List(17,19))
println("list47="+list47)
val list48=list.equals(List(10))
println("list48="+list48)
val list50=list.exists(_==19)
println("list50="+list50)
val list51=list.filter(_%3==0)
println("list51="+list51)
val list52=list.filterNot(_%3==0)
println("list52="+list52)
val list53=list.find(_==19)
println("list53="+list53)

val list58=List(List(1,2),List(3,5,8)).flatMap(_.toList)
println("list58="+list58)
val list59=List(List(1,2),List(3,5,8)).flatten(_.toList)
println("list59="+list59)
val list60=list.fold(0)((x,y)=>x+y)
println("list60="+list60)

val list61=list.foldLeft(0)((x,y)=>x+y)
println("list61="+list61)
val list62=list.foldRight(0)((x,y)=>x+y)
println("list62="+list62)
val list63=list.forall(_<20)
println("list63="+list63)
list.foreach(println)
val list64=list.genericBuilder
println("list64="+list64)
val list65=list.groupBy(_+"a")
println("list65="+list65)
val list66=list.grouped(3)
println("list66="+list66)
val list67=list.hasDefiniteSize
println("list67="+list67)
val list68=list.hashCode()
println("list68="+list68)
val list69=list.head
println("list69="+list69)
val list70=list.headOption
println("list70="+list70)
val list71=list.indexOf(19)
println("list71="+list71)
val list72=list.indexOfSlice(List(17,19))
println("list72="+list72)
val list73=list.indexWhere(_>12)
println("list73="+list73)
val list74=list.indices
println("list74="+list74)
val list75=list.init
println("list75="+list75)


val list76=list.inits
println("list76="+list76)
val list77=list.intersect(List(17,19,20))
println("list77="+list77)
val list78=list.isDefinedAt(9)
println("list78="+list78)
val list79=list.isEmpty
println("list79="+list79)
val list80=list.isTraversableAgain
println("list80="+list80)
val list81=list.iterator
println("list81="+list81)
val list82=list.last
println("list82="+list82)
val list83=list.lastIndexOf(19)
println("list83="+list83)
val list84=list.lastIndexOfSlice(List(19))
println("list84="+list84)
val list85=list.lastOption
println("list85="+list85)
val list86=list.indexWhere(_>12)
println("list86="+list86)
val list87=list.length
println("list87="+list87)
val list88=list.lengthCompare(50)
println("list88="+list88)
val list89=list.lift
println("list89="+list89)
val list90=list.map(_+"a")
println("list90="+list90)


val list91=list.max
println("list91="+list91)
val list92=list.maxBy(_.intValue())
println("list92="+list92)
val list93=list.min
println("list93="+list93)
val list94=list.minBy(_.intValue())
println("list94="+list94)
val list95=list.mkString(",")
println("list95="+list95)
val list96=list.mkString("(",",",")")
println("list96="+list96)
val list97=list.mkString
println("list97="+list97)
val list98=List.newBuilder
println("list98="+list98)
val list99=list.nonEmpty
println("list99="+list99)
//  val list100=list.occCounts()
//  println("list100="+list100)
val list101=list.padTo(20,5)
println("list101="+list101)
val list102=list.par
println("list102="+list102)
//  val list103=List.parCombiner
//  println("list103="+list103)
val list104=list.partition(_%3==0)
println("list104="+list104)
val list105=list.patch(2,List(99,100),3)
println("list105="+list105)


List(1,2,3).permutations.foreach(println)
val list107=list.prefixLength(_<15)
println("list107="+list107)
val list108=List(1,2,3,4).product
println("list108="+list108)
val list109=list.productArity
println("list109="+list109)
val list110=list.productElement(1)
println("list110="+list110)
list.productIterator.foreach(println)
val list112=list.productPrefix
println("list112="+list112)

val list114=list.reduce(_+_)
println("list114="+list114)
val list115=list.reduceLeft(_+_)
println("list115="+list115)
val list116=list.reduceLeftOption(_+_)
println("list116="+list116)
val list117=list.reduceRight(_+_)
println("list117="+list117)
val list118=list.reduceRightOption(_+_)
println("list118="+list118)
val list119=list.repr
println("list119="+list119)
//  val list120=list.reversed
//  println("list120="+list120)


list.reverseIterator.foreach(println)
val list123=list.reverseMap(_+"a")
println("list123="+list123)
val list124=list.sameElements(list)
println("list124="+list124)
val list125=list.scan(0)(_+_)
println("list125="+list125)
val list126=list.scanLeft(0)(_+_)
println("list126="+list126)
val list127=list.scanRight(0)(_+_)
println("list127="+list127)
val list128=list.segmentLength(_<18,3)
println("list128="+list128)
val list129=list.seq
println("list129="+list129)
//  val list130=list.sequential
//  println("list130="+list130)
val list131=list.size
println("list131="+list131)
list.sliding(4).foreach(println)
println("_____")
list.sliding(3,5).foreach(println)
val list134=list.sortBy(_.toInt)
println("list134="+list134)
val list135=list.sorted
println("list135="+list135)
val list136=list.sortWith(_>_)
println("list136="+list136)
val list137=list.sum
println("list137="+list137)
val list138=list.startsWith(List(1,3))
println("list138="+list138)
val list139=list.tail
println("list139="+list139)
val list140=list.tails
println("list140="+list140)


val list141=List(List(1,2,9), List(3,4,10), List(5,6,11)).transpose
println("list141="+list141)
val list142=list.union(List(20,21))
println("list142="+list142)
val list143=list.zip(list.reverse)
println("list143="+list143)
val list144=list.unzip3(x=>(x,x+"a",x+10))
println("list144="+list144)
val list145=list.unzip(x=>(x,x+"a"))
println("list145="+list145)
val list146=list.view(3,7).force
println("list146="+list146)
val list147=list.view.force
println("list147="+list147)
list.withFilter(_%3==0).foreach(println)
val list149=list.zipAll(list.take(5),0,5)
println("list149="+list149)
val list150=list.take(5).zipAll(list,0,5)
println("list150="+list150)
val list151=list.zipWithIndex
println("list151="+list151)
val list152=list.updated(1,10)
println("list152="+list152)
val list153=list.ensuring(_.size==10)
println("list153="+list153)
val list154=list.zipWithIndex.flatMap(x=>List(x._1,x._2))
println("list154="+list154)