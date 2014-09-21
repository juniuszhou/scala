
diff --git a/src/main/scala/org/oneScala/Actor.sc b/src/main/scala/org/oneScala/Actor.sc
deleted file mode 100644
@@ -1,62 +0,0 @@
-package oneScala
-
-import scala.actors._
-import scala.actors.Actor._
-
-
-class myActor extends Actor{
-  def act(){
-    for (i <- 1 to 5){
-      println("I am actor now number is ",i)
-      Thread.sleep(1000)
-    }
-  }
-}
-
-class recvSendActor extends Actor{
-  def act(){
-    loopWhile(true){
-      reactWithin(500){
-        case n:String => println("got msg is ",n)
-        case TIMEOUT => self ! 100
-      }
-    }
-  }
-}
-
-class sendActor extends Actor{
-  var target1 : recvSendActor = null
-  def act(){
-    loopWhile(true){
-      reactWithin(500){
-        case m => {
-          val str = "Hello"
-          target1 ! str
-        }
-      }
-    }
-  }
-  def setTarget(t:recvSendActor){
-    this.target1 = t
-  }
-}
-
-object Actor {
-//val act1 = new myActor
-      //create an actor via helper method.
-      /* val act2 = actor {
-        for (i <- 1 to 5){
-        	println("I am actor 2 now number is ",i)
-        	Thread.sleep(1000)
-        }
-      } */
-      //act1.start()
-      //act2.start()
-      
-      val act3 = new recvSendActor                //> act3  : oneScala.recvSendActor = oneScala.recvSendActor@4532ba
-      val act4 = new sendActor                    //> act4  : oneScala.sendActor = oneScala.sendActor@1b030d8
-      //act4.setTarget(act3)
-      //act3.start
-      //act4.start
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-}
\ No newline at end of file



diff --git a/src/main/scala/org/oneScala/Closure.scala b/src/main/scala/org/oneScala/Closure.scala
deleted file mode 100644
@@ -1,17 +0,0 @@
-package main.scala.org.oneScala
-import scala.PartialFunction
-
-
-class Counter{
-	type Receive = PartialFunction[Any,Unit]
-	def count(n:Int) : PartialFunction[Any,Unit] = {
-	  case "" => println(n)	
-	  case _ => println(n)	
-	}
-	
-	def receive = count(0)
-}
-
-class Closure {
-
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/Collection2.scala b/src/main/scala/org/oneScala/Collection2.scala
deleted file mode 100644
@@ -1,60 +0,0 @@
-package main.scala.org.oneScala
-import scala.collection.mutable.Map
-
-class foo{
-  def apply() = println("foo apply")
-  def printOK = println("OK")
-}
-
-object fooMaker{
-	def apply() = new foo
-}
-
-object Collection2 {
-	def main(args : Array[String]){
-	  val map1 = Map(1 -> 1, 2 ->2)
-	  var map2 = Map(3 -> 3)
-	  map2 = map1 ++ map2
-	  println(map1(1))
-	  val it = (map1 ++ map2).iterator
-	  while (it.hasNext){
-	    println(it.next)
-	  }
-
-	  //println(map1(3))
-	  println(map1.get(3).isDefined)
-	  
-	  map1.get(3) match {
-	    case Some(_) => println("")
-	    case None =>  println("")
-	  }
-	  
-	  def one : PartialFunction[Int, Unit] = { case 1 => println("I am one") }
-	  one(1)
-	  
-	  val alist = (0 to 10)
-	  println(alist.foldLeft(99)((m,n) => m + n))
-	  
-	  //compose andThen just for func with same signature.
-	  def f1(u:String) = {println("hello"); "hello"}
-	  def f2(j:String) = {println("world"); "world"}
-	  val f1f2 = f1 _ compose f2 _ 
-	  val f2f1 = f1 _ andThen f2 _
-	  f1f2("ok")
-	  f2f1("ok")
-	  
-	  //anonymous function
-	  val f3 = (i:Int,j:Int) => i+j
-	  f3(1,2)
-	  
-	  def multi(i:Int)(j:Int) = i*j
-	  def multi2(k:Int) = multi(k) _
-	  println(multi2(100)(9))
-	  
-	  //apply usage
-	  val foo1 = fooMaker()
-	  foo1.printOK
-	  foo1()
-	  
-	}
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/Companion.scala b/src/main/scala/org/oneScala/Companion.scala
deleted file mode 100644
@@ -1,70 +0,0 @@
-package main.scala.org.oneScala
-
-import scala.collection.mutable._
-import scala.collection.mutable
-
-//in parameter, you can define data member has the same name with parameter
-class Publication(val title: String)
-class Book(title: String) extends Publication(title)
-/*
-object Library1{
-    val books: Set[Book] =
-        Set(
-            new Book("Programming in Scala"),
-            new Book("Walden")
-        )
-
-    def printBookList(info: Book => AnyRef) {
-        assert(info.isInstanceOf[Function1[_, _]])
-        for (book <- books)
-            println(info(book))
-    }
-
-    def printBokkListByTrait[P >: Book, R <: AnyRef](
-            action : GetInfoAction[P, R]) {
-        for (book <- books)
-            println(action(book))
-    }
-}
-
-*/
-
-trait GetInfoAction[ P >: Book, R <: AnyRef] {
-   def apply(book : P) : R
-}
-
-trait Function1[-S, +T] {
-  def apply(x: S): T
-}
-
-/*
-object temporary {
-	def getTitle(p: Publication) = p.title
-  def aa = getTitle(new Publication("junius "))
-  if (aa.isInstanceOf[Function1[_,_]])
-  	println("is ")
-
-    Library1.printBookList(getTitle)
-
-    Library1.printBokkListByTrait(new GetInfoAction[Publication, String] {
-           def apply(p: Publication) : String = p.title })
-  println("Welcome to the Scala worksheet")
-}
-*/
-object Companion {
-  def main(args: Array[String]) { 
-  	/*def getTitle(p: Publication) = p.title
-  def aa = getTitle(new Publication("junius "))
-  if (aa.isInstanceOf[Function1[_,_]])
-  	println("is ")
-
-    Library1.printBookList(getTitle)
-  def show = println("I am a companion")
-
-  */
-    println("I am a companion")
-}
-}
-
-class Companion {
-}
\ No newline at end of file



diff --git a/src/main/scala/org/oneScala/Container.sc b/src/main/scala/org/oneScala/Container.sc
deleted file mode 100644
@@ -1,56 +0,0 @@
-package oneScala
-import scala.collection.mutable.Set
-import scala.collection.mutable.Map
-import scala.collection.mutable._
-object Container {
-	//def array
-	val as : Array[String] = new Array[String](3)
-                                                  //> as  : Array[String] = Array(null, null, null)
-	as(0) = "Hello "
-	as(1) = "World "
-	as(2) = "!"
-	as(0) = "pass "
-	as.foreach(println)                       //> pass 
-                                                  //| World 
-                                                  //| !
-	//list
-	val ls = List(1,2)                        //> ls  : List[Int] = List(1, 2)
-	val lsNo = Nil                            //> lsNo  : scala.collection.immutable.Nil.type = List()
-	val hItem = ls.head                       //> hItem  : Int = 1
-	val tItem = ls.tail                       //> tItem  : List[Int] = List(2)
-	val ttItem = tItem.tail                   //> ttItem  : List[Int] = List()
-	val lsi : List[Int] = List[Int](3,4)      //> lsi  : List[Int] = List(3, 4)
-	val ls1 = 1 :: 2 :: Nil                   //> ls1  : List[Int] = List(1, 2)
-	val llink = ls ::: lsi                    //> llink  : List[Int] = List(1, 2, 3, 4)
-	//from next def, so you have to use :::: to connect to one dimension
-	val llink2 = ls :: lsi                    //> llink2  : List[Any] = List(List(1, 2), 3, 4)
-	val lsb : List[Int] = List(1,2,3,4,5)     //> lsb  : List[Int] = List(1, 2, 3, 4, 5)
-	val rlsb = lsb.reverse                    //> rlsb  : List[Int] = List(5, 4, 3, 2, 1)
-	val alsb = 0 :: lsb                       //> alsb  : List[Int] = List(0, 1, 2, 3, 4, 5)
-	val ralsb = alsb.reverse                  //> ralsb  : List[Int] = List(5, 4, 3, 2, 1, 0)
-	
-	//tuple, each element's type could be different
-	val t1 = (1,"2")                          //> t1  : (Int, String) = (1,2)
-	println(t1._1)                            //> 1
-	println(t1._2)                            //> 2
-	val t2 : Tuple2[Int,String] = Tuple2[Int,String](1,"2")
-                                                  //> t2  : (Int, String) = (1,2)
-	
-	//set
-	val set1 = Set("hello","world")           //> set1  : scala.collection.mutable.Set[String] = Set(world, hello)
-	set1 += "!"                               //> res0: oneScala.Container.set1.type = Set(!, world, hello)
-	//Iterator it = set1.
-	
-	//map
-	val map1 = Map(1 -> "1")                  //> map1  : scala.collection.mutable.Map[Int,String] = Map(1 -> 1)
-	map1 += (2 -> "2")                        //> res1: oneScala.Container.map1.type = Map(2 -> 2, 1 -> 1)
-  
-  //list buffer
-  val llint = List(1,2,3,4)                       //> llint  : List[Int] = List(1, 2, 3, 4)
-  val buf = new ListBuffer[Int]                   //> buf  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
-  for(x <- llint) buf += x + 1
-  buf.toList                                      //> res2: List[Int] = List(2, 3, 4, 5)
-  //val buf2 = new Listbuffer(llint)
-  
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/Extractor.sc b/src/main/scala/org/oneScala/Extractor.sc
deleted file mode 100644
@@ -1,27 +0,0 @@
-package com.junius
-class a{}
-class b extends a{}
-object Extractor {
-	val str = "hello world"                   //> str  : String = hello world
-	//final case class ::[B](private var hd: B, private[scala] var tl: List[B]) extends List[B] {
-  //override def head : B = hd
-  
-	val alist = new ::[Int](1,List(1,2,3))    //> alist  : scala.collection.immutable.::[Int] = List(1, 1, 2, 3)
-	val blist = new ::[Int](1,Nil)            //> blist  : scala.collection.immutable.::[Int] = List(1)
-	println(alist)                            //> List(1, 1, 2, 3)
-	//you can't get an instance like following, List is abstract class
-	//val clist = new List[Int]
-	val a1:a = new a                          //> a1  : com.junius.a = com.junius.a@b27bb5
-	val dlist = new ::[a](a1,Nil)             //> dlist  : scala.collection.immutable.::[com.junius.a] = List(com.junius.a@b27
-                                                  //| bb5)
-  //that OK since we have other list List[+T]
-  val b1:b = new b                                //> b1  : com.junius.b = com.junius.b@12ecba8
-  val elist = new ::[a](b1,Nil)                   //> elist  : scala.collection.immutable.::[com.junius.a] = List(com.junius.b@12e
-                                                  //| cba8)
-	
-	//tuple, immutable
-	val triEle = (1,"1",1.0)                  //> triEle  : (Int, String, Double) = (1,1,1.0)
-	println(triEle._1,triEle._2,triEle._3)    //> (1,1,1.0)
-	
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-}
\ No newline at end of file

diff --git a/src/main/scala/org/oneScala/FuturePromise.scala b/src/main/scala/org/oneScala/FuturePromise.scala
deleted file mode 100644
@@ -1,53 +0,0 @@
-package main.scala.org.oneScala
-import scala.concurrent.Future
-import scala.concurrent.Promise
-import scala.util.Try
-import scala.util.Success
-import scala.util.Failure
-
-
-object FuturePromise {
-  def main(args: Array[String]) {
-
-    
-    //define a func to return try.
-    def res(i:Int) : Try[String] = if (i > 0) Success[String]("sucess") else Failure[String](new Exception)
-
-    List(2,-2) map (i => { res(i) match {
-      case Success(_) =>
-        println("call is successful")
-      case Failure(_) =>
-        println("call is failed")
-    }})
-    
-    def res2(str : Try[String]) : Try[String] = str match {
-      case Success(_) =>
-        println("call is successful")
-        Success[String]("sucess")
-      case Failure(_) =>
-        println("call is failed")
-        Failure[String](new Exception)
-    }
-    
-    def strToTry(str : String) : Try[String] = if (str.length() > 2) Success[String]("sucess")
-      else Failure[String](new Exception)
-    def strToStr(str : String) : String = str
-    
-    Success[String]("sucess").flatMap(strToTry)
-    res2(res(-2))
-    res(-2).flatMap(strToTry)
-    println(res(-2).map(strToStr))
-    
-    def resL(i:Int) : Try[List[String]] = if (i > 0) Success[List[String]]("success " :: "success" :: Nil)
-      else Failure[List[String]](new Exception)
-      
-    resL(2) foreach (println _)
-    
-    
-    
-    //val f : Future[List[Int]] = Future(List(1,2,3))
-    
-    //val p = new Promise[List[String]]
-    
-  }
-}
\ No newline at end of file




diff --git a/src/main/scala/org/oneScala/ListOps.scala b/src/main/scala/org/oneScala/ListOps.scala
deleted file mode 100644
@@ -1,54 +0,0 @@
-package com.junius
-import scala.collection.immutable.Set
-import scala.collection.mutable.ListBuffer
-
-object ListOps {
-def main(args: Array[String]) {
-    val lNum : List[Int] = List(1,123,3)
-    val lAlpha : List[Char] = List('a','b','c')
-    val lStr : List[String] = List("hello","world")
-    def listJoin[L,R](left : List[L], right : List[R]) : List[(L,R)] = {
-      for (v <- left; w <- right) yield (v, w)
-    }
-    def listUniqueCount[T](listWords : List[T]) : List[(T,Int)] = {
-      listWords.map(a => (a, 1))
-    }
-    def listCount[T](listCounts : List[(T,Int)]) : (T,Int)= {
-      val discList = listCounts.map(_._1).distinct
-      println(discList)
-      
-      
-      var resultList : ListBuffer[(T,Int)] = new ListBuffer
-      
-      discList.foreach(t => {
-          var geshu : Int = 0
-    	  listCounts.foreach(s => {        
-    		  if(s._1 == t) geshu += s._2          
-        })
-        resultList += ((t,geshu))
-      })
-      println("statistics result as ",resultList.toList)  
-      listCounts.reduce((first , second) => (first._1, first._2 + second._2))
-    }
-    
-    
-    println(lNum.reduceLeft((total,cur) => total + cur))
-    
-    println(listJoin(lNum,lAlpha))
-    println(listJoin(lNum,lStr))
-    
-    println(lNum.reduce((total , cur) => total + cur))
-    
-    println(listCount(listJoin(lStr,lNum)))
-    
-    val lRep : List[Char]= List('a','a','b')
-    val lZip = lRep.zip(lNum)
-    println(lZip)
-    println(listCount(lZip)) 
-    
-    val num = collection.mutable.Map(1 ->2)
-
-    println(num.getOrElse(1, 1 -> 3))
-}
-    //lNum.
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/OptionUsage.scala b/src/main/scala/org/oneScala/OptionUsage.scala
deleted file mode 100644
@@ -1,16 +0,0 @@
-package com.junius
-
-object OptionUsage {
-  def main(args: Array[String]) {
-    def opt(i : Int) : Option[Int] = {
-      if (i>0) return Some(i)
-      else return None
-    }
-    
-    if (opt(8) == Some(8)){
-      println("I am eight")
-    }
-    println("game over")
-  }
-
-}
\ No newline at end of file




diff --git a/src/main/scala/org/oneScala/ScanLeftJ.sc b/src/main/scala/org/oneScala/ScanLeftJ.sc
deleted file mode 100644
@@ -1,52 +0,0 @@
-package com.junius
-import scala.math.BigInt
-
-object ScanLeftJ {
-  //you can see default scan is scan left
-  val res = (1 to 10).scanLeft(0)(_ + _)          //> res  : scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 3, 6, 10, 1
-                                                  //| 5, 21, 28, 36, 45, 55)
-  val res2 = (1 to 10).scanRight(0)(_+_)          //> res2  : scala.collection.immutable.IndexedSeq[Int] = Vector(55, 54, 52, 49, 
-                                                  //| 45, 40, 34, 27, 19, 10, 0)
-  val res3 = (1 to 10).scan(0)(_ + _)             //> res3  : scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 3, 6, 10, 
-                                                  //| 15, 21, 28, 36, 45, 55)
-  
-  //stream is a lazy list, evaluation just happen when it is necessary.
-  lazy val fibs: Stream[Int] = Stream.cons(1, Stream.cons(1, (fibs zip fibs.tail).map(p => p._1 + p._2)))
-                                                  //> fibs: => Stream[Int]
-  val it = fibs.iterator                          //> it  : Iterator[Int] = non-empty iterator
-  //(0 to 10).map( x => println(it.next))
-  fibs(10)                                        //> res0: Int = 89
-  
-  lazy val fib2 : Stream[Int] = 1 #:: 1 #:: (fib2 zip fib2.tail).map(p => p._1 + p._2)
-                                                  //> fib2: => Stream[Int]
-  val fab3 : Stream[Int] = Stream(1,1)            //> fab3  : Stream[Int] = Stream(1, ?)
-  
-  (for( i <- (0 to 1) ; j <- (0 to 1)) yield(i * j)).toList
-                                                  //> res1: List[Int] = List(0, 0, 0, 1)
-  
-  val list1 = List(0,1)                           //> list1  : List[Int] = List(0, 1)
-  val list2 = List(1,2,3)                         //> list2  : List[Int] = List(1, 2, 3)
-  list1 map {x =>
-  	list2 map { y => (x+y)}                   //> res2: List[List[Int]] = List(List(1, 2, 3), List(2, 3, 4))
-  }
-  
-  list1 flatMap {x =>
-  	list2 map { y => (x+y)}                   //> res3: List[Int] = List(1, 2, 3, 2, 3, 4)
-  }
-  
-  val check : Option[List[Int]] = Some(List(1,2,3))
-                                                  //> check  : Option[List[Int]] = Some(List(1, 2, 3))
-  check.map(y => { y.map ( x => {println(x) ; x})}).getOrElse {
-  }                                               //> 1
-                                                  //| 2
-                                                  //| 3
-                                                  //| res4: Any = List(1, 2, 3)
-  
-  val check2 : Option[Int] = None                 //> check2  : Option[Int] = None
-  check2.map(x => x).getOrElse {
-  }                                               //> res5: AnyVal = ()
-  
-  list1 zip list2                                 //> res6: List[(Int, Int)] = List((0,1), (1,2))
-  
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-}
\ No newline at end of file



diff --git a/src/main/scala/org/oneScala/actorUsage.sc b/src/main/scala/org/oneScala/actorUsage.sc
deleted file mode 100644
@@ -1,14 +0,0 @@
-package pracOne
-
-object actorUsage {
-	val count2 : PartialFunction[Any,Unit] = {
-		case "" => println("nothing")
-		case ("","") => println("I am triple")
-		case _ => println("I am default")
-	}                                         //> count2  : PartialFunction[Any,Unit] = <function1>
-	
-	count2.apply("","")                       //> I am triple
-	count2.apply(9)                           //> I am default
-	
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/algorithm.sc b/src/main/scala/org/oneScala/algorithm.sc
deleted file mode 100644
@@ -1,5 +0,0 @@
-
-
-object algorithm {
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/bound.scala b/src/main/scala/org/oneScala/bound.scala
deleted file mode 100644
@@ -1,28 +0,0 @@
-package main.scala.org.oneScala
-class a1{}
-class b1 extends a1{}
-/*
- * variance 是一个class和另外一个class之间是否存在这种parent和child之间的关系，
- * 如果class的模板参数之间有parent和child之间的关系。
- */
-//define variance and de variance classes.
-class c1[+T](t:T){}
-class c2[-T](t:T){}
-//covariance can work together with bounds.
-class c3[+T >: b1 <: a1](t:T){}
-//trait is similar with class. both can be used.
-trait c4[+T >: b1 <: a1]{}
-
-//class c4[T :> a1](){}
-
-object wrapper{
-	//in method, you can use the bound, but covariance not supported
-	def f1[T >: b1 <: a1]() {}
-	//
-	//def f2[+T](t:T){}
-}
-
-object bound {
-	def main(args: Array[String]) { 
-	}
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/classes.sc b/src/main/scala/org/oneScala/classes.sc
deleted file mode 100644
@@ -1,70 +0,0 @@
-package oneScala
-
-import scala.math.BigInt
-
-trait aa{}
-class bb{}
-
-
-
-object classes {
-  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
-  
-  class Interlog() extends aa
-	
-	val log = new Interlog                    //> log  : oneScala.classes.Interlog = oneScala.classes$$anonfun$main$1$Interlog
-                                                  //| $1@1364b53
-//constructors
-  class multiCon(p : Int){
-  	//other constructor
-  	def this(p1 : Int, p2 : Int) = {
-  		this(p1 + p2)
-  	}
-  	val val1 = 0
-  	var var1 = 0
-  	
-  }
-  
-  val m1 = new multiCon(1,2)                      //> m1  : oneScala.classes.multiCon = oneScala.classes$$anonfun$main$1$multiCon$
-                                                  //| 1@c44cfb
-  m1.var1 = 1
-  //class and its data member
-  class data{
-  	val a = 0
-  	var b : Float  = _ //default constructor
-  }
-  val d1 = new data                               //> d1  : oneScala.classes.data = oneScala.classes$$anonfun$main$1$data$1@f82fe7
-                                                  //| 
-  var d2 = new data                               //> d2  : oneScala.classes.data = oneScala.classes$$anonfun$main$1$data$1@111f9b
-                                                  //| 
-  //defautl get/set method for public var variable.
-  class data2{
-  	var a = 0
-  }
-
-  println((new data2).a)                          //> 0
-  (new data2).a_=(1)
- 
-//object and class
-	object com{
-		def high = println("hello high")
-	}
-	
-	class com{
-		def refhigh = com.high
-	}
-	
-	def c = new com                           //> c: => oneScala.classes.com
-	c.refhigh                                 //> hello high
-
-//class and trait
-  trait t1{
-  	def a = println("")
-  }
-  abstract class a1{
-  }
-  class child extends t1{
-  override def a = println("child ")
-  }
- 
-}
\ No newline at end of file



diff --git a/src/main/scala/org/oneScala/major.scala b/src/main/scala/org/oneScala/major.scala
deleted file mode 100644
@@ -1,62 +0,0 @@
-import scala.util.matching.Regex
-import scala.Function1
-
-object library{  
-}
-
-object Email{
-	def apply(u:String,p:String) = u + "@" + p
-	//use Option to define a method can return Some or None.
-	//Some and None is subclass of Option, this way we can avoid
-	//some times function may not necessary to return a value.
-	def unapply(str:String): Option[(String,String)] = {
-	  println("I am a unapply")
-		val parts = str split "@"
-		println("I am a unapply", parts(0),parts(1),parts.length)
-		if (parts.length >= 2) Some(parts(0),parts(1)) else None
-	}
-	//other way to define unapply
-	//def unapply(str:String) : Boolean = str.toUpperCase == str
-	def unapplySeq(str:String): Option[Seq[String]] = {
-	  Some(str.split(".").reverse)
-	}
-}
-
-object major {
-  def main(args: Array[String]) { 
-  	val a:String = "asdf@adads"
-	a match {
-  	  //here a will be given as parameter to unapply method is Email
-  	  //then returm value will match the format u & p 
-  	    case Email("asdf","adads") => println(" a precise ok ")
-		case Email(u,p) => println(" a ok ")
-		case _ => println(" a is not email box ")
-	}
-  	
-  	//other example about regular expression
-  	//val ecimal = new Regex("""(-)?(\d+)(\.\d*)? """.r)
-  	val BookExtractorRE = """Book: title=([^,]+),s+authors=(.+)""".r  
-  	val MagazineExtractorRE = """Magazine: title=([^,]+),s+issue=(.+)""".r  
-  	val catalog = List(    
-  	    "Book: title=Programming Scala, authors=Dean Wampler, Alex Payne",    
-  	    "Magazine: title=The New Yorker, issue=January 2009",    
-  	    "Book: title=War and Peace, authors=Leo Tolstoy",    
-  	    "Magazine: title=The Atlantic, issue=February 2009",    
-  	    "BadData: text=Who put this here??"  )  
-  	for (item <- catalog) {    
-  	  item match {      
-  	    case BookExtractorRE(title, authors) => 
-  	      println("Book " + title + ", written by " + authors)      
-  	    case MagazineExtractorRE(title, issue) => 
-  	      println("Magazine " + title + ", issue " + issue)      
-  	    case entry => println("Unrecognized entry: " + entry)    
-  	    }  
-  	  }
-  	//println(sign,inter,deci)
-    println("I am a companion")
- }
-}
-
-class major {
-	
-}
\ No newline at end of file




diff --git a/src/main/scala/org/oneScala/methodInObject.scala b/src/main/scala/org/oneScala/methodInObject.scala
deleted file mode 100644
@@ -1,44 +0,0 @@
-package pracOne
-//method defined in object can be called.
-object AA {
-	def aa(a: Int){println(a)}
-}
-//apply actually like function object's override ()method.
-class BB{
-  	def apply(a: String){println(a)}
-  	def okok(a: String){println(a)}  	
-}
-object BB{
-  implicit def string2bb(str : String) : BB = {val bb = new BB
-    println("a")
-    	bb}
-}
-//view bound
-class CC{
-  def callBBviaCC[CC <% BB](cc : CC) = cc.okok("view bound")
-  
-}
-//must define implicit method in object
-object CC{
-  implicit def cc2bb(cc : CC): BB = {val bb = new BB; bb}
-}
-object methodInObject {
-	  def main(args: Array[String]) { 
-	  AA.aa(2)
-	  val b = new BB
-	  b("joj")
-	  //view bound
-	  def callBBviaCC[CC <% BB](cc : CC) : Unit = {cc.okok("view bound")}
-	  val dd = new CC
-	  def fff(bb : BB) = {println("a")}
-	  fff(dd)
-	  callBBviaCC[CC](dd)
-	  
-	  val str = ""
-	    
-	  def bbHello(b : BB) = println("abbbb")
-	  bbHello("sdfsadf")
-	  val a5:BB = new BB
-	  //@volatile var b5:BB = _
-	}
-}
\ No newline at end of file





diff --git a/src/main/scala/org/oneScala/myClass.scala b/src/main/scala/org/oneScala/myClass.scala
deleted file mode 100644
@@ -1,59 +0,0 @@
-package com.junius
-import scala.collection.immutable.Stream
-
-class Duck {
-  def makeDuckNoise() = "gua gua"
-}
-
-class Chicken {
-  def makeChickenNoise() = "ge ge"
-}
-
-class Ducken(chicken: Chicken) extends Duck {
-  override def makeDuckNoise() = chicken.makeChickenNoise()
-}
-class PaClass(childData:Int){}
-
-class TtClass(data : Int) extends PaClass(data){
-  def prnt() = {
-    println(data)
-  }  
-}
-
-object myClass {
-  private var _interp: Int = _
-  def interp = _interp
-  def interp_= (i: Int) { _interp = i }
-
-  def main(args: Array[String]) {
-	  //if _interp not inited, the value is 0
-        println(_interp)
-      
-      //implict
-      //if we want to call a function, the parameter is class a.
-      //and a can be constructed from an object of class b.
-      //then we can call this function with object of class b if we
-       //define a implicit conversion function.
-      implicit def chickenToDuck(chicken: Chicken) = new Ducken(chicken)
-
-      def giveMeADuck(duck: Duck) = duck.makeDuckNoise()
-      giveMeADuck(new Duck)
-      giveMeADuck(new Ducken(new Chicken))
-      giveMeADuck(new Chicken)  
-      
-      val tt = new TtClass(18)
-      tt.prnt()
-      val res = (0 to 10).scan(0)(_+_)
-      
-      val a:Stream[Int] = Stream(0,1)
-      val it = a.iterator
-      while (it.hasNext)
-        println(it.next)
-        
-      lazy val fibs: Stream[Int] = Stream.cons(1, (fibs zip fibs.tail).map(p => p._1 + p._2))
-      val list1 : List[Int] = List(1,2,3)
-      list1.toStream.append(Stream(4)).toList
-      
-  }
-
-}
\ No newline at end of file


diff --git a/src/main/scala/org/oneScala/parameterPoly.scala b/src/main/scala/org/oneScala/parameterPoly.scala
deleted file mode 100644
@@ -1,57 +0,0 @@
-package oneScala
-
-package fineqtbull.customer
-
-class Publication(val title: String)
-
-class Book(title: String) extends Publication(title)
-
-object Library {
-
-    val books: Set[Book] =
-        Set(
-            new Book("Programming in Scala"),
-            new Book("Walden")
-        )
-
-    def printBookList(info: Book => AnyRef) {
-        assert(info.isInstanceOf[Function1[_, _]])
-
-        for (book <- books)
-            println(info(book))
-    }
-
-    def printBokkListByTrait[P >: Book, R <: AnyRef](
-            action : GetInfoAction[P, R]) {
-
-        for (book <- books)
-            println(action(book))
-    }
-
-}
-
-trait GetInfoAction[ P >: Book, R <: AnyRef] {
-
-   def apply(book : P) : R
-}
-
-object Customer extends Application {
-
-    def getTitle(p: Publication): String = p.title
-
-    Library.printBookList(getTitle)
-
-
-    Library.printBokkListByTrait(new GetInfoAction[Publication, String] {
-            def apply(p: Publication) : String = p.title })
-}
-
-
-trait Function1[-S, +T] {
-  def apply(x: S): T
-}
-
-
-
-
-










