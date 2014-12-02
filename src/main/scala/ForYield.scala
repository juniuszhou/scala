package main.scala
/*
1) This

for(x <- c1; y <- c2; z <-c3) {...}
is translated into

c1.foreach(x => c2.foreach(y => c3.foreach(z => {...})))
2) This

for(x <- c1; y <- c2; z <- c3) yield {...}
is translated into

c1.flatMap(x => c2.flatMap(y => c3.map(z => {...})))
3) This

for(x <- c; if cond) yield {...}
is translated on Scala 2.7 into

c.filter(x => cond).map(x => {...})
or, on Scala 2.8, into

c.withFilter(x => cond).map(x => {...})
with a fallback into the former if method withFilter is not available but filter is. Please see the edit below for more information on this.

4) This

for(x <- c; y = ...) yield {...}
is translated into

c.map(x => (x, ...)).map((x,y) => {...})
When you look at very simple for comprehensions, the map/foreach alternatives look, indeed, better. Once you start composing them, though, you can easily get lost in parenthesis and nesting levels. When that happens, for comprehensions are usually much clearer.

I'll show one simple example, and intentionally ommit any explanation. You can decide which syntax was easier to understand.

l.flatMap(sl => sl.filter(el => el > 0).map(el => el.toString.length))
or

for{
  sl <- l
  el <- sl
  if el > 0
} yield el.toString.length
EDIT

Scala 2.8 introduced a method called withFilter, whose main difference is that, instead of returning a new, filtered, collection, it filters on-demand. The filter method has its behavior defined based on the strictness of the collection. To understand this better, let's take a look at some Scala 2.7 with List (strict) and Stream (non-strict):

scala> var found = false
found: Boolean = false

scala> List.range(1,10).filter(_ % 2 == 1 && !found).foreach(x => if (x == 5) found = true else println(x))
1
3
7
9

scala> found = false
found: Boolean = false

scala> Stream.range(1,10).filter(_ % 2 == 1 && !found).foreach(x => if (x == 5) found = true else println(x))
1
3
The difference happens because filter is immediately applied with List, returning a list of odds -- since found is false. Only then foreach is executed, but, by this time, changing found is meaningless, as filter has already executed.

In the case of Stream, the condition is not immediatelly applied. Instead, as each element is requested by foreach, filter tests the condition, which enables foreach to influence it through found. Just to make it clear, here is the equivalent for-comprehension code:

for (x <- List.range(1, 10); if x % 2 == 1 && !found)
  if (x == 5) found = true else println(x)

for (x <- Stream.range(1, 10); if x % 2 == 1 && !found)
  if (x == 5) found = true else println(x)
This caused many problems, because people expected the if to be considered on-demand, instead of being applied to the whole collection beforehand.

Scala 2.8 introduced withFilter, which is always non-strict, no matter the strictness of the collection. The following example shows List with both methods on Scala 2.8:

scala> var found = false
found: Boolean = false

scala> List.range(1,10).filter(_ % 2 == 1 && !found).foreach(x => if (x == 5) found = true else println(x))
1
3
7
9

scala> found = false
found: Boolean = false

scala> List.range(1,10).withFilter(_ % 2 == 1 && !found).foreach(x => if (x == 5) found = true else println(x))
1
3
 */


object ForYield {
  def main (args: Array[String]) {
    val l1 = List(1,2,3)
    val l2 = List(4,5,6)

    // in scala , for just a syntax sugar. if just for, then it will be replaced by foreach.
    // if for with yield , then be replaced by map.
    val l6 = for(i1 <- l1; i2 <- l2) yield {
      (i1.toString + " " + i2)
    }
    l6.foreach(println)
  }
}
