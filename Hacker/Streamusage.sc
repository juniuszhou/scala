import scala.collection.immutable.Stream
import scala.collection.immutable.Stream.cons

def constant[A](a: A): Stream[A] = cons(a, constant(a))
constant(5).take(5).toList                        //> res1: List[Int] = List(5, 5, 5, 5, 5)

def from(n: Int): Stream[Int] = cons(n, from(n+1))//> from: (n: Int)ch5.genstream.Stream[Int]
from(5).take(5).toList                            //> res2: List[Int] = List(5, 6, 7, 8, 9)

def fibs: Stream[Int] = {
  def go (prev: Int, cur: Int): Stream[Int] = {
    cons(prev,go(cur,prev + cur))
  }
  go(0,1)
}                                                 //> fibs: => ch5.genstream.Stream[Int]
fibs.take(5).toList                               //> res3: List[Int] = List(0, 1, 1, 2, 3)

def repList(i: Int) : List[Int] = i :: repList(i)
// repList(5) over flow.
